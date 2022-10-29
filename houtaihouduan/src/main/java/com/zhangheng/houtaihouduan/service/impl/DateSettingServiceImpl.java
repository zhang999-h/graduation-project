package com.zhangheng.houtaihouduan.service.impl;

import com.zhangheng.houtaihouduan.bean.DateSetting;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.DateSettingMapper;
import com.zhangheng.houtaihouduan.service.DateSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateSettingServiceImpl implements DateSettingService {
    @Autowired
    DateSettingMapper dateSettingMapper;

    @Override
    public Result<?> getDate() {
        DateSetting date = dateSettingMapper.getDate();
        return Result.success(date);
    }

    @Override
    public Result<?> updateDate(DateSetting dateSetting) {
        dateSettingMapper.updateDate(dateSetting);

        return Result.success();
    }
}
