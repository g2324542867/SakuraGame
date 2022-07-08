package com.sakura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 作为【统一】结果返回到前端
@Data
public class ResultDTO<T>
{
    private boolean success;
    private String message;
    private T data;
    
    // 成功返回的【工厂】方法
    public static <R> ResultDTO<R> success(R data)
    {
        ResultDTO<R> result = new ResultDTO<>();
        result.setSuccess(true);
        result.setMessage("操作成功！");
        result.setData(data);
        return result;
    }
    
    // 失败返回的【工厂】方法
    public static <R> ResultDTO<R> fail(String message)
    {
        ResultDTO<R> result = new ResultDTO<>();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
