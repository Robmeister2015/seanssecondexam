package localisation;

import java.util.Locale;

public class GettingAvailableLocales {

	public static void main(String[] args){
		/*
		 * Getting the default locale
		 */
		System.out.println("The default locale is: " + Locale.getDefault());
		/*
		 * Seeing all available locales
		 */
		Locale[] locales = Locale.getAvailableLocales();
		System.out.printf("No. of other available locales is: %d, and they are: %n", locales.length);
		
		for(Locale locale : locales) {
			System.out.printf("Locale code: %s and it stands for %s %n", locale, locale.getDisplayName());
		}
		
		/*
		 * Getting the display name
		 */
		
		for(Locale locale : locales) {
			if(locale.getLanguage().equals("ga")){
				System.out.printf("Locale code: %s and it stands for %s %n", locale, locale.getDisplayName());
			}
		}
	}
}
