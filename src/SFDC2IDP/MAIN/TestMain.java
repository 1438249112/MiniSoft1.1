package SFDC2IDP.MAIN;

import java.io.UnsupportedEncodingException;

public class TestMain {
public static void main(String[] args) throws UnsupportedEncodingException {
	String intNumber = "0";
	Object o = new java.math.BigDecimal(Math.round(new java.math.BigDecimal(intNumber).doubleValue())).toPlainString();
System.out.println(o);
	//	String date = "2012-11-17";
//	System.out.println(	org.apache.commons.lang.time.DateFormatUtils.formatUTC(org.joda.time.format.ISODateTimeFormat.dateTime().parseDateTime(date).getMillis(), "yyyy-MM-dd HH:mm:ss:SSS", java.util.Locale.CHINA).toString()
//);
System.out.println(new java.math.BigDecimal(Math.round(new java.math.BigDecimal(intNumber).doubleValue())).toPlainString());


String test = "将截断字符串或二进制数据�?";
System.out.println(new String (test.getBytes(),"UTF8"));
}
}
