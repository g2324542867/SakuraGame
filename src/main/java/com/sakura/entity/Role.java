package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @TableId("role_id")
    private Integer roleId;
    private String roleName;
}
