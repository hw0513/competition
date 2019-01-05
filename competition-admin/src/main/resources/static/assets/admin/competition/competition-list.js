/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"competition_config":"admin/competition/competition-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","competition_config"],function(){
    var config = $.extend(layui.competition_config,{
        childrenPage:[
            {
                tabTitle:"参赛队伍表",
                url:"admin/page/team/list",
                mcForeignName:"competitionId"
            },            {
                tabTitle:"竞赛评定人员表",
                url:"admin/page/judge_user/list",
                mcForeignName:"competitionId"
            },            {
                tabTitle:"作品表",
                url:"admin/page/product/list",
                mcForeignName:"competitionId"
            }        ],
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            competitionId:'competition_id',competitionName:'competition_name',enrollDatetimeBegin:'enroll_datetime_begin',enrollDatetimeEnd:'enroll_datetime_end',productDatetimeEnd:'product_datetime_end',judgeDatetimeEnd:'judge_datetime_end',userId:'user_id'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'competitionId', title: '竞赛id', minWidth:100, align:"center",sort:true},

            {field: 'competitionName', title: '竞赛名称', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.competitionName) +'" class="magicalcoder-table-text layui-input security_list_table_form_competitionName" name="competitionName" data-identify="'+d.competitionId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="竞赛名称"/>'
                }
                , sort:true
            },
            {field: 'enrollDatetimeBegin', title: '竞赛截止开始报名时间', align:'center', minWidth:250, templet :"#enrollDatetimeBeginTemplate",sort:true},
            {field: 'enrollDatetimeEnd', title: '竞赛截止报名时间', align:'center', minWidth:250, templet :"#enrollDatetimeEndTemplate",sort:true},
            {field: 'productDatetimeEnd', title: '作品提交截止时间', align:'center', minWidth:250, templet :"#productDatetimeEndTemplate",sort:true},
            {field: 'judgeDatetimeEnd', title: '作品评定截止时间', align:'center', minWidth:250, templet :"#judgeDatetimeEndTemplate",sort:true},

            {field: 'userId', title: '竞赛管理员', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.userId) +'" class="magicalcoder-table-text layui-input security_list_table_form_userId" name="userId" data-identify="'+d.competitionId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="竞赛管理员"/>'
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
