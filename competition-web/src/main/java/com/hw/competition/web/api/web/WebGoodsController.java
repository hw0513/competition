package com.hw.competition.web.api.web;

import com.hw.competition.core.serialize.ResponseMsg;
import com.hw.competition.service.goods.service.GoodsService;
import com.hw.competition.web.webservice.goods.service.WebGoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author:www.magicalcoder.com
 * date:2018/8/23
 * function:
 */
@RestController
@RequestMapping("/web/goods/")
public class WebGoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private WebGoodsService webGoodsService;


    @RequestMapping("info")
    public ResponseMsg info(){
        goodsService.getModel(1L);
        webGoodsService.getWebGoods(1L);
        return new ResponseMsg("ok");
    }

}
