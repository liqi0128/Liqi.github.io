
function pwdold1() {
    var name=$("#name").val();
    var ol=$("#oldpwd").val();
    var url="Manager/oldpwd"
    var data={
        name:name,
        pwd:ol
    };
    var callback=function (data) {
        if(data.flag){
            $("#oldpwd").next().attr("flag","true");
            $("#oldpwd").next().html("正确");
        }else {
            $("#oldpwd").next().html("错误！");
            $("#oldpwd").next().attr("flag","false");
        }
    }
    var type="json";
    $.post(url,data,callback,type);
}
function pwdModify() {

    var name=$("#name").val();
    if ($("#oldpwd").val() == ""){
        alert("请输入原密码！");return false;
    }
    if (!$("#oldpwd").next().attr("flag")){
        alert("原密码有误！");return false;
    }
    if($("#pwd").val() == ""){
        alert("请输入新密码！");return false;
    }
    if($("#pwd1").val() == ""){
        alert("请确认新密码！");return false;
    }
    if($("#pwd").val() != $("#pwd1").val()){
        alert("两个密码不一致！");return false;
    }
    var url="Manager/pwdModify"
    var data={
        name:name,
        pwd:$("#pwd").val()
    };
    var callback=function (data) {
        if(data.flag){
            alert("口令修改成功，请重新登陆！")
            window.location.href="Manager/out"
        }else {
            alert("口令修改失败！")
        }
    }
    var type="json";
    $.post(url,data,callback,type);
}