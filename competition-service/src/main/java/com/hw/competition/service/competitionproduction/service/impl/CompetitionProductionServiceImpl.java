package com.hw.competition.service.competitionproduction.service.impl;

import com.hw.competition.service.competitionproduction.mapper.CompetitionProductionMapper;
import com.hw.competition.service.competitionproduction.service.CompetitionProductionService;
import com.hw.competition.model.CompetitionProduction;
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
public class CompetitionProductionServiceImpl extends CommonServiceImpl<CompetitionProduction,Long> implements CompetitionProductionService,InitializingBean{
    @Resource
    private CompetitionProductionMapper competitionProductionMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = competitionProductionMapper;
    }
}
