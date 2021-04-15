package com.zhb.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
