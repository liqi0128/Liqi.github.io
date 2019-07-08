
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
/**书架修改框*/
function bookcaseModify(id,name) {
    $(".div").load("bookCase_Modify.jsp",function () {
        $("#bookcaseModify #id").val(id);
        $("#bookcaseModify #name").val(name);
    });
    showWindow();
}
function modify() {

    var url="case/modify";
    var data=$("#bookcaseModify").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="case/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type="json";
    $.post(url,data,callback,type);
}

function bookcaseAdd() {
    $(".div").empty();
    $(".div").load("bookcase_add.jsp")
    showWindow();
    
}
function add() {
var url="case/add";
var data=$("#bookcaseAdd").serialize();
var callback=function (data) {
    if(data.flag){
        alert(data.errorMsg)
        window.location.href="case/list"
    }else{
        alert(data.errorMsg)
    }
}
var type="json";
$.post(url,data,callback,type);
}

function DelCase(id) {
    var url ="case/del/"+id;
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="case/list"
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";

    if (confirm("确认删除！")){
    $.post(url,callback,type);
    }
    
}