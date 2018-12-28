
package com.hw.competition.admin.rmp.service.impl;

import com.hw.competition.admin.rmp.mapper.SysModuleMapper;
import com.hw.competition.admin.rmp.model.SysModule;
import com.hw.competition.admin.rmp.service.SysModuleService;
import com.hw.competition.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@Service
public class SysModuleServiceImpl extends CommonServiceImpl<SysModule,Long> implements SysModuleService,InitializingBean{
    @Resource
    private SysModuleMapper sysModuleMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysModuleMapper;
    }
}
