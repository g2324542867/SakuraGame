package com.sakura.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.Role;
import com.sakura.mapper.IRoleMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceImpl<IRoleMapper,Role> implements IRoleService {

}
