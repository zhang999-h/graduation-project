package com.zhangheng.houtaihouduan.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhangheng.houtaihouduan.bean.Checker;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.CheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class CheckerController {
    @Autowired
    CheckerService checkerService;

    @PostMapping("/checker/login")
    public Result<?> login(@RequestBody Checker checker, HttpSession httpSession){
        Result<?> result = checkerService.checkerLogin(checker, httpSession);

        return result;
    }
    @PostMapping("/addChecker")
    public Result<?> add(@RequestBody Checker checker) {
        System.out.println(checker);
        checkerService.addChecker(checker);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/searchChecker")
    public Result<?> findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "") String searchName,
            @RequestParam(defaultValue = "") String searchNum
    ) {

        IPage<Checker> page = checkerService.selByPage(pageNum, pageSize, searchName, searchNum);


        return Result.success(page);
    }


    @PutMapping("/updateChecker")
    public Result<?> update(@RequestBody Checker checker) {
        //System.out.println(checker);
        Result<?> result = checkerService.updateChecker(checker);
        return result;

    }

    @DeleteMapping("/delChecker/{id}")
    public Result<?> delChecker(@PathVariable int id) {
        System.out.println(id);
        Result<?> result = checkerService.delChecker(id);
        return result;

    }
}
