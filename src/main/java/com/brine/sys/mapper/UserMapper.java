package com.brine.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brine.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author brine-yang
 * @since 2018-12-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getByUserAccount(@Param("account") String account);
}
