package com.brine.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brine.sys.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author brine-yang
 * @since 2018-12-06
 */
public interface UserService extends IService<User> {

    User getByUserAccount(String account);
}
