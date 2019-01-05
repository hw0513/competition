/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"team_config":"admin/team/team-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","team_config"],function(){
    var config = $.extend(layui.team_config,{
        childrenPage:[
            {
                tabTitle:"作品表",
                url:"admin/page/product/list",
                mcForeignName:"productTeam"
            }        ],
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            teamId:'team_id',teamName:'team_name',studentId:'student_id'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'teamId', title: 'team_id', minWidth:100, align:"center",sort:true},

            {field: 'teamName', title: '队伍名称', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.teamName) +'" class="magicalcoder-table-text layui-input security_list_table_form_teamName" name="teamName" data-identify="'+d.teamId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="队伍民称"/>'
                }
                , sort:true
            },

            {field: 'studentId', title: '队伍成员', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.studentId) +'" class="magicalcoder-table-text layui-input security_list_table_form_studentId" name="studentId" data-identify="'+d.teamId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="队伍成员"/>'
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
