package com.aust.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

	/*localdate练习*/
public class LocalDate1 {
	
	public static void main(String[] args) {
	LocalDate today = LocalDate.now();
	LocalDate tormorrow = today.plus(1,ChronoUnit.DAYS);
	LocalDate yesterday = today.minusDays(1);
	
	System.out.println(today);
	System.out.println(tormorrow);
	System.out.println(yesterday);
	
	LocalDate independeceDay =  LocalDate.of(2018,Month.SEPTEMBER,20);
	DayOfWeek dayOfWeek = independeceDay.getDayOfWeek();
	System.out.println(dayOfWeek);
	
	DateTimeFormatter germanFormatter =
            DateTimeFormatter
                    .ofLocalizedDate(FormatStyle.MEDIUM)
                    .withLocale(Locale.GERMAN);

    LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
    System.out.println(xmas);
	
	
}
}
