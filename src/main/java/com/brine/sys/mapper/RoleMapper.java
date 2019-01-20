package com.brine.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brine.sys.entity.Role;
import com.brine.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findRoleByUser(User user);
}
