package com.zhangheng.houtaihouduan.service.impl;

import com.zhangheng.houtaihouduan.bean.Admin;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.AdminMapper;
import com.zhangheng.houtaihouduan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Result<?> login(Admin admin) {
        Admin adminByNumAndPwd = adminMapper.findAdminByNumAndPwd(admin.getNum(), admin.getPassword());
        if (adminByNumAndPwd != null) {
            return Result.success(adminByNumAndPwd);
        } else {
            return Result.error("-1", "用户名或密码错误");
        }
    }

    @Override
    public Result<?> changePWD(int id, String password, String newPassword) {
        Admin admin = adminMapper.selectById(id);
        admin.setPassword(newPassword);
        adminMapper.updateById(admin);
        return Result.success();
    }
}
