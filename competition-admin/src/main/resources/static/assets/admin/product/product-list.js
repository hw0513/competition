/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"product_config":"admin/product/product-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","product_config"],function(){
    var config = $.extend(layui.product_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            productId:'product_id',productName:'product_name',productTeam:'product_team',productMaterial:'product_material'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'productId', title: '作品ID', minWidth:100, align:"center",sort:true},

            {field: 'productName', title: '作品名称', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productName) +'" class="magicalcoder-table-text layui-input security_list_table_form_productName" name="productName" data-identify="'+d.productId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品名称"/>'
                }
                , sort:true
            },

            {field: 'productTeam', title: '作品所属队伍', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productTeam) +'" class="magicalcoder-table-text layui-input security_list_table_form_productTeam" name="productTeam" data-identify="'+d.productId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品所属队伍"/>'
                }
                , sort:true
            },

            {field: 'productMaterial', title: '作品相关材料', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productMaterial) +'" class="magicalcoder-table-text layui-input security_list_table_form_productMaterial" name="productMaterial" data-identify="'+d.productId+'" lay-verify="magicalCoderVerify" magicalcoder-verify="" disabled="true" placeholder="作品相关材料"/>'
                }
                , sort:true
            },
        {title: '操作', minWidth:250, templet:'#newsListOperateTemplate',fixed:"right",align:"center"}
    ]];
    //表格中的一些事件
    var tableEvent = {
        "tool":function (obj,roleId) {//操作部分的按钮
            return true;//不阻止事件继续执行封装的事件
        },
        "sort":function (obj,safeOrderBy) {//排序
            return true;//不阻止事件继续执行封装的事件
        }
    }
    magicalcoderlist.bindTableArea(cols,tableEvent)
    magicalcoderlist.bindAreaEvents();
})
