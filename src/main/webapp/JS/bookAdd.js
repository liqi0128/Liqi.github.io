/**
 * 异步请求
 *    图书类型 booktype
 *    出版社   publishing
 *    书架   bookcase
 * */
$(function () {
    booktype();
    publishing();
    bookcase();
});

function booktype() {
    var url="bookType/typelist";
    var callback=function (data) {
        if(data.flag){
            var html;
            for( let i of data.data){
                    html+="<option value=\""+i.id+"\" >"+i.typename+"</option>";
            }
            $("#bookAdd #typeId").append(html);
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";
    $.get(url,callback,type);
}function publishing() {
    var url="book/pub";
    var callback=function (data) {
        if(data.flag){
            var html;
            for( let i of data.data){
                    html+="<option value=\""+i.isbn+"\" >"+i.pubname+"</option>";
            }
            $("#bookAdd #publishing").append(html);
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";
    $.get(url,callback,type);
}function bookcase() {
    var url="case/caselist";
    var callback=function (data) {
        if(data.flag){
            var html;
            for( let i of data.data){
                    html+="<option value=\""+i.id+"\" >"+i.name+"</option>";
            }
            $("#bookAdd #bookcase").append(html);
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";
    $.get(url,callback,type);
}

function Add() {
    if ($("#bookAdd #barcode").val() == ""){
        alert("请输入条形码！");
        $("#bookAdd #barcode").focus();
        return;
    }if ($("#bookAdd #bookName").val() == ""){
        alert("请输入图书名称！");
        $("#bookAdd #bookName").focus();
        return;
    }if ($("#bookAdd #price").val() == ""){
        alert("请输入价格！");
        $("#bookAdd #price").focus();
        return;
    }



    var url="book/add";
    var data =$("#bookAdd").serialize();
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg)
            window.location.href="book/list"
        }else {
            alert(data.errorMsg);
        }
    }
    var type="json";
    $.post(url,data,callback,type);

}