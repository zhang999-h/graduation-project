package com.zhangheng.houtaihouduan.service.impl;

import cn.hutool.core.lang.intern.InternUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhangheng.houtaihouduan.bean.Application;
import com.zhangheng.houtaihouduan.bean.Checker;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.ApplicationMapper;
import com.zhangheng.houtaihouduan.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    public IPage<Application> selByPage(Integer pageNum, Integer pageSize,
                                    String searchName, String searchTitle
                                  , int searchState) {
        LambdaQueryWrapper<Application> wrapper = Wrappers.<Application>lambdaQuery();
        if (StrUtil.isNotBlank(searchName)) {
            wrapper.like(Application::getTeacherName, searchName);
        }
        if (StrUtil.isNotBlank(searchTitle)) {
            wrapper.like(Application::getTitle, searchTitle);
        }
        if (searchState!=-1) {
            System.out.println(searchState);
            wrapper.like(Application::getState, searchState);
        }
        IPage<Application> iPage = applicationMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return iPage;
    }

    @Override
    public Result<?> addApplication(Application application) {
       // Object loginAdmin = session.getAttribute("loginAdmin");
        return null;
    }

    @Override
    public Result<?> getAllByTeacher(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if(teacher==null){
            return Result.error("-1","账户名或密码错误");
        }
        else {
            int teacherId=teacher.getId();
            List<Application> byTeacherId = applicationMapper.getByTeacherId(teacherId);

            return Result.success(byTeacherId);
        }
    }

    @Override
    public Result<?> addApplication(Application application, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        application.setAppTime(new Date(System.currentTimeMillis()));
        application.setState(0);
        application.setTeacherId(teacher.getId());
        application.setTeacherName(teacher.getUsername());
        applicationMapper.insert(application);
        return Result.success();
    }

    @Override
    public Result<?> getById(int id) {
        Application application = applicationMapper.selectById(id);
        return Result.success(application);
    }

    @Override
    public Result<?> delApp(int id) {
        int i = applicationMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> checkApplication(int id, int state, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Checker checker = (Checker) session.getAttribute("checker");
        Application application = applicationMapper.selectById(id);
        application.setCheckTime(new Date(System.currentTimeMillis()));
        application.setCheckerId(checker.getId());
        application.setCheckerName(checker.getUsername());
        application.setState(state);
        applicationMapper.updateById(application);
        return Result.success();
    }

}
