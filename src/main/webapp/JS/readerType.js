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
function readerTypeModify(id,name,number) {
    $(".div").load("readerType_Modify.jsp",function () {
        $("#readerTypeModify #id").val(id);
        $("#readerTypeModify #name").val(name);
        $("#readerTypeModify #number").val(number);
    });
    showWindow();
}
/**修改读者类型*/
function modify() {
    if ($("#readerTypeModify #name").val() == ""){
alert("请输入类型名称!");
        $("#readerTypeModify #name").focus();
        return;
    }
    if ($("#readerTypeModify #number").val() == ""){
        alert("请输入可借数量!");
        $("#readerTypeModify #number").focus();
        return;
    }

    var url="readerType/modify";
    var data=$("#readerTypeModify").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="readerType/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type="json";
    $.post(url,data,callback,type);
}
/**添加页面加载*/
function readerTypeAdd() {
    $(".div").empty();
    $(".div").load("readerType_add.jsp");
    showWindow();
}
/**添加读者类型*/
function add() {
    if ($("#readerTypeAdd #name").val() == ""){
        alert("请输入类型名称!");
        $("#readerTypeAdd #name").focus();
        return;
    }
    if ($("#readerTypeAdd #number").val() == ""){
        alert("请输入可借数量!");
        $("#readerTypeAdd #number").focus();
        return;
    }
    var url="readerType/add";
    var data=$("#readerTypeAdd").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="readerType/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type="json";
    $.post(url,data,callback,type);
}
/**删除*/
function del(id) {
    var url="readerType/del/"+id;
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="readerType/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type="json";

    if (confirm("确认删除？")){
        $.post(url,callback,type);
    }
    
}
