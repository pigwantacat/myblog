package com.zhb.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;//评论内容
    private String avatar;//头像
    private Date createTime;

    private boolean adminComment;  //是否为管理员评论
    private Long blogId;
    private Long parentCommentId;  //父评论id
    private String parentNickname;
    private Comment parentComment;//父评论
    private Blog blog;
}
