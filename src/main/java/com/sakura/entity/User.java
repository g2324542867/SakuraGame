package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId("user_id")
    private Integer userId;//用户id
    private String userName;//用户名
    private String userPass;//用户密码
    private String userEmail;//邮箱
    private Date userBirth;//出生年月(生日)
    private String userQQ;//qq 第三方授权登录 凭证
    private String userGitee;//gitee 第三方授权登录 凭证

}
