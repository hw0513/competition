/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/

layui.config({base : "assets/"}).extend({"competitioninfo_config":"admin/competitioninfo/competitioninfo-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","competitioninfo_config"],function(){
    var config = $.extend(layui.competitioninfo_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            competitionInfoId:'competition_info_id',competitionName:'competition_name',competitionUser:'competition_user',status:'status',nature:'nature',maxnum:'maxnum',competitionType:'competition_type'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'competitionInfoId', title: '竞赛唯信息一标识', minWidth:100, align:"center",sort:true},

            {field: 'competitionName', title: '竞赛名称', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.competitionName) +'" class="magicalcoder-table-text layui-input security_list_table_form_competitionName" name="competitionName" data-identify="'+d.competitionInfoId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="竞赛名称"/>'
                }
                , sort:true
            },

            {field: 'competitionUser', title: '竞赛发布者', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.competitionUser) +'" class="magicalcoder-table-text layui-input security_list_table_form_competitionUser" name="competitionUser" data-identify="'+d.competitionInfoId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="竞赛发布者"/>'
                }
                , sort:true
            },
            {field: 'status', title: '竞赛的审核状态',minWidth:350, align:'center', templet:'#statusTemplate',sort:true},
            {field: 'nature', title: '竞赛性质',minWidth:350, align:'center', templet:'#natureTemplate',sort:true},

            {field: 'maxnum', title: '最大的参赛人数', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.maxnum) +'" class="magicalcoder-table-text layui-input security_list_table_form_maxnum" name="maxnum" data-identify="'+d.competitionInfoId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="最大的参赛人数"/>'
                }
                , sort:true
            },

            {field: 'competitionType', title: '竞赛类型', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.competitionType) +'" class="magicalcoder-table-text layui-input security_list_table_form_competitionType" name="competitionType" data-identify="'+d.competitionInfoId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="竞赛类型"/>'
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
