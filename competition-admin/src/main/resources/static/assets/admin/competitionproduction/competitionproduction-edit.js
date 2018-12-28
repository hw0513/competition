/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/
layui.config({base : "assets/"}).extend({"competitionproduction_config":"admin/competitionproduction/competitionproduction-config","magicalcoderedit" : "magicalcoder/v001/rmp/magicalcoderedit"})
layui.use(["competitionproduction_config","magicalcoderedit"],function(){
    var magicalcoderedit = layui.magicalcoderedit(layui.competitionproduction_config);
    //在提交表单前执行回调方法
    var submitBeforeCallBack = function (postData) {
        return true;//则继续提交
    }
    magicalcoderedit.bindFormArea();
    magicalcoderedit.submitEvents(submitBeforeCallBack);
})
