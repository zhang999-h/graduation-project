package com.zhangheng.houtaihouduan.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Application {
    private int id;
    private String title;
    private int teacherId;
    private String teacherName;
    private Date appTime;
    private String file;
    private int checkerId;
    private String checkerName;
    private String description;
    private int state;
    private Date checkTime;
}
