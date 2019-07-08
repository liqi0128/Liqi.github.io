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

function add() {
    if($("#readerAdd #name").val() ==""){
        alert("请输入名字！");
        $("#readerAdd #name").focus();
        return;
    }
    if($("#readerAdd #barcode").val() ==""){
        alert("请输入条形码！");
        $("#readerAdd #barcode").focus();
        return;
    }
    if($("#readerAdd #paperNO").val() ==""){
        alert("请输入证件号！");
        $("#readerAdd #paperNO").focus();
        return;
    }

    var url="reader/add";
    var data=$("#readerAdd").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg);
            window.location.href="reader/list"

        }else {
            alert(data.errorMsg);
        }

    }
    var type="json";
$.post(url,data,callback,type);

}