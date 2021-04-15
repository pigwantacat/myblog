package com.zhb.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 把博客和标签关系存到数据库中使用的类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogAndTag {
    private Long tagId;
    private Long blogId;
}
