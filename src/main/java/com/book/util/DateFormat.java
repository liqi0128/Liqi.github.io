package com.book.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateFormat {
     private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     /**时间转换String*/
     public static String dateFormat(Date date){
         try {
             return format.format(date);
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
     }
     /**String转换时间*/
     public static Date dateParse(String date){
         try {
             if (StringUtils.isEmpty(date)){
                 return format.parse(date);
             }
         } catch (ParseException e) {
             e.printStackTrace();
             return null;
         }
         return null;

     }
}
