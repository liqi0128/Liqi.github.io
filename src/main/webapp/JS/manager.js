
/**用户修改*/
function managerModify(id){

    var url="user/purview/"+id;
    var callback=function (data) {

        if(data.flag){
            $(".div").load("manager_Modify.jsp",function(){//加载用户修改页面
                $(".div #id").val(data.data.id);
                $(".div #name").val(data.data.name);
                if(data.data.purview.sysset == 1){$(".div #sysset").attr("checked",true); }
                if(data.data.purview.readerset == 1){$(".div #readerset").attr("checked",true); }
                if(data.data.purview.bookset == 1){$(".div #bookset").attr("checked",true); }
                if(data.data.purview.borrowback == 1){$(".div #borrowback").attr("checked",true); }
                if(data.data.purview.sysquery == 1){$(".div #sysquery").attr("checked",true); }
            });
            showWindow();
        }else{
            alert(data.errorMsg);
        }
    }
    var type="json";
    $.get(url,callback,type);

}

function showWindow() {
    $('.div').show();  //显示弹窗
    $('#cover').css('display','block'); //显示遮罩层
}
// 关闭弹窗
function closeWindow() {
    $('.div').hide();  //隐藏弹窗
    $('#cover').css('display','none');   //显示遮罩层
}
/*修改提示*/
function PurviewModify() {
    var url="user/modify";
    var data=$("#modify").serialize();
    var callback=function(data){
        hint(data.errorMsg);
    }
    var type="json";
    $.post(url,data,callback,type);
}
/**提示是否删除*/
function delManager(name,id) {
    $(".div").empty();
    var html="<table width=\"292\" height=\"175\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"Images/subBG.jpg\"><tr><th>\n" +
        "    \t\t<h3>是否删除《"+name+"》用户？</h3>\n" +
        "   <input type=\"button\" value=\"是\" style=\"width: 50px; height: 30px;\" onclick='del("+id+")' />\n" +
        "   <input type=\"button\" value=\"否\" style=\"width: 50px; height: 30px;\" onclick='closeWindow()'/>\n" +
        "    </th></tr></table>";
    $(".div").append(html);
    showWindow();
}
/**用户删除*/
function del(id) {
    var url="user/del/"+id;
    var callback=function(data){
        hint(data.errorMsg);
    }
    var type="json";
    $.post(url,callback,type);
}
/**用户添加*/
function addManaget() {
    $(".div").empty();
    $(".div").load("manager_add.jsp");//加载用户添加页面
    showWindow();
}
function add() {
    if($(".div #name").val()==""){
        alert("请输入管理员名称!");$(".div #name").focus();return;
    }
    if($(".div #pwd").val()==""){
        alert("请输入管理员密码!");$(".div #pwd").focus();return;
    }
    if($(".div #pwd1").val()==""){
        alert("请确认管理员密码!");$(".div #pwd1").focus();return;
    }
    if($(".div #pwd").val()!=$(".div #pwd1").val()){
        alert("您两次输入的管理员密码不一致，请重新输入!");$(".div #pwd").focus();return;
    }
    var url="user/add";
    var data=$("#add").serialize();
    var callback=function (data) {
        if(data.flag){
            hint(data.errorMsg);
        }else{
            $(".div #erro").html(data.errorMsg);
        }

    }
    var type="json";
    $.post(url,data,callback,type);
}

/**提示框*/
function hint(data) {
    $(".div").empty();
    var html="<table width=\"292\" height=\"175\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" background=\"Images/subBG.jpg\"><tr><th>\n" +
        "    \t\t<h2>"+data+"</h2>\n" +
        "    \t\t<input type=\"button\" value=\"确认\" style=\"width: 50px; height: 30px;\" onclick='location.href=(\"user/list\")'/>\n" +
        "    </th></tr></table>";
    $(".div").append(html);
}
