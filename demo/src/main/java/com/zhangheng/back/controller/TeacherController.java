package com.zhangheng.back.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangheng.back.bean.Teacher;
import com.zhangheng.back.common.Result;
import com.zhangheng.back.mapper.TeacherMapper;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/t")
public class TeacherController {
    @Resource
    TeacherMapper teacherMapper;
    @PostMapping
    public Result<?> add(@RequestBody Teacher teacher){
        System.out.println(teacher);
        teacherMapper.insert(teacher);
        return Result.success();
    }


}
