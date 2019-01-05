/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"judgeuser_config":"admin/judgeuser/judgeuser-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","judgeuser_config"],function(){
    var config = $.extend(layui.judgeuser_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            judgeUserId:'judge_user_id',userId:'user_id',competitionId:'competition_id'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'judgeUserId', title: 'judge_user_id', minWidth:100, align:"center",sort:true},

            {field: 'userId', title: '竞赛评委', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.userId) +'" class="magicalcoder-table-text layui-input security_list_table_form_userId" name="userId" data-identify="'+d.judgeUserId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="用户Id"/>'
                }
                , sort:true
            },
                {field: 'competitionId', title: '竞赛民称', align:'center', minWidth:250, templet:function (d) {
                    var value = (!d.competitionId || d.competitionId==null) ? '' : d.competitionId
                    var option = '<option selected="selected" value="'+value+'">'+value+'</option>'
                    return '<select class="magicalcoder-table-foreign-select2 layui-input security_list_table_form_competitionId" lay-ignore="true"  name="competitionId" data-identify="'+d.judgeUserId+'" data-value="" data-url="admin/competition_rest/search" data-id="competitionId" data-text-fields="competitionName" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="竞赛Id">'+option+'</select>'
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
