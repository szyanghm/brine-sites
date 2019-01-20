package com.brine.sys.common.security;

import com.brine.sys.common.Constants;
import com.brine.sys.entity.Permission;
import com.brine.sys.entity.Role;
import com.brine.sys.entity.User;
import com.brine.sys.mapper.PermissionMapper;
import com.brine.sys.mapper.RoleMapper;
import com.brine.sys.mapper.UserMapper;
import com.brine.sys.utils.JedisUtil;
import com.brine.sys.utils.JwtUtil;
import com.brine.sys.utils.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @date: 2019/1/11 0011 下午 4:00
 */
@Service
public class UserRealm extends AuthorizingRealm {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;

    @Autowired
    public UserRealm(UserMapper userMapper, RoleMapper roleMapper, PermissionMapper permissionMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
    }

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String account = JwtUtil.getClaim(principals.toString(), Constants.ACCOUNT);
        User user = new User();
        user.setAccount(account);
        // 查询用户角色
        List<Role> roles = roleMapper.findRoleByUser(user);
        for (int i = 0, roleLen = roles.size(); i < roleLen; i++) {
            Role role = roles.get(i);
            // 添加角色
            simpleAuthorizationInfo.addRole(role.getName());
            // 根据用户角色查询权限
            List<Permission> permissions = permissionMapper.findPermissionByRole(role);
            for (int j = 0, perLen = permissions.size(); j < perLen; j++) {
                Permission permission = permissions.get(j);
                // 添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPerCode());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得account，用于和数据库进行对比
        String account = JwtUtil.getClaim(token, Constants.ACCOUNT);
        // 帐号为空
        if (StringUtil.isBlank(account)) {
            throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
        }
        // 查询用户是否存在
        User user = userMapper.getByUserAccount(account);
        if (user == null) {
            throw new AuthenticationException("该帐号不存在(The account does not exist.)");
        }
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        if (JwtUtil.verify(token) && JedisUtil.exists(Constants.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
            // 获取RefreshToken的时间戳
            String currentTimeMillisRedis = JedisUtil.getObject(Constants.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            if (JwtUtil.getClaim(token, Constants.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, "userRealm");
            }
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}
