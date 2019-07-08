/**读者验证*/
function checkreader() {
    var barcode=$("#barcode").val();
    if (barcode == ""){alert("请输入读者条形码？"); return;}
    var url="reader/bercode/"+barcode;
    var callback=function (data) {
        if(data.flag){
            $("#readerid").val(data.data.id);
            $("#readername").val(data.data.name);
            $("#sex").val(data.data.sex);
            $("#readerType").val(data.data.readerType.name);
            $("#paperType").val(data.data.paperType);
            $("#paperNo").val(data.data.paperNO);
            $("#number").val(data.data.readerType.number);
            $("#erro").html("");
        }else {
            $("#readerid").val("");
            $("#readername").val("");
            $("#sex").val("");
            $("#readerType").val("");
            $("#paperType").val("");
            $("#paperNo").val("");
            $("#number").val("");
            $("#erro").html(data.errorMsg);

        }

    }
    var type="json";
    $.get(url,callback,type);
}
function barcodeBack() {
    $("#readerid").val("");
    $("#readername").val("");
    $("#sex").val("");
    $("#readerType").val("");
    $("#paperType").val("");
    $("#paperNo").val("");
    $("#number").val("");
}
/**查询图书信息*/
function checkbook() {
    var val=$('input:radio[name="f"]:checked').val();
    var inputkey=$("#inputkey").val();
    if(inputkey == ""){alert("请输入图书信息！"); return;}
    
    var url="book/info";
    var data ={radio:val ,inputkey:inputkey};
    var callback=function (data) {

        if(data.flag){
            var html;
            for( let i of data.data){
                html+="<tr align=\"center\">\n" +
                    "                     <td width=\"29%\" height=\"25\">&nbsp;"+i.bookname+"</td>\n" +
                    "                     <td width=\"12%\">&nbsp;"+ new Date().toLocaleDateString()+"</td>\n" +
                    "                     <td width=\"14%\">&nbsp;"+backTime(i.booktype.days).toLocaleDateString()+"</td>\n" +
                    "                     <td width=\"17%\">&nbsp;"+i.publishing.pubname+"</td>\n" +
                    "                     <td width=\"14%\">&nbsp;"+i.bookCase.name+"</td>\n" +
                    "                     <td width=\"9%\">&nbsp;"+i.price+"</td>\n" +
                    "                     <td width=\"5%\"><a href=\"javascript:void(0); \" onclick=\"BookBorrow("+i.id+","+i.booktype.days+")\">借阅</a></td>\n" +
                    "                   </tr>";
            }
            $("#bookList tr:not(:first)").empty();
            $("#bookList").append(html);
        }else {
            html+="<tr align=\"center\">\n" +
                "                     <td ><font  color=\"red\">"+data.errorMsg+"</font></td>\n" +
                "                   </tr>";
            $("#bookList tr:not(:first)").empty();
            $("#bookList").append(html);
        }

        
    }
    var type ="json";
    $.get(url,data,callback,type);

}

/**计算时间*/
function backTime(day) {
    let a = Date.now();
    a += day * (24 * 3600 * 1000);         //将天数转换成毫秒后与开始时间相加得到结束时间的毫秒数
    var date=new Date(a);
    return date;
}

/**借阅*/
function BookBorrow(bid,day) {
    var readerid= $("#readerid").val();

    if(readerid == ""){alert("请验证读者信息！");return;}
    var number=$("#number").val();
    if(number == 0){alert("你已无借阅数量！");return;}
    
    var url="borrow/borrowadd";
    var data={readerid:readerid,
            bookid:bid,
            borrowTime:new Date(),
            backTime:backTime(day)
    };
    var callback=function (data) {
        if(data.flag){
            alert(data.errorMsg);
            $("#number").val(Number(number)-1);
        }else {
            alert(data.errorMsg);
        }
        
    }
    var type="json";
    if(confirm("确认借阅？")){
    $.post(url,data,callback,type);
    }
    
}