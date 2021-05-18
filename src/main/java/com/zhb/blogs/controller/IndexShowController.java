package com.zhb.blogs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhb.blogs.pojo.Blog;
import com.zhb.blogs.pojo.Tag;
import com.zhb.blogs.pojo.Type;
import com.zhb.blogs.service.BlogService;
import com.zhb.blogs.service.TagService;
import com.zhb.blogs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexShowController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping({"/","/index","/index.html"})
    public String getIndex(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){
        PageHelper.startPage(pagenum, 10);
        List<Blog> allBlog = blogService.getIndexBlog();
        List<Type> allType = typeService.getBlogType().subList(0,5);  //获取博客的类型(联表查询)
        List<Tag> allTag = tagService.getBlogTag().subList(0,6);  //获取博客的标签(联表查询)
        List<Blog> recommendBlog =blogService.getAllRecommendBlog();  //获取推荐博客

        //得到分页结果对象
        PageInfo pageInfo = new PageInfo(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs", recommendBlog);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,
                         @RequestParam String query, Model model){
        PageHelper.startPage(pagenum, 10);
        List<Blog> searchBlog = blogService.getSearchBlog(query);

        PageInfo pageInfo = new PageInfo(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String toLogin(@PathVariable Long id, Model model){
        blogService.updateViewsById(id);
        Blog blog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", blog);
        return "blog";
    }
}
