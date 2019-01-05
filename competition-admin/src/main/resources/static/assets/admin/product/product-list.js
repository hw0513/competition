/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"product_config":"admin/product/product-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","product_config"],function(){
    var config = $.extend(layui.product_config,{
        childrenPage:[
            {
                tabTitle:"参赛材料表",
                url:"admin/page/product_material/list",
                mcForeignName:"productId"
            }        ],
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            productId:'product_id',competitionId:'competition_id',productTeam:'product_team',productName:'product_name'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'productId', title: '作品ID', minWidth:100, align:"center",sort:true},
                {field: 'competitionId', title: '作品所属的竞赛', align:'center', minWidth:250, templet:function (d) {
                    var value = (!d.competitionId || d.competitionId==null) ? '' : d.competitionId
                    var option = '<option selected="selected" value="'+value+'">'+value+'</option>'
                    return '<select class="magicalcoder-table-foreign-select2 layui-input security_list_table_form_competitionId" lay-ignore="true"  name="competitionId" data-identify="'+d.productId+'" data-value="" data-url="admin/competition_rest/search" data-id="competitionId" data-text-fields="competitionName,userId" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品所属的竞赛">'+option+'</select>'
                    },sort:true
                },

            {field: 'productName', title: '作品名称', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productName) +'" class="magicalcoder-table-text layui-input security_list_table_form_productName" name="productName" data-identify="'+d.productId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品名称"/>'
                }
                , sort:true
            },
                {field: 'productTeam', title: '作品所属队伍', align:'center', minWidth:250, templet:function (d) {
                    var value = (!d.productTeam || d.productTeam==null) ? '' : d.productTeam
                    var option = '<option selected="selected" value="'+value+'">'+value+'</option>'
                    return '<select class="magicalcoder-table-foreign-select2 layui-input security_list_table_form_productTeam" lay-ignore="true"  name="productTeam" data-identify="'+d.productId+'" data-value="" data-url="admin/team_rest/search" data-id="teamId" data-text-fields="teamName" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品所属队伍">'+option+'</select>'
                    },sort:true
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
