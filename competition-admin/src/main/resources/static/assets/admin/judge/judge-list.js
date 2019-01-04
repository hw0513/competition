/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"judge_config":"admin/judge/judge-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","judge_config"],function(){
    var config = $.extend(layui.judge_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            judgeId:'judge_id',judgeUser:'judge_user',judgeProduct:'judge_product',judgeResult:'judge_result'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'judgeId', title: '作品评定表', minWidth:100, align:"center",sort:true},

            {field: 'judgeUser', title: '评定人员', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.judgeUser) +'" class="magicalcoder-table-text layui-input security_list_table_form_judgeUser" name="judgeUser" data-identify="'+d.judgeId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="评定人员"/>'
                }
                , sort:true
            },

            {field: 'judgeProduct', title: '评定作品', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.judgeProduct) +'" class="magicalcoder-table-text layui-input security_list_table_form_judgeProduct" name="judgeProduct" data-identify="'+d.judgeId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="评定作品"/>'
                }
                , sort:true
            },

            {field: 'judgeResult', title: '评定结果', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.judgeResult) +'" class="magicalcoder-table-text layui-input security_list_table_form_judgeResult" name="judgeResult" data-identify="'+d.judgeId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="评定结果"/>'
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
