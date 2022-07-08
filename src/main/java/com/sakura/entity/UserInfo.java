package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @TableId("user_info_id")
    private Integer userInfoId;
    private Integer uId;
    private String userAddress;
    private Double userMoney;
    private String userIntro;
}
