package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("g_type")
@AllArgsConstructor
@NoArgsConstructor
public class GType {
    @TableId("g_type_id")
    private Integer gTypeId;
    private String gTypeName;
}
