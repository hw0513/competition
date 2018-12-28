package com.hw.competition.admin.api.competitionproduction;

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
import com.hw.competition.model.CompetitionProduction;
import com.hw.competition.service.competitionproduction.service.CompetitionProductionService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/

@RequestMapping("/admin/competition_production_rest/")
@RestController
public class AdminCompetitionProductionRestController extends CommonRestController<CompetitionProduction,Long> implements InitializingBean
{

    @Resource
    private CompetitionProductionService competitionProductionService;

    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="productionIdFirst")                            Long productionIdFirst ,
        @RequestParam(required = false,value ="productionNameFirst")                            String productionNameFirst ,
        @RequestParam(required = false,value ="productionSorceFirst")                            Integer productionSorceFirst ,
        @RequestParam(required = false,value ="playerInfoFirst")                            String playerInfoFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("productionIdFirst",productionIdFirst);
        query.put("productionNameFirst",coverBlankToNull(productionNameFirst));
        query.put("productionSorceFirst",productionSorceFirst);
        query.put("playerInfoFirst",coverBlankToNull(playerInfoFirst));
        Integer count = competitionProductionService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","production_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,competitionProductionService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = competitionProductionService;
        super.primaryKey = "productionId";//硬编码此实体的主键名称
    }
}
