package com.zhangheng.houtaihouduan.service;

import com.zhangheng.houtaihouduan.bean.DateSetting;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;

@Service
public interface DateSettingService {
    public Result<?> getDate();
    public Result<?> updateDate(DateSetting dateSetting);
}
