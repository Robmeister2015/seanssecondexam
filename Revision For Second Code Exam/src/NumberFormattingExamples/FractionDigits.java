package NumberFormattingExamples;

import java.text.NumberFormat;
import java.text.ParseException;

public class FractionDigits {

	public static void main(String[] args) throws ParseException{
		
		String[] numbers = {"1.228", "0.12745F"};
		double[] doubles = {1.228, 0.12745F};
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		System.out.println("Using format method: ");
		
		/*
		 * This will round up on the third digit if necessary
		 */
		for(double val : doubles) {
			System.out.println(numberFormat.format(val));
		}
		
		System.out.println("Using parse method: ");
		
		/*
		 * This prints the whole number parsed from the String
		 */
		for(String number : numbers) {
			System.out.println(numberFormat.parse(number));
		}
		
	}
	
}
