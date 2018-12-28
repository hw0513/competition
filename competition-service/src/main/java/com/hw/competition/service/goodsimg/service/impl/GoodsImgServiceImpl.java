package com.hw.competition.service.goodsimg.service.impl;

import com.hw.competition.service.goodsimg.mapper.GoodsImgMapper;
import com.hw.competition.service.goodsimg.service.GoodsImgService;
import com.hw.competition.model.GoodsImg;
import com.hw.competition.core.service.CommonServiceImpl;
import com.hw.competition.core.utils.StringUtil;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.hw.competition.core.utils.CopyUtil;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.*;
/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@Service
public class GoodsImgServiceImpl extends CommonServiceImpl<GoodsImg,Long> implements GoodsImgService,InitializingBean{
    @Resource
    private GoodsImgMapper goodsImgMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = goodsImgMapper;
    }
}
