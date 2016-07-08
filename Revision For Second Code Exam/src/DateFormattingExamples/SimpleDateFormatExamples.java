package DateFormattingExamples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExamples {

	public static void main(String[] args){
		
		/*
		 * Prints a formatted date
		 */
		
		System.out.println(new SimpleDateFormat("dd-MM-yy").format(new Date()));
		
		/*
		 * List of different formats
		 */
		
		String[] dateFormats = {
			
				"dd-MMM-yyyy",
				"E MMMM d'th', yyyy",
				"w'th week of' yyyy",
				"'Today is' EEEE"
				
		};
		
		Date today = new Date();
		System.out.println("Default format for the date is " + 
		DateFormat.getDateInstance().format(today));
		for(String dateFormat : dateFormats) {
			System.out.printf("Date in pattern \"%s\" is %s %n", dateFormat, new SimpleDateFormat(dateFormat).format(today));
		}
		
		/*
		 * Time formats
		 */
		String[] timeFormats = {
				"h:mm a",
				"hh:mm 'o''clock",
				"H:mm",
				"hh:mm:ss:S",
				"K:mm:ss a, zzzz"
		};
		
		System.out.println("Default format for the time is " +
		DateFormat.getTimeInstance().format(today));
		for(String timeFormat : timeFormats) {
			System.out.printf("Time in pattern \"%s\" is %s %n", timeFormat, new SimpleDateFormat(timeFormat).format(today));
		}
	}
}
