package com.zhangheng.houtaihouduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.houtaihouduan.bean.Checker;
import com.zhangheng.houtaihouduan.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CheckerMapper extends BaseMapper<Checker> {
    //public void  addCheck(Check check);
    public Checker searchOne(Checker checker);
}
