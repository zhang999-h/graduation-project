package com.zhangheng.houtaihouduan.controller;

import com.zhangheng.houtaihouduan.bean.Notice;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @GetMapping("/searchNotice")
    public Result<?> getAll(){
        Result<?> all = noticeService.getAll();
        return all;
    }
    @PostMapping("/addNotice")
    public Result<?> add(@RequestBody Notice notice) {
        Result<?> result = noticeService.addNotice(notice);

        return result;
    }
    @GetMapping("/getNotice")
    public Result<?> getById(@RequestParam int id){
        System.out.println(id);
        Result<?> noticeById = noticeService.getNoticeById(id);
        return noticeById;
    }
}
