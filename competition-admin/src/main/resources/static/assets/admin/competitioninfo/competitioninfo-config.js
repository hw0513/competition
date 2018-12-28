/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/
//表单通用配置 列表页 详情页都需要
layui.define(['jquery'],function(exports){
    var obj =
        {
            tableNameRest:"competition_info_rest",
            tableName:"competition_info",
            moduleName:"competition_info",//sys_module的moduleName
            formVerifyEditData:{//详情页提交时表单校验 使用方法参考layui官网 表单验证规则

            },
            form:{

            }
        }
    exports('competitioninfo_config',obj);
})
