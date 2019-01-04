/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"student_config":"admin/student/student-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","student_config"],function(){
    var config = $.extend(layui.student_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            studentId:'student_id',idNumber:'id_number',className:'class_name',schoolNumber:'school_number'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'studentId', title: 'student_id', minWidth:100, align:"center",sort:true},

            {field: 'idNumber', title: '身份证号', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.idNumber) +'" class="magicalcoder-table-text layui-input security_list_table_form_idNumber" name="idNumber" data-identify="'+d.studentId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="身份证号"/>'
                }
                , sort:true
            },

            {field: 'className', title: '班级', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.className) +'" class="magicalcoder-table-text layui-input security_list_table_form_className" name="className" data-identify="'+d.studentId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="班级"/>'
                }
                , sort:true
            },

            {field: 'schoolNumber', title: '学号', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.schoolNumber) +'" class="magicalcoder-table-text layui-input security_list_table_form_schoolNumber" name="schoolNumber" data-identify="'+d.studentId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="学号"/>'
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
