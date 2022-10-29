package com.zhangheng.houtaihouduan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangheng.houtaihouduan.bean.Application;
import com.zhangheng.houtaihouduan.bean.Notice;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.ApplicationService;
import com.zhangheng.houtaihouduan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @Autowired
    TeacherService teacherService;
    /**
     * 分页查询
     */

    @GetMapping("/searchApplication")
    public Result<?> findApplicationByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "") String searchTitle,
            @RequestParam(defaultValue = "-1") int searchState
    ) {
        System.out.println(searchState);
        IPage<Application> page = applicationService.selByPage(pageNum, pageSize, searchName, searchTitle
                , searchState);

        return Result.success(page);
    }
    @GetMapping("/getApplicationByTeacher")
    public  Result<?> getTeacherApplication(HttpServletRequest request){
        System.out.println(999);
        Result<?> allByTeacher = applicationService.getAllByTeacher(request);
        return allByTeacher;
    }
    @PostMapping("/addApplication")
    public Result<?> add(@RequestBody Application application,HttpServletRequest request) {
        Result<?> result = applicationService.addApplication(application, request);


        return result;
    }
    @GetMapping("/getApplicationById")
    public  Result<?> getApplication(@RequestParam int id){
        Result<?> byId = applicationService.getById(id);
        return byId;
    }
    @GetMapping("/checkApplication")
    public  Result<?> checkApplication(@RequestParam int id,
                                       @RequestParam int state,HttpServletRequest request
                                       ){
        System.out.println(999);
        Result<?> result = applicationService.checkApplication(id, state, request);

        return result;
    }


    @DeleteMapping("/delApp/{id}")
    public Result<?> delApp(@PathVariable int id) {
        //System.out.println(id);
        Result<?> result = applicationService.delApp(id);
        return result;

    }
}
