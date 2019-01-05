package com.hw.competition.admin.api.judgeuser;

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
import com.hw.competition.model.JudgeUser;
import com.hw.competition.service.judgeuser.service.JudgeUserService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@RequestMapping("/admin/judge_user_rest/")
@RestController
public class AdminJudgeUserRestController extends CommonRestController<JudgeUser,Long> implements InitializingBean
{

    @Resource
    private JudgeUserService judgeUserService;

    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="competitionIdFirst")                            Long competitionIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("competitionIdFirst",competitionIdFirst);
        Integer count = judgeUserService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","judge_user_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,judgeUserService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = judgeUserService;
        super.primaryKey = "judgeUserId";//硬编码此实体的主键名称
    }
}
