/**读者验证*/
function checkreader() {
    var barcode=$("#barcode").val();
    if (barcode == ""){alert("请输入读者条形码？"); return;}
    var url="reader/bercode/"+barcode;
    var callback=function (data) {
        if(data.flag){

            $("#readername").val(data.data.name);
            $("#sex").val(data.data.sex);
            $("#readerType").val(data.data.readerType.name);
            $("#paperType").val(data.data.paperType);
            $("#paperNo").val(data.data.paperNO);
            $("#number").val(data.data.readerType.number);
            BorrowList(data.data.id);
            $("#erro").html("");
        }else {

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
    $("#BorrowList tr:not(:first)").empty();
}


/**计算时间*/
function backTime(days,day) {
    let a = new Date(days).getTime();
    a += day * (24 * 3600 * 1000);         //将天数转换成毫秒后与开始时间相加得到结束时间的毫秒数
    var date=new Date(a);
    return date;
}
/**读者借阅列表*/
function BorrowList(readerid) {
    var url="borrow/borrowList/"+readerid;
    var callback=function (data) {
        if(data.flag){
            var html;
            for( let i of data.data){
                html+="<tr>\n" +
                    "                     <td height=\"25\" style=\"padding:5px;\">&nbsp;"+i.bookinfo.bookname+"</td>\n" +
                    "                     <td style=\"padding:5px;\">"+new Date(i.borrowTime).toLocaleDateString()+"</td>\n" +
                    "                     <td style=\"padding:5px;\">"+new Date(i.backTime).toLocaleDateString()+"</td>\n" +
                    "                     <td align=\"center\">&nbsp;"+i.bookinfo.publishing.pubname+"</td>\n" +
                    "                     <td align=\"center\">&nbsp;"+i.bookinfo.bookCase.name+"</td>\n" +
                    "                     <td width=\"13%\" align=\"center\">&nbsp;"+i.bookinfo.price+"</td>\n" +
                    "                     <td width=\"12%\" align=\"center\"><a href=\"javascript:void(0);\" onclick='BookRenew(this,"+i.bookinfo.booktype.days+","+i.id+")'>续借</a>&nbsp;</td>\n" +
                    "                   </tr>";
            }
            $("#BorrowList tr:not(:first)").empty();
            $("#BorrowList").append(html);
        }else {
            html+="<tr align=\"center\">\n" +
                "                     <td ><font  color=\"red\">"+data.errorMsg+"</font></td>\n" +
                "                   </tr>";
            $("#BorrowList tr:not(:first)").empty();
            $("#BorrowList").append(html);
        }

    }
    var type="json";
    $.get(url,callback,type);
    
}

function BookRenew(obj,day,id) {
    $(obj).parent().parent().attr("id","renew");
    var html=$("#renew td:eq(2)").html();
    var date=backTime(html,day+1);//计算续借后的时间
    /*console.log(html);
    console.log(date.toLocaleDateString());*/
    var url="borrow/renew";
    var data={backTime:date,id:id};
    var callback=function (data) {
        if(data.flag){
            $("#renew td:eq(2)").html(backTime(html,day).toLocaleDateString());
            $(obj).parent().parent().removeAttr("id");
            alert(data.errorMsg);
        }else {
            $(obj).parent().parent().removeAttr("id");
            alert(data.errorMsg);
        }
        
    }
    var type ="json";
    if(confirm("确认续借？")){
    $.post(url,data,callback,type);}
}