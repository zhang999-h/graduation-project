package com.zhangheng.houtaihouduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.houtaihouduan.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
    public List<Notice> getAllNotice();
}
