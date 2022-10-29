package com.zhangheng.houtaihouduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangheng.houtaihouduan.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    public Admin findAdminByNumAndPwd(String num,String password);
}
