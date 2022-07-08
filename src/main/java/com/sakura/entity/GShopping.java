package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("g_shopping")
@AllArgsConstructor
@NoArgsConstructor
public class GShopping {
    @TableId("g_id")
    private Integer gId;
    private Integer gTypeId;
    private String gName;
    private Double gPrice;
    private String gMakers;
    private Date gDate;
    private Integer gRank;
    private String gIntro;
    private String gImgUrl;
    private String gVideoUrl;
    private String gLabel;
    private String gState;
    private String gConfig;
    private Double gScore;
}
