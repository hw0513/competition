package com.hw.competition.admin.adminservice.demo.service.impl;

import com.hw.competition.admin.adminservice.demo.mapper.AdminServiceDemoMapper;
import com.hw.competition.admin.adminservice.demo.service.AdminServiceDemoService;
import com.hw.competition.admin.model.MyDemo;
import com.hw.competition.core.utils.MapUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceDemoServiceImpl  implements AdminServiceDemoService {
    @Resource
    private AdminServiceDemoMapper adminServiceDemoMapper;

    @Override
    public MyDemo demoGoods(Long id) {
        return adminServiceDemoMapper.daoDemoGoods(MapUtil.buildMap("id",id));
    }
}
