$(function () {
    bookQuery("","");
});


function SubmitBookQuery() {
    var key=$("#f").val();
    var value=$("#key").val();
    if(value == ""){alert("请输入参数?");return;}
    $("#BookQuery table:not(:first)").empty();
    bookQuery(key,value);
    
}

function bookQuery(key,value) {
    var url="book/query";
    var data={
        key:key,
        value:value
    };
    var callback=function (data) {
        var html;
        if(data.flag){
            var html;
            html="<table width=\"98%\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                               bordercolor=\"#FFFFFF\" bordercolordark=\"#F6B83B\"\n" +
                "                                               bordercolorlight=\"#FFFFFF\">\n" +
                "                                            <tr align=\"center\" bgcolor=\"#e3F4F7\">\n" +
                "                                                <td width=\"17%\" bgcolor=\"#F9D16B\">条形码</td>\n" +
                "                                                <td width=\"31%\" bgcolor=\"#F9D16B\">图书名称</td>\n" +
                "                                                <td width=\"18%\" bgcolor=\"#F9D16B\">图书类型</td>\n" +
                "                                                <td width=\"19%\" bgcolor=\"#F9D16B\">出版社</td>\n" +
                "                                                <td width=\"15%\" bgcolor=\"#F9D16B\">书架</td>\n" +
                "                                            </tr>";
            for( let i of data.data){
                html+="<tr><td style=\"padding:5px;\">"+i.barcode+"</td>\n" +
                    "                                                <td style=\"padding:5px;\"><a href=\"book/dateil/"+i.id+"\">"+i.bookname+"</a>\n" +
                    "                                                </td>\n" +
                    "                                                <td style=\"padding:5px;\">"+i.booktype.typename+"</td>\n" +
                    "                                                <td style=\"padding:5px;\">"+i.publishing.pubname+"</td>\n" +
                    "                                                <td style=\"padding:5px;\">"+i.bookCase.name+"</td>\n" +
                    "                                            </tr>";

            }
            html+="</table>";
            $("#BookQuery").append(html);

        }else {
            html="<table width=\"100%\" height=\"30\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                                            <tr>\n" +
                "                                                <td height=\"36\" align=\"center\">暂无图书信息！</td>\n" +
                "                                            </tr>\n" +
                "                                        </table>";
            $("#BookQuery").append(html);
        }

    }
    var type="json";
    $.get(url,data,callback,type);
    
}