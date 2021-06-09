# Spring Boot个人博客项目

> **作者：朱和彬**
>
> **qq： 1548963912**

项目参照了李仁密老师的基于springboot的小而美的个人博客，
         朱一鸣的个人博客项目博客地址：http://www.zhuyiming.top

目录中有blog.sql文件，可以直接执行生成对应的数据库和表 

```java
/*
blog version1.0 未完成回复功能，（可能存在分类和标签显示不完全的情况）

blog version1.1 未完成回复功能，功能模块中的分类和标签有bug，存在显示不完全的情况

如果你的前端也使用的是semantic-ui，请一定要修改semantic-ui的源代码后再编译成css、js文件，再由本地加载css、js文件，
因为semantic-ui默认使用的是**谷歌的字体**，它会去向谷歌服务器申请它所需的字体，如果不修改，国内访问谷歌服务器的速度就不用我
多说了，首次访问博客网站的绝大部分时间都用于去访问谷歌服务器了
（下载semantic源码并修改后，用gulp来编译，如果有大佬成功了，请发我一份，谢谢！）。

暑假决定重构博客。
*/
```


功能：**前端展示 + 后台管理**

博客地址：**www.zhuhebin.com**

**技术栈：**

*  前端：
   - JS框架：JQuery
   - CSS框架：[Semantic UI官网](https://semantic-ui.com/)
   - Markdown编辑器：[编辑器 Markdown](https://pandao.github.io/editor.md/)
   - 代码高亮：[代码高亮 prism](https://github.com/PrismJS/prism)
   - 动画效果：[动画 animate.css](https://daneden.github.io/animate.css/)
   - 目录生成：[目录生成 Tocbot](https://tscanlin.github.io/tocbot/)
   - 二维码生成：[二维码生成](https://davidshimjs.github.io/qrcodejs/)
   - 平滑滚动:  [平滑滚动](https://github.com/flesler/jquery.scrollTo)
   - 滚动侦测: [滚动侦测](http://imakewebthings.com/waypoints/)
*  后端：
   - 核心框架：SpringBoot 2.4.4
   - 项目构建：jdk1.8、Maven 3.6.3
   - 持久层框架：Mybatis
   - 模板框架：Thymeleaf
   - 分页插件：PageHelper
   - 加密：BCryptPasswordEncoder加密
*  数据库：MySQL8.0

**博客展示界面**

![index.png](https://i.loli.net/2021/04/15/m7KcgXEtxj8apy1.png)

![type.png](https://i.loli.net/2021/04/15/bcFmlpUPfnGDCAH.png)

![tag.png](https://i.loli.net/2021/04/15/xbynWREvadruAN1.png)

![archives.png](https://i.loli.net/2021/04/15/XmojuzgS2xPQCYB.png)

![aboutme.png](https://i.loli.net/2021/04/15/b3gHEU75h1loJm9.png)

![admin.png](https://i.loli.net/2021/04/15/tuIaycEPj1VdCOL.png)

![admin_blog.png](https://i.loli.net/2021/04/15/QpuGtxB3INFJosy.png)

![admin_type.png](https://i.loli.net/2021/04/15/NkranMKpl6Y7DeW.png)

![admin_tag.png](https://i.loli.net/2021/04/15/7ifbxUvSIR3sJZ4.png)
