/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/
//表单通用配置 列表页 详情页都需要
layui.define(['jquery'],function(exports){
    var obj =
        {
            tableNameRest:"competition_rest",
            tableName:"competition",
            moduleName:"competition",//sys_module的moduleName
            formVerifyEditData:{//详情页提交时表单校验 使用方法参考layui官网 表单验证规则

            },
            form:{

              enrollDatetimeBegin:{
                        renderConfig:{"calendar":false,"format":"yyyy-MM-dd HH:mm:ss","show":false,"range":false,"trigger":"click","type":"datetime","isInitValue":true,"showBottom":true,"inputType":"date","theme":"default","position":"absolute","lang":"cn","zIndex":66666666}
                    }
                ,enrollDatetimeEnd:{
                        renderConfig:{"calendar":false,"format":"yyyy-MM-dd HH:mm:ss","show":false,"range":false,"trigger":"click","type":"datetime","isInitValue":true,"showBottom":true,"inputType":"date","theme":"default","position":"absolute","lang":"cn","zIndex":66666666}
                    }
                ,productDatetimeEnd:{
                        renderConfig:{"calendar":false,"format":"yyyy-MM-dd HH:mm:ss","show":false,"range":false,"trigger":"click","type":"datetime","isInitValue":true,"showBottom":true,"inputType":"date","theme":"default","position":"absolute","lang":"cn","zIndex":66666666}
                    }
                ,judgeDatetimeEnd:{
                        renderConfig:{"calendar":false,"format":"yyyy-MM-dd HH:mm:ss","show":false,"range":false,"trigger":"click","type":"datetime","isInitValue":true,"showBottom":true,"inputType":"date","theme":"default","position":"absolute","lang":"cn","zIndex":66666666}
                    }
            }
        }
    exports('competition_config',obj);
})
