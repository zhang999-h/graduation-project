package com.zhangheng.back.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private int id;
    private String num;
    private String username;
    private String password;
}
