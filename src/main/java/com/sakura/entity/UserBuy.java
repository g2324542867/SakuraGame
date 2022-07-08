package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("user_buy")
@AllArgsConstructor
@NoArgsConstructor
public class UserBuy {
    @TableId("b_id")
    private Integer bId;
    private Integer gameId;
    private Integer uId;
}
