package com.zhangheng.houtaihouduan.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "checker")
public class Checker {
    @TableId(type = IdType.AUTO)
    private int id;
    private String num;
    private String username;
    private String password;
}
