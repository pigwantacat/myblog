package com.zhb.blogs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;//博客id
    private String title;//标题
    private String content;//内容
    private String firstPicture;//首图
    private String flag;//原创、转载、翻译等
    private Integer views;//浏览次数
    private boolean appreciation;//赞赏开启
    private boolean shareStatement;//版权开启
    private boolean commentabled;//评论
    private boolean published;//是否发布，草稿箱
    private boolean recommend;//是否推荐
    private Date createTime;//创建时间
    private Date updateTime;//最后更新时间

    //这个属性用来在mybatis中进行连接查询的
    private Long typeId;
    private Long userId;

    //获取多个标签的id
    private String tagIds;
    private String description;

    private Type type;

    private User user;

    private List<Tag> tags = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }

    //将tags集合转换为tagIds字符串形式：“1,2,3”,用于编辑博客时显示博客的tag
    private String tagsToIds(List<Tag> 标签){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag: tags){
                if(flag){
                    ids.append(",");
                }else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }
}
