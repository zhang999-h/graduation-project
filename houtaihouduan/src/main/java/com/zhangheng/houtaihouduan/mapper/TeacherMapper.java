package com.zhangheng.houtaihouduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.houtaihouduan.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    public void  addTeacher(Teacher teacher);
    public Teacher searchOne(Teacher teacher);
}
