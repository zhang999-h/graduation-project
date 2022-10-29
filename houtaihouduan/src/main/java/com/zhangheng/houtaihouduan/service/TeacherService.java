package com.zhangheng.houtaihouduan.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface TeacherService {
    public void addTeacher(Teacher teacher);
    public IPage<Teacher> selByPage(Integer pageNum, Integer pageSize, String searchName,String searchNum);
    public Result<?> updateTeacher(Teacher teacher);
    public Result<?> delTeacher(int id);
    public Result<?> teacherLogin(Teacher teacher, HttpSession httpSession);
    public Result<?> changePWD(int id,String password,String newPassword);
}
