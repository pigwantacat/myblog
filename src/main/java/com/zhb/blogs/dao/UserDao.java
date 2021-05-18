package com.zhb.blogs.dao;

import com.zhb.blogs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    @Select("select * from blog.t_user where username = #{username};")
    User queryUserByUsername(@Param("username")String username);
}
