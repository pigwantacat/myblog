package com.zhb.blogs.service;

import com.zhb.blogs.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
