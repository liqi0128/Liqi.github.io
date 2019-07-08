$(function () {
    $("#bremind").empty();
    var url="borrow/bremind";
    var callback=function (data) {
        var html;
        if(data.flag){
            html="<table width=\"98%\"  border=\"1\" cellpadding=\"0\" cellspacing=\"0\" bordercolor=\"#FFFFFF\" bordercolordark=\"#F6B83B\" bordercolorlight=\"#FFFFFF\">\n" +
                "  <tr align=\"center\" bgcolor=\"#e3F4F7\">\n" +
                "    <td width=\"15%\" bgcolor=\"#F9D16B\">图书条形码</td>\n" +
                "    <td width=\"28%\" bgcolor=\"#F9D16B\">图书名称</td>\n" +
                "    <td width=\"17%\" bgcolor=\"#F9D16B\">读者条形码</td>\n" +
                "    <td width=\"9%\" bgcolor=\"#F9D16B\">读者名称</td>\n" +
                "    <td width=\"15%\" bgcolor=\"#F9D16B\">借阅时间</td>\n" +
                "    <td width=\"16%\" bgcolor=\"#F9D16B\">应还时间</td>\n" +
                "    </tr>";
            for( let i of data.data){

                html+=" <tr>\n" +
                    "    <td style=\"padding:5px;\">"+i.bookinfo.barcode+"</td>\n" +
                    "    <td style=\"padding:5px;\">"+i.bookinfo.bookname+"</td>\n" +
                    "    <td style=\"padding:5px;\">"+i.reader.barcode+"</td>\n" +
                    "    <td style=\"padding:5px;\">"+i.reader.name+"</td>\n" +
                    "    <td style=\"padding:5px;\">"+new Date(i.borrowTime).toLocaleDateString()+"</td>\n" +
                    "    <td style=\"padding:5px;\">"+new Date(i.backTime).toLocaleDateString()+"</td>\n" +
                    "    </tr>";

            }
            html+="</table>";
            $("#bremind").append(html);

        }else {
            html="<table width=\"100%\" height=\"30\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "            <tr>\n" +
                "              <td height=\"36\" align=\"center\">暂无到期提醒信息！</td>\n" +
                "            </tr>\n" +
                "          </table>"
            $("#bremind").append(html);
        }

    }
    var type="json";
    $.get(url,callback,type);

});

