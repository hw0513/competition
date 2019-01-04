package com.hw.competition.admin.api.competition;

import com.hw.competition.core.service.CommonRestController;
import org.springframework.beans.factory.InitializingBean;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.*;
import java.util.List;
import java.util.Map;
import com.hw.competition.core.common.constant.PageConstant;
import com.hw.competition.core.common.exception.BusinessException;
import com.hw.competition.core.serialize.ResponseMsg;
import com.hw.competition.model.Competition;
import com.hw.competition.service.competition.service.CompetitionService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@RequestMapping("/admin/competition_rest/")
@RestController
public class AdminCompetitionRestController extends CommonRestController<Competition,Long> implements InitializingBean
{

    @Resource
    private CompetitionService competitionService;

    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="competitionIdFirst")                            Long competitionIdFirst ,
        @RequestParam(required = false,value ="enrollDatetimeBeginFirst")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date enrollDatetimeBeginFirst ,
        @RequestParam(required = false,value ="enrollDatetimeBeginSecond")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date enrollDatetimeBeginSecond ,
        @RequestParam(required = false,value ="enrollDatetimeEndFirst")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date enrollDatetimeEndFirst ,
        @RequestParam(required = false,value ="enrollDatetimeEndSecond")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date enrollDatetimeEndSecond ,
        @RequestParam(required = false,value ="productDatetimeEndFirst")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date productDatetimeEndFirst ,
        @RequestParam(required = false,value ="productDatetimeEndSecond")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date productDatetimeEndSecond ,
        @RequestParam(required = false,value ="judgeDatetimeEndFirst")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date judgeDatetimeEndFirst ,
        @RequestParam(required = false,value ="judgeDatetimeEndSecond")                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date judgeDatetimeEndSecond ,
        @RequestParam(required = false,value ="userIdFirst")                            Long userIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("competitionIdFirst",competitionIdFirst);
        query.put("enrollDatetimeBeginFirst",enrollDatetimeBeginFirst);
        query.put("enrollDatetimeBeginSecond",enrollDatetimeBeginSecond);
        query.put("enrollDatetimeEndFirst",enrollDatetimeEndFirst);
        query.put("enrollDatetimeEndSecond",enrollDatetimeEndSecond);
        query.put("productDatetimeEndFirst",productDatetimeEndFirst);
        query.put("productDatetimeEndSecond",productDatetimeEndSecond);
        query.put("judgeDatetimeEndFirst",judgeDatetimeEndFirst);
        query.put("judgeDatetimeEndSecond",judgeDatetimeEndSecond);
        query.put("userIdFirst",userIdFirst);
        Integer count = competitionService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","competition_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,competitionService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = competitionService;
        super.primaryKey = "competitionId";//硬编码此实体的主键名称
    }
}
