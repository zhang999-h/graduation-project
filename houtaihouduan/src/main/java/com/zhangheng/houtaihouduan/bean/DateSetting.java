package com.zhangheng.houtaihouduan.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class DateSetting {
    private Date appStartDate;
    private Date appEndDate;
    private Date checkStartDate;
    private Date checkEndDate;
}
