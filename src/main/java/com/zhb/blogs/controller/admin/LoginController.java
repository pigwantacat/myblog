package com.zhb.blogs.controller.admin;

import com.zhb.blogs.pojo.User;
import com.zhb.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String toLoginPage(){
        return "admin/login";
    }

    /*@PostMapping("/login")
    public String toLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          RedirectAttributes attributes){
        //使用BCryptPasswordEncoder加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = userService.findUserByUsername(username);
        if (user != null){
            //如果角色不为空，则匹配密码是否正确
            boolean isPass = encoder.matches(password,user.getPassword());
            if (isPass){
                user.setPassword(null);
                session.setAttribute("user", user);
                return "admin/admin_index";
            }else {
                attributes.addFlashAttribute("message","密码错误");
                return "redirect:/admin";
            }
        }else {
            attributes.addFlashAttribute("message","用户名错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String toLogout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }*/
}
