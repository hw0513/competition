/**
 * @author 黄维
 * 联系1778134055@qq.com
 **/
layui.config({base : "assets/"}).extend({"competitioninfo_config":"admin/competitioninfo/competitioninfo-config","magicalcoderedit" : "magicalcoder/v001/rmp/magicalcoderedit"})
layui.use(["competitioninfo_config","magicalcoderedit"],function(){
    var magicalcoderedit = layui.magicalcoderedit(layui.competitioninfo_config);
    //在提交表单前执行回调方法
    var submitBeforeCallBack = function (postData) {
        return true;//则继续提交
    }
    magicalcoderedit.bindFormArea();
    magicalcoderedit.submitEvents(submitBeforeCallBack);
})
