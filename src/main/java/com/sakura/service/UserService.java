package com.sakura.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.entity.User;
import com.sakura.entity.UserRole;
import com.sakura.mapper.IUserMapper;
import com.sakura.mapper.IUserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService extends ServiceImpl<IUserMapper, User> implements IUserService {

    private final IUserMapper userMapper;
    private final IUserRoleMapper userRoleMapper;

    /**
     * 用户通过表单注册 并且 关联权限表
     * @param user 用户注册身份信息
     * @return
     */
    @Override
    @Transactional
    public Boolean registerUser(User user) {

        int insert = userMapper.insert(user);
        int userRole = userRoleMapper.insert(new UserRole(null, user.getUserId()));
        if (userRole <= 0){
            return false;
        }

        return true;
    }
}
