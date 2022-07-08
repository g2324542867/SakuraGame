package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.UserRole;
import com.sakura.mapper.IUserRoleMapper;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends ServiceImpl<IUserRoleMapper, UserRole> implements IUserRoleService {
}
