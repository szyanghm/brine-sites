package com.brine.sys.controller;


import com.brine.sys.common.Constants;
import com.brine.sys.common.exception.CustomException;
import com.brine.sys.common.exception.CustomUnauthorizedException;
import com.brine.sys.common.valid.group.UserLoginValidGroup;
import com.brine.sys.common.vo.ResultVO;
import com.brine.sys.entity.User;
import com.brine.sys.service.UserService;
import com.brine.sys.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author brine-yang
 * @since 2018-12-06
 */
@Controller
@RequestMapping("/sys")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(Model model){
        User user = userService.getById("1");
        model.addAttribute("user",user);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVO<Object> login(@Validated(UserLoginValidGroup.class) @RequestBody User user,
                                  HttpServletResponse response,HttpServletRequest request){
        String ip = BrineSitesUtil.getIpAddr(request);
        // 查询数据库中的帐号信息
        User atuser = userService.getByUserAccount(user.getAccount());
        String strCode = JedisUtil.getJson(ip+user.getAccount());
        int code  = 0;
        if(strCode!=null){
            code = Integer.parseInt(strCode);
        }
        if(code>=3){
            //校验验证码
            HttpSession session = request.getSession();
            String verify = (String) session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if (StringUtils.isEmpty(user.getVerify()) || !verify.equals(user.getVerify())){
                throw new CustomUnauthorizedException("验证码输入错误(Account or Password Error.)");
            }
        }

        if (atuser == null) {
            //记录账户密码输入的错误次数
            recordCode(response,code,user.getAccount(),ip);
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
            //return new ResultVO<Object>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "该帐号不存在(The account does not exist.)", null);
        }

        try {
            String pwd = AesCipherUtil.enCrypto(user.getAccount()+user.getPassword());
            boolean success  = Pbkdf2Utils.verifyPassword(pwd,atuser.getPassword());
            if(!success){
                //记录账户密码输入的错误次数
                recordCode(response,code,user.getAccount(),ip);
                throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
            }
        } catch (Exception e) {
            //记录账户密码输入的错误次数
            recordCode(response,code,user.getAccount(),ip);
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }


        // 清除可能存在的Shiro权限信息缓存
        if (JedisUtil.exists(Constants.PREFIX_SHIRO_CACHE + user.getAccount())) {
            JedisUtil.delKey(Constants.PREFIX_SHIRO_CACHE + user.getAccount());
        }
        // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        //RefreshToken过期时间
        String refreshTokenExpireTime = GlobalUtil.getConfig("refreshTokenExpireTime");
        JedisUtil.setObject(Constants.PREFIX_SHIRO_REFRESH_TOKEN + user.getAccount(), currentTimeMillis,  Integer.parseInt(refreshTokenExpireTime));
        // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
        String token = JwtUtil.sign(user.getAccount(), currentTimeMillis);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return new ResultVO<Object>(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
            System.out.println(randomValidateCode);
        } catch (Exception e) {
            throw new CustomException("获取验证码失败>>>> ");
        }
    }


    @RequestMapping(value = "/page/{path}")
    public String common(@PathVariable("path") String path){
        System.out.println(path);
        return path;
    }

    /**
     * 剔除在线用户
     * @param request
     * @param httpServletResponse
     * @return
     */
    @DeleteMapping("/online/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResultVO<Object> deleteOnline(HttpServletRequest request,HttpServletResponse httpServletResponse) {
        String token = request.getHeader("Authorization");
        User userDto = null;
        if (JedisUtil.exists(Constants.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount())) {
            if (JedisUtil.delKey(Constants.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount()) > 0) {
                return new ResultVO<Object>(HttpStatus.OK.value(), "剔除成功(Delete Success)", null);
            }
        }
        throw new CustomException("剔除失败，Account不存在(Deletion Failed. Account does not exist.)");
    }


    /**
     * 退出登录
     * @return
     */
    @ResponseBody
    @RequestMapping("/outlogin")
    public ResultVO<Object> outlogin(@RequestBody String token) {
        String account = JwtUtil.getClaim(token,Constants.ACCOUNT);
        // 查询数据库中的帐号信息
        User atuser = userService.getByUserAccount(account);
        if (atuser == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        if (JedisUtil.exists(Constants.PREFIX_SHIRO_REFRESH_TOKEN + atuser.getAccount())) {
            if (JedisUtil.delKey(Constants.PREFIX_SHIRO_REFRESH_TOKEN + atuser.getAccount()) > 0) {
                Subject subject = SecurityUtils.getSubject();
                subject.logout();
                return new ResultVO<Object>(HttpStatus.OK.value(), "剔除成功(Delete Success)", null);
            }
        }
        throw new CustomException("剔除失败，Account不存在(Deletion Failed. Account does not exist.)");
    }

    /**
     * 测试登录
     * @param
     * @return com.wang.model.common.ResponseBean
     * @author Wang926454
     * @date 2018/8/30 16:18
     */
    @ResponseBody
    @GetMapping("/article")
    public ResultVO<Object> article() {
        Subject subject = SecurityUtils.getSubject();
        // 登录了返回true
        if (subject.isAuthenticated()) {
            return new ResultVO<Object>(HttpStatus.OK.value(), "您已经登录了(You are already logged in)", null);
        } else {
            return new ResultVO<Object>(HttpStatus.OK.value(), "你是游客(You are guest)", null);
        }
    }

    /**
     * 记录账户密码输入的错误次数
     * @param response
     * @param code 错误次数
     * @param account 用户账号
     * @param ip 用户ip
     */
    public static void recordCode(HttpServletResponse response,int code,String account,String ip){
        if(code>=0){
            code+=1;
        }
        CookieUtils.setCookie(response,account+Constants.VERIF_CODE,String.valueOf(code),0);
        JedisUtil.setJson(ip+account,String.valueOf(code),60);
    }

}

