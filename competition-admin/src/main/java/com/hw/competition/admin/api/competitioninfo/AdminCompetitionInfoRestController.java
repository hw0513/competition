package com.hw.competition.admin.api.competitioninfo;

import com.hw.competition.core.service.CommonRestController;
import org.springframework.beans.factory.InitializingBean;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.math.*;
import java.util.List;
import java.util.Map;
import com.hw.competition.core.common.constant.PageConstant;
import com.hw.competition.core.common.exception.BusinessException;
import com.hw.competition.core.serialize.ResponseMsg;
import com.hw.competition.model.CompetitionInfo;
import com.hw.competition.service.competitioninfo.service.CompetitionInfoService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/

@RequestMapping("/admin/competition_info_rest/")
@RestController
public class AdminCompetitionInfoRestController extends CommonRestController<CompetitionInfo,Long> implements InitializingBean
{

    @Resource
    private CompetitionInfoService competitionInfoService;

    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="competitionInfoIdFirst")                            Long competitionInfoIdFirst ,
        @RequestParam(required = false,value ="competitionNameFirst")                            String competitionNameFirst ,
        @RequestParam(required = false,value ="competitionUserFirst")                            Long competitionUserFirst ,
        @RequestParam(required = false,value ="statusFirst")                            String statusFirst ,
        @RequestParam(required = false,value ="natureFirst")                            String natureFirst ,
        @RequestParam(required = false,value ="maxnumFirst")                            Integer maxnumFirst ,
        @RequestParam(required = false,value ="competitionTypeFirst")                            Long competitionTypeFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("competitionInfoIdFirst",competitionInfoIdFirst);
        query.put("competitionNameFirst",coverBlankToNull(competitionNameFirst));
        query.put("competitionUserFirst",competitionUserFirst);
        query.put("statusFirst",coverBlankToNull(statusFirst));
        query.put("natureFirst",coverBlankToNull(natureFirst));
        query.put("maxnumFirst",maxnumFirst);
        query.put("competitionTypeFirst",competitionTypeFirst);
        Integer count = competitionInfoService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","competition_info_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,competitionInfoService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = competitionInfoService;
        super.primaryKey = "competitionInfoId";//硬编码此实体的主键名称
    }
}
