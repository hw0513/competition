package com.hw.competition.web.api.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黄维
 * @date 2019/1/6 11:34
 **/
@RestController
@RequestMapping("/web/")
public class Test {
    @RequestMapping("goods/info")
    public String test(){
        return "Ok";
    }
}
