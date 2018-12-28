package com.hw.competition.admin.rmp.common.controller.admin.sys;

import com.hw.competition.admin.rmp.model.SysPermission;
import com.hw.competition.admin.rmp.service.SysPermissionService;
import com.hw.competition.core.common.constant.PageConstant;
import com.hw.competition.core.common.exception.BusinessException;
import com.hw.competition.core.serialize.ResponseMsg;
import com.hw.competition.core.service.CommonRestController;
import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@RequestMapping("/admin/sys_permission_rest/")
@RestController
public class AdminSysPermissionRestController extends CommonRestController<SysPermission,Long> implements InitializingBean
{

    @Resource
    private SysPermissionService sysPermissionService;
    @RequestMapping(value = "search")
    public ResponseMsg search(
        @RequestParam(required = false) String uniqueField,
        @RequestParam(required = false) Long uniqueValue,
        @RequestParam(required = false,defaultValue = "20") Integer limit,
        @RequestParam(required = false) String keyword
    ){
        limit = Math.min(PageConstant.MAX_LIMIT,limit);
        List<SysPermission> list = null;
        Map<String,Object> query = new HashedMap();
        query.put("limit",limit);
        if(uniqueValue!=null){//说明是来初始化的
            query.put(uniqueField,uniqueValue);
            list = sysPermissionService.getModelList(query);
        }else {//正常搜索
            if(ListUtil.isBlank(list)){
                query.put("permissionNameFirst",keyword);
                list = sysPermissionService.getModelList(query);
                query.remove("permissionNameFirst");
            }
        }
        return new ResponseMsg(list);
    }
    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="permissionNameFirst")                            String permissionNameFirst ,
        @RequestParam(required = false,value ="filterPlatformFirst")                            String filterPlatformFirst ,
        @RequestParam(required = false,value ="moduleIdFirst")                            Long moduleIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("permissionNameFirst",coverBlankToNull(permissionNameFirst));
        query.put("filterPlatformFirst",coverBlankToNull(filterPlatformFirst));
        query.put("moduleIdFirst",moduleIdFirst);
        Integer count = sysPermissionService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        query.put("safeOrderBy",safeOrderBy);
        return new ResponseMsg(count,sysPermissionService.getModelList(query));
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = sysPermissionService;
        super.primaryKey = "id";//硬编码此实体的主键名称
    }
}
