package com.zhb.blogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {//配置拦截器的拦截路径
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/admin/**")//拦截'/admin'下的所有请求
                .excludePathPatterns("/admin")//不拦截'/admin'
                .excludePathPatterns("/admin/login");//不拦截'/admin/login'
    }*/

    @Bean
    public LocaleResolver localeResolver(){//自定义的国际化组件
        return new MyLocaleResolver();
    }

}
