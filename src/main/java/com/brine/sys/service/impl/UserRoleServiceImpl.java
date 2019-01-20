package com.brine.sys.service.impl;

import com.brine.sys.entity.UserRole;
import com.brine.sys.mapper.UserRoleMapper;
import com.brine.sys.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
