package com.zhangheng.houtaihouduan.controller;

import com.zhangheng.houtaihouduan.bean.Admin;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/admin/changePWD")
    public Result<?> changePWD(@RequestParam(defaultValue = "") int  id,
                               @RequestParam(defaultValue = "") String password,
                               @RequestParam(defaultValue = "") String newPassword){

        Result<?> result = adminService.changePWD(id, password, newPassword);
        return result;
    }
    @PostMapping("/admin/login")
    public Result<?> login(@RequestBody Admin admin){

        Result<?> login = adminService.login(admin);
        return login;
    }
}
