package iu.other.birthday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Birthday {

    public static void myBirthday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = sdf.parse("1993-01-01");
            Date end = sdf.parse("2050-01-01");
            Date temp = start;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);
            while (temp.getTime() < end.getTime()) {
                temp = calendar.getTime();
                String s = sdf.format(temp);
                Lunar lunar = new Lunar(calendar);
                String str = lunar.toString().substring(5);
                /*if (str.equals("七月廿六") ) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                        System.out.println("牛建业：" + lunar + " 星期日" );
                    }
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println("牛建业：" + lunar + " 星期六");
                    }
                }*/
                /*if (str.equals("四月初九")) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                        System.out.println("杨伟东：" + lunar + " 星期日" );
                    }
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println("杨伟东：" + lunar + " 星期六");
                    }
                }*/
                /*if (str.equals("八月廿七") ) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                        System.out.println("张文敏：" + lunar + " 星期日" );
                    }
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println("张文敏：" + lunar + " 星期六");
                    }
                }*/
                /*if (str.equals("十二月初十")) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                        System.out.println("王田芳：" + lunar + " 星期日" );
                    }
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println("王田芳：" + lunar + " 星期六");
                    }
                }*/
                if (str.equals("一月廿二") ) {
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                        System.out.println("邸雅琴：" + lunar + " 星期日" );
                    }
                    if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.println("邸雅琴：" + lunar + " 星期六");
                    }
                }
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
