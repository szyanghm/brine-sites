package com.brine.sys.common.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: Administrator
 * @date: 2019/1/11 0011 下午 3:47
 */
public class JwtToken implements AuthenticationToken {

    /**
     * Token
     */
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
