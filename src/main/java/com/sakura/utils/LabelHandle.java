package com.sakura.utils;

// 处理数据库游戏标签 拆分和拼接的工具类

import java.util.Arrays;
import java.util.List;

public class LabelHandle {

    /**
     * 拆分
     * @param label 数据库存储标签的数组字符串
     * @return
     */
    public static List<String> split(String label){
        if (label == null || label.isEmpty()){
            return null;
        }

        label = label.substring(1,label.length()-1);
        return Arrays.asList(label.split(","));
    }

    /**
     * 拼接
     * @param label 标签的数组转为字符串
     * @return
     */
    public static String splicing(List<String> label){
        if (label.size() == 0){
            return "";
        }
        
        return String.valueOf(label.toString());
    }
}
