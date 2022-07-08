package com.sakura.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakura.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRoleMapper extends BaseMapper<UserRole> {
}
