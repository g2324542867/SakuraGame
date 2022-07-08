package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("g_wish")
@AllArgsConstructor
@NoArgsConstructor
public class GWish {
    @TableId("g_wish_id")
    private Integer gWishId;
    private Integer uId;
    private Integer gameId;
}
