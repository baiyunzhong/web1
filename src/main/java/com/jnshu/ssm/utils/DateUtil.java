package com.jnshu.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * author : baiyunzhong
 * created time : 2019/8/5
 * 用于日期类型和字符串类型之间的转换
 */
public class DateUtil {
   /* String pattern="yyyy年MM月dd日";
    SimpleDateFormat sdf=new SimpleDateFormat(pattern);*/
    private static final Logger LOGGER = Logger.getLogger("DateUtil");
    private static SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日");
    public static String dateToString(Date date){
        try {
            if(!date.equals("")&&date!=null){
                return sdf.format(date);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "格式异常";

    }
    public static String longToString(Long time) {
        try {
            if(time.equals("")||time==null){
                LOGGER.info("转换后日期："+null);
                return null;
            } else {
                LOGGER.info("转换后日期："+sdf.format(time));
                return sdf.format(time);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

}
