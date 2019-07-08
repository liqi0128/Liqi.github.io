
$(function () {
    borrowQuery("","","","");
});

function checkBorrowQuery() {
    var checkbox=$("#borrowQuery input:checkbox:checked").length;//选择的个数
    var key;
    var value;
    var sdate;
    var edate;

    if(checkbox == 2){
        key=$("#borrowQuery #f").val();
        value=$("#borrowQuery #key").val();
        sdate=$("#borrowQuery #sdate").val();
        edate=$("#borrowQuery #edate").val();
        if(value == ""){alert("请输入参数！");return false;}
        if(sdate == ""){alert("请输入开始时间！");return false;}
        if(edate == ""){alert("请输入结束时间！");return false;}
    }else if(checkbox == 1){
        if($("#borrowQuery input:checkbox:checked").val() == "a"){
            key=$("#borrowQuery #f").val();
            value=$("#borrowQuery #key").val();
            if(value == ""){alert("请输入参数！");return false;}
        }else {
            sdate=$("#borrowQuery #sdate").val();
            edate=$("#borrowQuery #edate").val();
            if(sdate == ""){alert("请输入开始时间！");return false;}
            if(edate == ""){alert("请输入结束时间！");return false;}
        }
    }else {
        alert("请选择查询方式!");return false;
    }
    /*console.log(checkbox);
    console.log(key);
    console.log(value);
    console.log(sdate);
    console.log(edate);*/
    borrowQuery(key,value,sdate,edate)


    
}



function borrowQuery(key,value,sdate,edate) {
    $("#Query").empty();
    var url="borrow/query";
    var data={
        key:key,
        value:value,
        sdate:sdate,
        edate:edate
    };
    var callback=function (data) {
        var html;
        if(data.flag){
            html="<table width=\"98%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#FFFFFF\"\n" +
                "                         bordercolordark=\"#F6B83B\" bordercolorlight=\"#FFFFFF\">\n" +
                "                    <tr align=\"center\" bgcolor=\"#e3F4F7\">\n" +
                "                      <td width=\"11%\" bgcolor=\"#F9D16B\">图书条形码</td>\n" +
                "                      <td width=\"29%\" bgcolor=\"#F9D16B\">图书名称</td>\n" +
                "                      <td width=\"15%\" bgcolor=\"#F9D16B\">读者条形码</td>\n" +
                "                      <td width=\"13%\" bgcolor=\"#F9D16B\">读者名称</td>\n" +
                "                      <td width=\"12%\" bgcolor=\"#F9D16B\">借阅时间</td>\n" +
                "                      <td width=\"12%\" bgcolor=\"#F9D16B\">应还时间</td>\n" +
                "                      <td width=\"8%\" bgcolor=\"#F9D16B\">是否归还</td>\n" +
                "                    </tr>";
            for( let i of data.data){
                var ifback;
                if(i.ifback==1){ifback="已归还";}else {ifback="<font style=\"color: red\">未归还</font>";}
                html+="<tr align=\"center\">\n" +
                    "                      <td style=\"padding:5px;\">"+i.bookinfo.barcode+"</td>\n" +
                    "                      <td style=\"padding:5px;\">"+i.bookinfo.bookname+"</td>\n" +
                    "                      <td style=\"padding:5px;\">"+i.reader.barcode+"</td>\n" +
                    "                      <td style=\"padding:5px;\">"+i.reader.name+"</td>\n" +
                    "                      <td style=\"padding:5px;\">"+new Date(i.borrowTime).toLocaleDateString()+"</td>\n" +
                    "                      <td style=\"padding:5px;\">"+new Date(i.backTime).toLocaleDateString()+"</td>\n" +
                    "                      <td align=\"center\" style=\"padding:5px;\">"+ifback+"</td>\n" +
                    "                    </tr>";

            }
            html+="</table>";
            $("#Query").append(html);

        }else {
            html="<table width=\"100%\" height=\"30\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                    <tr>\n" +
                "                      <td height=\"36\" align=\"center\">暂无图书借阅信息！</td>\n" +
                "                    </tr>\n" +
                "                  </table>"
            $("#Query").append(html);
        }

    }
    var type="json";
    $.get(url,data,callback,type);
}


