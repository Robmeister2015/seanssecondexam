package DateFormattingExamples;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormattingAndLocales {

	public static void main(String[] args){
		
		/*
		 * Prints the date format in the given locales
		 */
		Date today = new Date();
		Locale[] locales = { Locale.CANADA, Locale.FRANCE, Locale.GERMANY, Locale.ITALY };
		for(Locale locale : locales) {
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.println("Date in locale " + locale + " is: " + dateFormat.format(today));
		}
		
		/*
		 * Different types of date formats
		 */
		int[] dateStyles = {
				DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL, DateFormat.DEFAULT
		};
		
		System.out.println("Today's date in different styles: ");
		
		for(int dateStyle : dateStyles) {
			DateFormat dateFormat = DateFormat.getDateInstance(dateStyle);
			System.out.println(dateFormat.format(today));
		}
		
		/*
		 * Different date formats in different locales
		 */
		
		System.out.printf("%5s \t %10s \t %10s \t %10s %n",
				"Locale", "Date", "Time", "Date with Time");
		
		for(Locale locale : locales) {
			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
			
			DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL, locale);
			
			System.out.printf("%5s \t %10s \t %10s \t %20s %n", locale, dateFormat.format(today), timeFormat.format(today), dateTimeFormat.format(today));
		}
		
	}
	
}
