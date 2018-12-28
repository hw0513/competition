/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/

layui.config({base : "assets/"}).extend({"competitionproduction_config":"admin/competitionproduction/competitionproduction-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","competitionproduction_config"],function(){
    var config = $.extend(layui.competitionproduction_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            productionId:'production_id',productionName:'production_name',productionSorce:'production_sorce',playerInfo:'player_info'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'productionId', title: '竞赛作品唯一标识', minWidth:100, align:"center",sort:true},

            {field: 'productionName', title: '作品名字', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productionName) +'" class="magicalcoder-table-text layui-input security_list_table_form_productionName" name="productionName" data-identify="'+d.productionId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="作品名字"/>'
                }
                , sort:true
            },

            {field: 'productionSorce', title: '作品最终得分', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productionSorce) +'" class="magicalcoder-table-text layui-input security_list_table_form_productionSorce" name="productionSorce" data-identify="'+d.productionId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="作品最终得分"/>'
                }
                , sort:true
            },

            {field: 'playerInfo', title: '作品所属队伍', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.playerInfo) +'" class="magicalcoder-table-text layui-input security_list_table_form_playerInfo" name="playerInfo" data-identify="'+d.productionId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="作品所属队伍"/>'
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
