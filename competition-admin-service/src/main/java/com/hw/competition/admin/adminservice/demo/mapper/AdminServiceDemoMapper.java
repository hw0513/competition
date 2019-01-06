package com.hw.competition.admin.adminservice.demo.mapper;

import com.hw.competition.admin.model.MyDemo;

import java.util.Map;

public interface AdminServiceDemoMapper {
    MyDemo daoDemoGoods(Map<String,Object> query);

}
