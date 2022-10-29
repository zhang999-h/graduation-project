package com.zhangheng.houtaihouduan.mapper;

import com.zhangheng.houtaihouduan.bean.DateSetting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DateSettingMapper {
    public DateSetting getDate();
    public void updateDate(DateSetting dateSetting);
}
