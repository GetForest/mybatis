package com.zhangfei.mapper;

import com.zhangfei.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author MagiskBoy
 */
public interface BlogMapper {
    int addBlog(Blog blog);

    //查询blog
    List<Blog> queryBlogIf(Map map);

    //更新blog

    int updateBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    //foreach
    List<Blog> queryBlogForeach(Map map);



}
