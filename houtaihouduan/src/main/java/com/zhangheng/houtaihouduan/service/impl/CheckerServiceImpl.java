package com.zhangheng.houtaihouduan.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import com.zhangheng.houtaihouduan.bean.Checker;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.CheckerMapper;

import com.zhangheng.houtaihouduan.service.CheckerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CheckerServiceImpl implements CheckerService {
    @Autowired
    CheckerMapper checkerMapper;

    @Override
    public void addChecker(Checker checker) {
        checkerMapper.insert(checker);

    }


    @Override
    public IPage<Checker> selByPage(Integer pageNum, Integer pageSize,
                                    String searchName,String searchNum) {
        LambdaQueryWrapper<Checker> wrapper = Wrappers.<Checker>lambdaQuery();
        if(StrUtil.isNotBlank(searchName)){
            wrapper.like(Checker::getUsername,searchName);
        }
        if(StrUtil.isNotBlank(searchNum)){
            wrapper.like(Checker::getNum,searchNum);
        }
        IPage<Checker> iPage = checkerMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return iPage;
    }

    @Override
    public Result<?> updateChecker(Checker checker) {
        checkerMapper.updateById(checker);
        return Result.success();
    }

    @Override
    public Result<?> delChecker(int id) {

        int i = checkerMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> checkerLogin(Checker checker, HttpSession httpSession) {
        Checker checker1 = checkerMapper.searchOne(checker);
        if(checker1==null){
            return Result.error("-1","账户名或密码错误");
        }
        else{
            httpSession.setAttribute("checker",checker1);
            return Result.success(checker1);
        }
    }
}
