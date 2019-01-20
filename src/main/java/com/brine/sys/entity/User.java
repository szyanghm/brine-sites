package com.brine.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.brine.sys.common.valid.group.UserEditValidGroup;
import com.brine.sys.common.valid.group.UserLoginValidGroup;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author brine-yang
 * @since 2018-12-06
 */
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 帐号
     */
    @NotNull(message = "帐号不能为空", groups = { UserLoginValidGroup.class, UserEditValidGroup.class })
    private String account;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空", groups = { UserLoginValidGroup.class, UserEditValidGroup.class })
    private String password;

    /**
     * 昵称
     */
    @NotNull(message = "用户名不能为空", groups = { UserEditValidGroup.class })
    private String username;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date regTime;

    private String verify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
