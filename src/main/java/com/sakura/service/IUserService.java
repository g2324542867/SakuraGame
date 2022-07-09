package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sakura.entity.User;

public interface IUserService extends IService<User> {

    // 用户注册
    public Boolean registerUser(User user);
}
