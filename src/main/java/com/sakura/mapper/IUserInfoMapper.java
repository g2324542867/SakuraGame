package com.sakura.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakura.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserInfoMapper extends BaseMapper<UserInfo> {
}
