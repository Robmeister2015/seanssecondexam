package localisation;

import java.util.Locale;
import java.util.ResourceBundle;

public class DemoOfStatsBundles {

	static void displayValues(Locale currentLocale){
		
		ResourceBundle stats = ResourceBundle.getBundle("localisation.StatsBundle", currentLocale);
		
		Integer gdp = (Integer) stats.getObject("GDP");
		Integer pop = (Integer) stats.getObject("Population");
		Double lit = (Double) stats.getObject("Literacy");
		
		System.out.println( "Details are : GDP = " + gdp.toString() +
							" Population = " + pop.toString() +
							" Literacy = " + lit.toString());
		
	}
	
	public static void main(String[] args){
		
		/*
		 * en_CA gets from the default (StatsBundle) and the rest get from ones that match the names. Otherwise they would also get from the default
		 * For example, if I were to change one to en ie, it would have the same values as en_CA
		 */
		Locale[] supportedLocales = {
				new Locale("en", "CA"), new Locale("ja", "JP"), new Locale("fr", "FR")
		};
		
		for(int i = 0; i < supportedLocales.length; i ++) {
			System.out.println("Locale = " + supportedLocales[i]);
			displayValues(supportedLocales[i]);
			System.out.println();
		}
		
	}
	
}
