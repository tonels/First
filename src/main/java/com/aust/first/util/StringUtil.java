package com.aust.first.util;

import java.util.Random;


public class StringUtil {

	private StringUtil() {
	}

	public static boolean isNullStr(Object strin) {
		if(strin == null){
			return true;
		}
		String str = strin.toString();
		boolean flag = false;
		if ("null".equals(str) || "".equals(str) || "".equals(str.trim())) {
			flag = true;
		}
		return flag;
	}

	//首字母转小写
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	
	/**
     * 得到一个String值的指定长度的字符串形式
     * NOTE:	不足的前面添'0'
     * 			
     * @param s
     * @param len
     * @param cutHead
     * 		当s的长度大于len时，截取方式：true,截掉头部；否则从截掉尾部
     * 		例如getStringByAppointLen("12345",3,true) ---> "345"
     * @return
     */
    public static String getStringByAppointLen(String s,int len,boolean cutHead){
    	if(s == null || len <=0){
    		s = "";
    	}
    	if(len > s.length()){
    		int size = len - s.length();
    		StringBuilder sb = new StringBuilder();
    		while(size -- > 0){
    			sb.append("0");
    		}
    		sb.append(s);
    		return sb.toString();
    	}else if(len == s.length()){
    		return s;
    	}else{
    		if(cutHead){
    			return s.substring(s.length() - len, s.length());
    		}else{
    			return s.substring(0,len);
    		}
    	}
    }
    
    /**
     * 得到一个Long值的指定长度的字符串形式
     * 
     * @param l
     * @param len
     * @return
     */
    public static String getStringByAppointLen(String l,int len){
    	return getStringByAppointLen(l, len, true);
    }
    
    /**
     * 通过ID生成存储路径
     * @param id
     * @return
     */
    public static String getFileDirPathById(String dmId){
    	String s = StringUtil.getStringByAppointLen(dmId, 19);
    	StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0,5)).append("/")
			.append(s.substring(5,11)).append("/")
			.append(s.substring(11,15)).append("/")
			.append(s.substring(15,19)).append("/");
		return sb.toString();
	}
    
    public static String nullToString(String value) {
		return value == null || "null".equals(value) ? "" : value.trim();
	}
    
    public static Long stringToLong(String value) {
		Long l;
		value = nullToString(value);
		if ("".equals(value)) {
			l = 0L;
		} else {
			try {
				l = Long.valueOf(value);
			} catch (Exception e) {
				l = 0L;
			}
		}
		return l;
	}
    

    // 生成随机的6位短信验证码
    public static String captchaSix(){
		String sources = "0123456789";
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for(int j=0;j<6;j++){
			flag.append(sources.charAt(rand.nextInt(10))+"");
		}
    	return flag.toString();
    }
   
}
