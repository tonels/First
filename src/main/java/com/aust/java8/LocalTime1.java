package com.aust.java8;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * 时区之间并不是整小时区别，
 */
public class LocalTime1 {

    public static void main(String[] args) throws Exception {

       /*当前IP*/
    	InetAddress localHost = InetAddress.getLocalHost();
    	InetAddress byName = InetAddress.getByName("www.google.com");
    	
    	System.out.println(byName);
    	System.out.println(localHost);
    	
//       当前时间
        Clock clock = Clock.systemDefaultZone();
        long t0 = clock.millis();
        
        System.out.println("clock= " + clock);
        System.out.println("t0= " + t0);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        
        System.out.println("instant = " + instant);
        System.out.println("legacyDate = " + legacyDate);

//      获取时区
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        ZoneId zone3 = ZoneId.of("Asia/Shanghai");
        
        /*并没有北京时间*/
//        ZoneId zone4 = ZoneId.of("Asia/Beijing");
        

        System.out.println("Europe/Berlin.getRules = " + zone1.getRules());
        System.out.println("Brazil/East.getRules = " + zone2.getRules());
        System.out.println("Asia/Shanghai.getRules = " + zone3.getRules());
//		System.out.println("Asia/Beijing.getRules = " + zone4.getRules());

        // 时间
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        LocalTime now3 = LocalTime.now(zone3);
//        LocalTime now4 = LocalTime.now(zone4);

        System.out.println("德国柏林时间为："+now1);
        System.out.println("巴西东部时间为："+now2);
        System.out.println("当前上海时间为：" + now3);
//      System.out.println("当前北京时间为" + now4);

        System.out.println("柏林比巴西时间早吗？" + now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        System.out.println(hoursBetween);
        System.out.println(minutesBetween);


        // create time

        LocalTime now = LocalTime.now();
        System.out.println("现在时间为："+ now);

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);

    }

}