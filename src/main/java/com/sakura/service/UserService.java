package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.User;
import com.sakura.mapper.IUserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<IUserMapper, User> implements IUserService {

}
