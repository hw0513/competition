/**
* 代码为自动生成 Created by www.magicalcoder.com
* 如果你改变了此类 read 请将此行删除
* 欢迎加入官方QQ群:323237052
*/

layui.config({base : "assets/"}).extend({"productmaterial_config":"admin/productmaterial/productmaterial-config","magicalcoderlist" : "magicalcoder/v001/rmp/magicalcoderlist"})
layui.use(["magicalcoderlist","productmaterial_config"],function(){
    var config = $.extend(layui.productmaterial_config,{
        layTable : {
            //表格内容
            elem : '#newsList',
            id : "newsListTable"
            },
            //排序跟数据库实际字段名的映射
        sortMap:{
            productMaterialId:'product_material_id',productId:'product_id',dictId:'dict_id',productFile:'product_file'
        }
    });
    var  magicalcoderlist = layui.magicalcoderlist(config);
    //绑定所有查询区域控件
    magicalcoderlist.bindQueryArea();
    //表格
    var cols = [[
        {type: "checkbox", fixed:"left", width:50},
                {field: 'productMaterialId', title: '参赛材料唯一标识', minWidth:100, align:"center",sort:true},

            {field: 'productId', title: '材料所属产品ID', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productId) +'" class="magicalcoder-table-text layui-input security_list_table_form_productId" name="productId" data-identify="'+d.productMaterialId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="材料所属产品ID"/>'
                }
                , sort:true
            },

            {field: 'dictId', title: '材料字典id', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.dictId) +'" class="magicalcoder-table-text layui-input security_list_table_form_dictId" name="dictId" data-identify="'+d.productMaterialId+'" lay-verify="magicalCoderVerify" magicalcoder-verify=""  placeholder="材料字典id"/>'
                }
                , sort:true
            },

            {field: 'productFile', title: '材料文件', minWidth:200,templet:function (d) {
                    return '<input type="text" value="'+ magicalcoderlist.escapeHTML(d.productFile) +'" class="magicalcoder-table-text layui-input security_list_table_form_productFile" name="productFile" data-identify="'+d.productMaterialId+'" lay-verify="magicalCoderVerify|mc_required" magicalcoder-verify=""  placeholder="材料文件"/>'
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
