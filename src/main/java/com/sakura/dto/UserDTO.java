package com.sakura.dto;

import com.alipay.api.domain.UserDetails;
import com.alipay.api.internal.mapping.ApiField;
import com.sakura.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

/*
这是一个DTO，只需要保留合适的字段即可
使用JSON时发送到前端
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class UserDTO
{
    private Integer userId; // 用户id
    private String userEmail; // 邮箱
    private String userPhone; // 电话
    private Date userBirth; // 出生年月(生日)


    
    // User转UserDTO的静态【工厂】方法
/*    public static UserDTO fromUser(User user)
    {
        return new UserDTO(user.getUserId(), user.getUserName(), user.getUserEmail(), user.getUserPhone(), user.getUserBirth());
    }*/
}
