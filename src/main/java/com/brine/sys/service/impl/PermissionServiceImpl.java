package com.brine.sys.service.impl;

import com.brine.sys.entity.Permission;
import com.brine.sys.mapper.PermissionMapper;
import com.brine.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
