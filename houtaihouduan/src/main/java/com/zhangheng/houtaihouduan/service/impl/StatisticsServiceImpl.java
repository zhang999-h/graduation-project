package com.zhangheng.houtaihouduan.service.impl;

import com.zhangheng.houtaihouduan.mapper.ApplicationMapper;
import com.zhangheng.houtaihouduan.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    ApplicationMapper applicationMapper;
    @Override
    public int[] getStatistics() {
        int[] ints = new int[3];
        ints[0]=applicationMapper.selStateCount(0);
        ints[1]=applicationMapper.selStateCount(1);
        ints[2]=applicationMapper.selStateCount(2);
        return ints;
    }
}
