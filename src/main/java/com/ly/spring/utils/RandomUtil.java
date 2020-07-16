package com.ly.spring.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class RandomUtil {
public String getRand() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String format = sdf.format(date);
	return format;
}

public String getNewTime() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String format = sdf.format(date);
	return format;
	
}
public String getNewDate() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String format = sdf.format(date);
	return format;
	
}
}
