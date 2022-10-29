package com.zhangheng.houtaihouduan.service.impl;

import com.zhangheng.houtaihouduan.bean.Notice;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.NoticeMapper;
import com.zhangheng.houtaihouduan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public Result<?> getAll() {
        List<Notice> allNotice = noticeMapper.getAllNotice();
        Result<List<Notice>> success = Result.success(allNotice);
        return success;
    }

    @Override
    public Result<?> addNotice(Notice notice) {
        notice.setDate(new Date(System.currentTimeMillis()));
        int insert = noticeMapper.insert(notice);
        System.out.println(insert);
        return Result.success();
    }

    @Override
    public Result<?> getNoticeById(int id) {
        Notice notice = noticeMapper.selectById(id);
        return Result.success(notice);
    }
}
