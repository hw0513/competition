package com.hw.competition.service.competitioninfo.service.impl;

import com.hw.competition.service.competitioninfo.mapper.CompetitionInfoMapper;
import com.hw.competition.service.competitioninfo.service.CompetitionInfoService;
import com.hw.competition.model.CompetitionInfo;
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
 * @author 黄维
 * 联系1778134055@qq.com
 **/

@Service
public class CompetitionInfoServiceImpl extends CommonServiceImpl<CompetitionInfo,Long> implements CompetitionInfoService,InitializingBean{
    @Resource
    private CompetitionInfoMapper competitionInfoMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = competitionInfoMapper;
    }
}
