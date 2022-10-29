package com.zhangheng.houtaihouduan.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.TeacherMapper;
import com.zhangheng.houtaihouduan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);

    }
    @Override
    public IPage<Teacher> selByPage(Integer pageNum, Integer pageSize,
                                    String searchName,String searchNum) {
        LambdaQueryWrapper<Teacher> wrapper = Wrappers.<Teacher>lambdaQuery();
        if(StrUtil.isNotBlank(searchName)){
            wrapper.like(Teacher::getUsername,searchName);
        }
        if(StrUtil.isNotBlank(searchNum)){
            wrapper.like(Teacher::getNum,searchNum);
        }
        IPage<Teacher> iPage = teacherMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return iPage;
    }

    @Override
    public Result<?> updateTeacher(Teacher teacher) {
        teacherMapper.updateById(teacher);
        return Result.success();
    }

    @Override
    public Result<?> delTeacher(int id) {

        int i = teacherMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> teacherLogin(Teacher teacher, HttpSession httpSession) {
        Teacher teacher1 = teacherMapper.searchOne(teacher);
        if(teacher1==null){
            return Result.error("-1","账户名或密码错误");
        }
        else{
            httpSession.setAttribute("teacher",teacher1);
            return Result.success(teacher1);
        }

    }

    @Override
    public Result<?> changePWD(int id, String password, String newPassword) {
        Teacher teacher = teacherMapper.selectById(id);
        teacher.setPassword(newPassword);
        teacherMapper.updateById(teacher);
        return Result.success();
    }
}
