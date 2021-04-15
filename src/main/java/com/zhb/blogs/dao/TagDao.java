package com.zhb.blogs.dao;

import com.zhb.blogs.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagDao {

    int saveTag(Tag tag);//新增

    Tag getTagById(Long id);//通过id获取

    Tag getTagByName(String name);//通过名称获取

    List<Tag> getAllTag();//获取所有

    List<Tag> getBlogTag();//首页展示博客标签

    int updateTag(Tag tag);//更新

    int deleteTag(Long id);//删除
}
