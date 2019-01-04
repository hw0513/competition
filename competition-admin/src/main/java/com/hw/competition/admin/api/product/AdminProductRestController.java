package com.hw.competition.admin.api.product;

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
import com.hw.competition.model.Product;
import com.hw.competition.service.product.service.ProductService;

import com.hw.competition.core.utils.ListUtil;
import com.hw.competition.core.utils.MapUtil;
import com.hw.competition.core.utils.StringUtil;


/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

@RequestMapping("/admin/product_rest/")
@RestController
public class AdminProductRestController extends CommonRestController<Product,Long> implements InitializingBean
{

    @Resource
    private ProductService productService;

    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="productNameFirst")                            String productNameFirst ,
        @RequestParam(required = false,value ="productTeamFirst")                            Long productTeamFirst ,
        @RequestParam(required = false,value ="productMaterialFirst")                            Long productMaterialFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy)
    {
        limit = Math.min(limit, PageConstant.MAX_LIMIT);
        int start = (page - 1) * limit;
        Map<String,Object> query = new HashedMap();
        query.put("productNameFirst",coverBlankToNull(productNameFirst));
        query.put("productTeamFirst",productTeamFirst);
        query.put("productMaterialFirst",productMaterialFirst);
        Integer count = productService.getModelListCount(query);
        query.put("start",start);
        query.put("limit",limit);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","product_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        return new ResponseMsg(count,productService.getModelList(query));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = productService;
        super.primaryKey = "productId";//硬编码此实体的主键名称
    }
}
