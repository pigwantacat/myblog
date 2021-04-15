package com.zhb.blogs.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhb.blogs.pojo.Tag;
import com.zhb.blogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){ //列表展示页面
        PageHelper.startPage(pagenum, 5);
        List<Tag> allTag = tagService.getAllTag();
        //得到分页结果对象
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String toAddTag(Model model){
        //返回一个tag对象给前端th:object,因为当进入tag-input.html时它会请求获取一个tag对象
        //为了满足修改tag操作的前一步：查看tag
        model.addAttribute("tag", new Tag());
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String addTag(Tag tag, RedirectAttributes attributes){ //添加tag
        Tag t = tagService.getTagByName(tag.getName());
        if(t != null){
            attributes.addFlashAttribute("msg","不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }else {
            attributes.addFlashAttribute("msg","添加成功");
        }
        tagService.saveTag(tag);
        return "redirect:/admin/tags"; //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
    }

    @GetMapping("/tags/{id}/input")
    public String toEditTag(@PathVariable Long id, Model model){  //获取对应的tag信息并转发至修改页面
        model.addAttribute("tag", tagService.getTagById(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags/{id}")
    public String editTag(@PathVariable Long id, Tag tag, RedirectAttributes attributes){  //修改
        Tag t = tagService.getTagByName(tag.getName()); //这里不能使用byid方法，因为此方法查出的t永不为null
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/tags/"+tag.getId()+"/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        tagService.updateTag(tag);
        return "redirect:/admin/tags";   //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/tags";
    }
}
