package com.zhangheng.houtaihouduan.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.zhangheng.houtaihouduan.bean.Teacher;
import com.zhangheng.houtaihouduan.common.Result;
import com.zhangheng.houtaihouduan.mapper.TeacherMapper;
import com.zhangheng.houtaihouduan.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin
@RestController
public class FileController {
    @Value("${server.port}")
    private String port;
    @Value("${file.upload.dir}")
    private String realPath;
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public Result<?> add(MultipartFile file) throws IOException {

        String s = fileService.uploadFile(file);
        return Result.success(s);
    }
    @RequestMapping("/download")
    public void download(String fileName, HttpServletResponse response) throws IOException {

        File file = new File(realPath, fileName);
        FileInputStream is = new FileInputStream(file);
        response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        ServletOutputStream os = response.getOutputStream();
        FileCopyUtils.copy(is,os);
    }
    @Autowired
    TeacherMapper teacherMapper;
    /**
     * 导出接口
     */
    @GetMapping("/export/teacher")
    public void export(HttpServletResponse response) throws Exception {

        // 从数据库查询出所有的数据
        List<Teacher> list = teacherMapper.selectList(null);
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("username", "用户名");
        writer.addHeaderAlias("password", "密码");
        writer.addHeaderAlias("num", "账号");
//        writer.addHeaderAlias("email", "邮箱");
//        writer.addHeaderAlias("phone", "电话");
//        writer.addHeaderAlias("address", "地址");
//        writer.addHeaderAlias("createTime", "创建时间");
//        writer.addHeaderAlias("avatarUrl", "头像");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }
    /**
     * excel 导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import/teacher")
    public Boolean imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
//        List<User> list = reader.readAll(User.class);

        // 方式2：忽略表头的中文，直接读取表的内容
        List<List<Object>> list = reader.read(1);
        List<Teacher> teachers = CollUtil.newArrayList();
        for (List<Object> row : list) {
            Teacher teacher = new Teacher();
            teacher.setNum(row.get(0).toString());
            teacher.setUsername(row.get(1).toString());
            teacher.setPassword(row.get(2).toString());

            teachers.add(teacher);
        }
        for(Teacher t:teachers){
            teacherMapper.insert(t);
        }
        return true;
    }

}
