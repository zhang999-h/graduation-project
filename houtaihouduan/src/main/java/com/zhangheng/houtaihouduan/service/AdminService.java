package com.zhangheng.houtaihouduan.service;

import com.zhangheng.houtaihouduan.bean.Admin;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface AdminService {
    public Result<?> login(Admin admin);
    public Result<?> changePWD(int  id, String password, String newPassword);
}
