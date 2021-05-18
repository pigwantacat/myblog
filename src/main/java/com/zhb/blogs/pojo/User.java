package com.zhb.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Long id;
    private String nickname;
    private String username;//用户名
    private String password;
    private String email;
    private String avatar;//头像
    private Integer type;//身份
    private Date createTime;
    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();

    public Collection<? extends GrantedAuthority> getRole(){
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                if (1==type){
                    return "ADMIN";//管理员
                }else {
                    return "USER";//用户
                }
            }
        });
        return list;
    }
}
