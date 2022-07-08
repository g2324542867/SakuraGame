package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Integer roleId;
    private Integer uId;
}
