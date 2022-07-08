package com.sakura.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @TableId("user_id")
    private Integer userId; // 用户id
    private String userName; // 用户名
    @TableField(value = "user_pass")
    private String password;//用户密码
    private String userEmail;//邮箱
    private String userPhone; // 电话
    private Date userBirth;//出生年月(生日)
    private String userQq;//qq 第三方授权登录 凭证
    private String userGitee;//gitee 第三方授权登录 凭证

    @TableField(exist = false)
    private List<GrantedAuthority> authorities;


    @Override
    public String getUsername() {
        return userName;
    }

    //继承后必须返回为true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //不能返回null
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    //默认使用恒等去判断是否是同一个对象，因为登录的同一个用户，如果再次登录就会封装
    //一个新的对象，这样会导致登录的用户永远不会相等，所以需要重写equals方法
    @Override
    public boolean equals(Object obj) {
        //会话并发生效，使用username判断是否是同一个用户

        if (obj instanceof User) {
            //字符串的equals方法是已经重写过的
            return ((User) obj).getUsername().equals(this.userName);
        } else {
            return false;
        }


    }

}
