package localisation;

import java.text.NumberFormat;
import java.util.Locale;

public class LanguagesCountriesVariants {

	public static void main(String[] args){
		
		String outputString = new String();
		
		Locale[] thaiLocale = {
				//This uses only language
				new Locale("th"),
				
				//This uses both language and country
				new Locale("th", "TH"),
				
				//This however, is a variant so it uses actual Thai characters
				//Which my machine doesn't support
				new Locale("th", "TH", "TH")
		};
		
		for(Locale locale : thaiLocale){
			NumberFormat nf = NumberFormat.getNumberInstance(locale);
			outputString = outputString + locale.toString() + ": ";
			outputString = outputString + nf.format(573.34) + "\n";
			System.out.println(outputString);
		}
	}
	
}
