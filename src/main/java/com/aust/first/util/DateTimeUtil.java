package com.aust.first.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	private DateTimeUtil() {
	}

	public static LocalDateTime parse(String date, String pattern) throws Exception {
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
	}
	
	public static String getDayFileDir(){
		LocalDate localDate = LocalDate.now();
		return DateTimeFormatter.ofPattern("yyyyMMdd").format(localDate) + "/";
	}
	
}
