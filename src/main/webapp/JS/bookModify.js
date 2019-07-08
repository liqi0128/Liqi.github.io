
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
            var typeid=$("#bookModify #typeId").attr("typeid");
            for( let i of data.data){
                if (i.id == typeid){
                    html+="<option value=\""+i.id+"\" selected >"+i.typename+"</option>";
                }else{
                    html+="<option value=\""+i.id+"\" >"+i.typename+"</option>";
                }
            }
            $("#bookModify #typeId").append(html);
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
            var publishing=$("#bookModify #publishing").attr("publishing");
            for( let i of data.data){
                if (i.isbn == publishing){
                    html+="<option value=\""+i.isbn+"\" selected >"+i.pubname+"</option>";
                }else{
                    html+="<option value=\""+i.isbn+"\" >"+i.pubname+"</option>";
                }
            }
            $("#bookModify #publishing").append(html);
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
            var bookcase=$("#bookModify #bookcase").attr("bookcase");
            for( let i of data.data){
                if (i.id == bookcase){
                    html+="<option value=\""+i.id+"\" selected >"+i.name+"</option>";
                }else{
                    html+="<option value=\""+i.id+"\" >"+i.name+"</option>";
                }
            }
            $("#bookModify #bookcase").append(html);
        }else{
            alert(data.errorMsg)
        }
    }
    var type ="json";
    $.get(url,callback,type);
}

function modify() {
    var url="book/modify";
    var data =$("#bookModify").serialize();
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