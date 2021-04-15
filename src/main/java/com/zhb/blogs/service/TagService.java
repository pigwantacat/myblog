package com.zhb.blogs.service;

import com.zhb.blogs.pojo.Tag;

import java.util.List;

public interface TagService {

    int saveTag(Tag tag);//新增

    Tag getTagById(Long id);//通过id获取

    Tag getTagByName(String name);//通过名称获取

    List<Tag> getAllTag();//获取所有

    List<Tag> getBlogTag();//首页展示博客标签

    List<Tag> getTagByString(String text);   //从字符串中获取tag集合

    int updateTag(Tag tag);//更新

    int deleteTag(Long id);//删除
}
