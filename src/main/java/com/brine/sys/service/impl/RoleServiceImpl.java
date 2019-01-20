package com.brine.sys.service.impl;

import com.brine.sys.entity.Role;
import com.brine.sys.mapper.RoleMapper;
import com.brine.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
