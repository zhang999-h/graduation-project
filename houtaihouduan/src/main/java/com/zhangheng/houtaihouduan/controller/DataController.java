package com.zhangheng.houtaihouduan.controller;

import com.zhangheng.houtaihouduan.bean.DateSetting;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.DateSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DataController {
    @Autowired
    DateSettingService dateSettingService;

    @PostMapping("/setDate")
    public Result<?> set(@RequestBody DateSetting date){
        //System.out.println(date);
        Result<?> result = dateSettingService.updateDate(date);
        return result;
    }
    @GetMapping("/getDate")
    public Result<?> getDate(){
        Result<?> date = dateSettingService.getDate();
        return date;
    }
}
