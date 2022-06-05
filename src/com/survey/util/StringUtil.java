package com.survey.util;

public class StringUtil {

	public static String nullValue(Object o){
	 
			return nullValue(o,"");
	}
	public static String nullValue(Object o,String replacer){
		if(o==null||"".equals(o))
			return replacer;
		else
			return (String)o;
	}
	 
	public static String nvl(Object o,String replacer){
		if(o==null||"".equals(o))
			return replacer;
		else if(o instanceof Number)
			return (String)o;
		else if(o instanceof Boolean)
			return (Boolean)o==true?"1":"0";
		else 
			return "'"+(String)o+"'";
	}
}
