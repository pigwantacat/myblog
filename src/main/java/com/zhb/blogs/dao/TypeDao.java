package com.zhb.blogs.dao;

import com.zhb.blogs.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDao{

    int saveType(Type type);//新增

    Type getTypeById(Long id);//通过id获取

    Type getTypeByName(String name);//通过名称获取

    List<Type> getAllType();//获取所有

    List<Type> getBlogType();  //首页右侧展示type对应的博客数量

    int updateType(Type type);//更新

    int deleteType(Long id);//删除
}
