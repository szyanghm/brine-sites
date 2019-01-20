package com.brine.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brine.sys.entity.User;
import com.brine.sys.mapper.UserMapper;
import com.brine.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @date: 2019/1/17 0017 下午 3:01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getByUserAccount(String account){
        return userMapper.getByUserAccount(account);
    }

}
