package com.zhangheng.houtaihouduan.service;

import com.zhangheng.houtaihouduan.bean.Notice;
import com.zhangheng.houtaihouduan.common.Result;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {
    public Result<?> getAll();
    public Result<?> addNotice(Notice notice);
    public Result<?> getNoticeById(int id);
}
