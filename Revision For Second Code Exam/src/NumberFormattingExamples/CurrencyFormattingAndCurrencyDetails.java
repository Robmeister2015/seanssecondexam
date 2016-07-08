package NumberFormattingExamples;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormattingAndCurrencyDetails {

	public static void main(String[] args){
		
		long tenMillion = 10_000_000L;
		Locale[] locales = { Locale.CANADA, Locale.FRANCE, Locale.GERMANY, Locale.TAIWAN };
		
		/*
		 * Formats 10 million in the given locales
		 */
		for(Locale locale : locales) {
			System.out.println("Ten million in " + locale.getDisplayName() + " is " + NumberFormat.getCurrencyInstance(locale).format(tenMillion));
		}
		
		/*
		 * Getting currency details
		 */
		Locale locale = Locale.UK;
		Currency currencyInstance = Currency.getInstance(locale);
		System.out.println("The currency code for locale " + locale
				+ " is: " + currencyInstance.getCurrencyCode() +
				" \nThe currency symbol is " + currencyInstance.getSymbol()
				+ " \nThe currency name is " + currencyInstance.getDisplayName());
	}	
}
