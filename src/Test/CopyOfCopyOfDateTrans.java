package Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CopyOfCopyOfDateTrans {
	public static void main(String ...arg) throws ParseException {
		
		String  date = "2017-02-22T11:36:11.000+0000";
		System.out.println(org.joda.time.format.ISODateTimeFormat.dateTime().parseDateTime(date).toDate());
		System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(org.joda.time.format.ISODateTimeFormat.dateTime().parseDateTime(date).toDate()).toString());

		System.out.println(org.apache.commons.lang.time.DateFormatUtils.formatUTC(org.joda.time.format.ISODateTimeFormat.dateTime().parseDateTime(date).getMillis(), "yyyy-MM-dd HH:mm:ss:SSS", java.util.Locale.CHINA));
	}
}

