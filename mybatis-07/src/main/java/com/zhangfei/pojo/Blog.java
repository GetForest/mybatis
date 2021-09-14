package com.zhangfei.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author MagiskBoy
 */
@Data
public class Blog {
    private String id;
    private  String title;
    private  String author;
    private  Date createTime;
    private  int views;


}
