package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class JSPUtil {

	public static List<String> getAllDatesInRange(String stDate, String eDate) 
			throws ParseException{
		List<String> retList = new LinkedList<String>();
		Date result = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = formatter.parse(stDate);
		Date endDate = formatter.parse(eDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		while(calendar.getTime().before(endDate)){
			result = calendar.getTime();
			retList.add(formatter.format(result));			
			calendar.add(Calendar.DATE, 1);
		}
		result = calendar.getTime();
		retList.add(formatter.format(result));
		return retList;
	}
}
