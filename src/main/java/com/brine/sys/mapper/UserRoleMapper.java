package com.brine.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brine.sys.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
