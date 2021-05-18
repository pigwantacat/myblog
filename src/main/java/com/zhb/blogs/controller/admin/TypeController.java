package com.zhb.blogs.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhb.blogs.pojo.Type;
import com.zhb.blogs.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){ //列表展示页面
        PageHelper.startPage(pagenum, 10);
        List<Type> allType = typeService.getAllType();
        //得到分页结果对象
        PageInfo<Type> pageInfo = new PageInfo<Type>(allType);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String toAddType(Model model){
        //返回一个type对象给前端th:object,因为当进入type-input.html时它会请求获取一个Type对象
        //为了满足修改Type操作的前一步：查看Type
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String addType(Type type, RedirectAttributes attributes){ //添加Type
        Type t = typeService.getTypeByName(type.getName());
        if(t != null){
            attributes.addFlashAttribute("msg","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            attributes.addFlashAttribute("msg","添加成功");
        }
        typeService.saveType(type);
        return "redirect:/admin/types"; //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/types/{id}/input")
    public String toEditType(@PathVariable Long id, Model model){  //获取对应的type信息并转发至修改页面
        model.addAttribute("type", typeService.getTypeById(id));
        return "admin/types-input";
    }

    @PostMapping("/types/{id}")
    public String editType(@PathVariable Long id, Type type, RedirectAttributes attributes){  //修改
        Type t = typeService.getTypeByName(type.getName()); //这里不能使用byid方法，因为此方法查出的t永不为null
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/types/"+type.getId()+"/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        typeService.updateType(type);
        return "redirect:/admin/types";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/types";
    }
}
