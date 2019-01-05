package com.hw.competition.admin.api.team;

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
import com.hw.competition.model.Team;
import com.hw.competition.service.team.service.TeamService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@RequestMapping("/admin/team_rest/")
@RestController
public class AdminTeamRestController extends CommonRestController<Team,Long> implements InitializingBean
{

    @Resource
    private TeamService teamService;

    @RequestMapping(value = "search")
    public ResponseMsg search(
        @RequestParam(required = false) String uniqueField,
        @RequestParam(required = false) Long uniqueValue,
        @RequestParam(required = false,defaultValue = "20") Integer limit,
        @RequestParam(required = false) String keyword
    ){
        limit = Math.min(PageConstant.MAX_LIMIT,limit);
        List<Team> list = null;
        Map<String,Object> query = new HashedMap();
        query.put("limit",limit);
        query.put("notSafeOrderBy","team_id desc");
        if(uniqueValue!=null){//说明是来初始化的
            query.put(uniqueField,uniqueValue);
            list = teamService.getModelList(query);
        }else {//正常搜索
            if(ListUtil.isBlank(list)){
                query.put("teamNameFirst",keyword);
                list = teamService.getModelList(query);
                query.remove("teamNameFirst");
            }
        }
        return new ResponseMsg(list);
    }
    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="teamNameFirst")                            String teamNameFirst ,
        @RequestParam(required = false,value ="competitionIdFirst")                            Long competitionIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("teamNameFirst",coverBlankToNull(teamNameFirst));
        query.put("competitionIdFirst",competitionIdFirst);
        Integer count = teamService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","team_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,teamService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = teamService;
        super.primaryKey = "teamId";//硬编码此实体的主键名称
    }
}
