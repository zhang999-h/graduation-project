package com.zhangheng.houtaihouduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.houtaihouduan.bean.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper extends BaseMapper<Application> {
        public int selStateCount(int state);
        public List<Application> getByTeacherId(int id);
}
