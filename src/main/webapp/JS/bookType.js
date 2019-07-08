//显示
function showWindow() {
    $('.div').show();  //显示弹窗
    $('#cover').css('display','block'); //显示遮罩层
}
// 关闭弹窗
function closeWindow() {
    $('.div').hide();  //隐藏弹窗
    $('#cover').css('display','none');   //显示遮罩层
}
/**修改页面加载*/
function bookTypeModify(id,name,days){
    $(".div").load("bookType_Modify.jsp",function () {
        $("#bookTypeModify #id").val(id);
        $("#bookTypeModify #typename").val(name);
        $("#bookTypeModify #days").val(days);
    });
    showWindow();
}
function modify() {
    var url="bookType/modify";
    var data=$("#bookTypeModify").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="bookType/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";
    $.post(url,data,callback,type);
}
/**添加页面加载*/
function bookTypeAdd() {
    $(".div").empty();
    $(".div").load("bookType_add.jsp");
    showWindow();
}
/**添加*/
function add() {
    var url="bookType/add";
    var data=$("#bookTypeAdd").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="bookType/list"
        }else{
            alert(data.errorMsg)
        }
        
    }
    var type="json";
    $.post(url,data,callback,type);
}
function del(id) {
    var url="bookType/del/"+id;
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="bookType/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type="json";
    if(confirm("确认删除？")){
        $.post(url,callback,type);
    }

}