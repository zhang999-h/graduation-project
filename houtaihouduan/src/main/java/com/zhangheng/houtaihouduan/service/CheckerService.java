package com.zhangheng.houtaihouduan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;


import com.zhangheng.houtaihouduan.bean.Checker;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface CheckerService {
    public void addChecker(Checker checker);
    public IPage<Checker> selByPage(Integer pageNum, Integer pageSize, String searchName,String searchNum);
    public Result<?> updateChecker(Checker checker);
    public Result<?> delChecker(int id);
    public Result<?> checkerLogin(Checker checker, HttpSession httpSession);
}
