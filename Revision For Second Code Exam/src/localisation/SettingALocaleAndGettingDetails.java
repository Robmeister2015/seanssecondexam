package localisation;

import java.util.Locale;

public class SettingALocaleAndGettingDetails {

	public static void main(String[] args){
		
		/*
		 * Set the default locale
		 */
	Locale.setDefault(Locale.CANADA_FRENCH);
	Locale defaultLocale = Locale.getDefault();
	System.out.printf("The default locale is %s %n", defaultLocale);
	
	/*
	 * Display language and display language
	 */
	System.out.printf("The default language code is %s and the name is %s %n",
			defaultLocale.getLanguage(), defaultLocale.getDisplayLanguage());
	
	/*
	 * Display default country
	 */
	System.out.printf("The default country code is %s and the name is %s %n", 
			defaultLocale.getCountry(), defaultLocale.getDisplayCountry());
	
	/*
	 * Display default variant
	 */
	System.out.printf("The default variant code is %s and the name is %s %n", defaultLocale.getVariant(), defaultLocale.getDisplayVariant());
	System.out.println("Because the locale is fr_CA, there is no variant");
	}
}
