package com.zhangheng.houtaihouduan.controller;

import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;
    @GetMapping("/pie")
    public Result<?> getPie() {
        int[] statistics = statisticsService.getStatistics();
        return Result.success(statistics);
    }

}
