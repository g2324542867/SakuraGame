package com.sakura.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakura.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper extends BaseMapper<User> {
}
