package com.zhangheng.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.back.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface TeacherMapper extends BaseMapper<Teacher> {
    //public void  addTeacher(Teacher teacher);
}
