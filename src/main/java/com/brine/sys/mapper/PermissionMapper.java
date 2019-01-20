package com.brine.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brine.sys.entity.Permission;
import com.brine.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findPermissionByRole(Role role);
}
