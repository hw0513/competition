package com.hw.competition.admin.adminservice.demo.mapper;

import com.hw.competition.admin.model.MyDemo;
import com.hw.competition.model.Goods;

import java.util.Map;

public interface AdminServiceDemoMapper {
    MyDemo daoDemoGoods(Map<String,Object> query);

}
