package com.hw.competition.admin.api.competition;

import com.hw.competition.core.service.CommonRestController;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.InitializingBean;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "search")
    public ResponseMsg search(
        @RequestParam(required = false) String uniqueField,
        @RequestParam(required = false) Long uniqueValue,
        @RequestParam(required = false,defaultValue = "20") Integer limit,
        @RequestParam(required = false) String keyword,
        HttpServletRequest request,
        HttpSession session,
        HttpResponse response
    ){
        limit = Math.min(PageConstant.MAX_LIMIT,limit);
        List<Competition> list = null;
        Map<String,Object> query = new HashedMap();
        query.put("limit",limit);
        query.put("notSafeOrderBy","competition_id desc");
        if(uniqueValue!=null){//说明是来初始化的
            query.put(uniqueField,uniqueValue);
            list = competitionService.getModelList(query);
        }else {//正常搜索
            if(ListUtil.isBlank(list)){
                query.put("competitionNameFirst",keyword);
                list = competitionService.getModelList(query);
                query.remove("competitionNameFirst");
            }
            if(ListUtil.isBlank(list)){
                query.put("userIdFirst",keyword);
                list = competitionService.getModelList(query);
                query.remove("userIdFirst");
            }
        }
        return new ResponseMsg(list);
    }
    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="competitionNameFirst")                            String competitionNameFirst ,
        @RequestParam(required = false,value ="userIdFirst")                            Long userIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("competitionNameFirst",coverBlankToNull(competitionNameFirst));
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
