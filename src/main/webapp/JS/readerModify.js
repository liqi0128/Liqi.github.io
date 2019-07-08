$(function () {
/**请求读者类型列表*/
var url="readerType/typeList";
var callback=function (data) {
    if(data.flag){
        var html;

        for (var i in data.data){
            if($("#typeid").attr("typeid")==data.data[i].id){
                html+="<option value=\""+data.data[i].id+"\" selected >"+data.data[i].name+"</option>";
            }else {
            html+="<option value=\""+data.data[i].id+"\">"+data.data[i].name+"</option>";
            }
        }
        $("#typeid").append(html);
    }else{
alert(data.errorMsg);
    }

}
var type="json";
$.get(url,callback,type);
});
/**修改表单提交*/
function modify() {
    var url="reader/update";
    var data=$("#readerModify").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="reader/list"
        }else{
            alert(data.errorMsg)
        }

    }
    var type ="json";
    $.post(url,data,callback,type);
}
