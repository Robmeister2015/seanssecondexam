package NumberFormattingExamples;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingANumber {

	public static void main(String[] args){
		
		long tenMillionNumber = 10_000_000L;
		
		/*
		 * Formats the above long into German localised format
		 */
		NumberFormat germanFormat = NumberFormat.getInstance(Locale.GERMANY);
		String localisedTenMillionString = germanFormat.format(tenMillionNumber);
		System.out.println("Ten million in German locale is " + localisedTenMillionString);
		
		/*
		 * Parses the number into German format and print a success message based on this
		 */
		try{
			Number parsedAmount = germanFormat.parse(localisedTenMillionString);
			if(tenMillionNumber == parsedAmount.longValue()){
				System.out.println("Successfully parsed the number for the locale");
			}
		}catch(ParseException pe) {
			System.err.println("Error: Cannot parse the number for the locale");
		}
	}
	
}
