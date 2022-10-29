package com.zhangheng.houtaihouduan.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Notice {
    private int id;
    private String title;
    private String content;
    private Date date;
    private String fileUrl;

}
