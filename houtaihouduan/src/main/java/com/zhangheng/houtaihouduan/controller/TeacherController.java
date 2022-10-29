package com.zhangheng.houtaihouduan.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangheng.houtaihouduan.bean.Admin;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.TeacherMapper;
import com.zhangheng.houtaihouduan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/teacher/login")
    public Result<?> login(@RequestBody Teacher teacher, HttpSession httpSession){
        Result<?> result = teacherService.teacherLogin(teacher, httpSession);

        return result;
    }
    @GetMapping("/teacher/changePWD")
    public Result<?> changePWD(@RequestParam(defaultValue = "") int  id,
                           @RequestParam(defaultValue = "") String password,
                           @RequestParam(defaultValue = "") String newPassword){
        System.out.println(id);
        Result<?> result = teacherService.changePWD(id, password, newPassword);
        return result;
    }
    @PostMapping("/addTeacher")
    public Result<?> add(@RequestBody Teacher teacher) {
        System.out.println(teacher);
        teacherService.addTeacher(teacher);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/searchTeacher")
    public Result<?> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "") String searchNum
    ) {

        IPage<Teacher> page = teacherService.selByPage(pageNum, pageSize, searchName, searchNum);


        return Result.success(page);
    }


    @PutMapping("/updateTeacher")
    public Result<?> update(@RequestBody Teacher teacher) {
        System.out.println(teacher);
        Result<?> result = teacherService.updateTeacher(teacher);
        return result;

    }

    @DeleteMapping("/delTeacher/{id}")
    public Result<?> delTeacher(@PathVariable int id) {
        System.out.println(id);
        Result<?> result = teacherService.delTeacher(id);
        return result;

    }
}
