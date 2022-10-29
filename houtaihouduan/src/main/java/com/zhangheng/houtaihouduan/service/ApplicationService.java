package com.zhangheng.houtaihouduan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangheng.houtaihouduan.bean.Application;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface ApplicationService {
    public IPage<Application> selByPage(Integer pageNum, Integer pageSize,
                                        String searchName, String searchTitle
                                    , int searchState);
    public Result<?> addApplication(Application application);
    public Result<?> getAllByTeacher(HttpServletRequest request);
    public Result<?> addApplication(Application application,HttpServletRequest request);
    public Result<?> getById(int id);
    public Result<?> delApp(int id);
    public Result<?> checkApplication(int id,int state,HttpServletRequest request);
 }
