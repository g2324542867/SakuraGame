package com.sakura.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sakura.entity.UserRole;
import com.sakura.service.IRoleService;
import com.sakura.service.IUserRoleService;
import com.sakura.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameUserDetailService implements UserDetailsService {

    // 密码加密
    private final PasswordEncoder encoder;
    private final IUserService userService;
    private final IUserRoleService userRoleService;
    private final IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.sakura.entity.User user = userService.getOne(new QueryWrapper<com.sakura.entity.User>().eq("user_name", username));

        if (user == null){
            throw  new RuntimeException("该用户不存在");
        }

        // 查询数据库 添加角色 （角色设置 ROLE_xxx 数据库字段属性即可）
        String name = username;
        String password = user.getPassword();
        StringBuffer authorities = new StringBuffer();
        List<UserRole> userRoles = userRoleService.list(new QueryWrapper<>(new UserRole(null, user.getUserId())));
        List<Integer> collect = userRoles.stream().map(s -> s.getRoleId()).collect(Collectors.toList());
        List<String> roleList = roleService.listByIds(collect).stream().map(s -> s.getRoleName()).collect(Collectors.toList());

        for (String s : roleList) {
            authorities.append("ROLE_").append(s).append(",");
        }

        com.sakura.entity.User u = new com.sakura.entity.User();

        //
        u.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(authorities)));
        u.setPassword(encoder.encode(password));
        u.setUserName(username);
        u.setUserId(user.getUserId());
        u.setUserBirth(user.getUserBirth());
        u.setUserPhone(user.getUserPhone());
        u.setUserEmail(user.getUserEmail());

        // 返回user对象
        return u;
    }
}
