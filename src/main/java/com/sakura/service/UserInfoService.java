package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.UserInfo;
import com.sakura.mapper.IUserInfoMapper;
import com.sakura.service.IUserInfoService;

public class UserInfoService extends ServiceImpl<IUserInfoMapper, UserInfo> implements IUserInfoService {
}
