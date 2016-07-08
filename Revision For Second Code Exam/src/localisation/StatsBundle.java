package localisation;

import java.util.ListResourceBundle;

public class StatsBundle extends ListResourceBundle{

	/*
	 * Must implement getContents
	 * Is used as the default locale if the requested one isn't found
	 */
	@Override
	protected Object[][] getContents() {
		
		return contents;
		
	}
	
	/*
	 * This information is loaded if the requested Locale is not available
	 */
	private Object[][] contents = {
			{ "GDP", new Integer(24400) },
			{ "Population", new Integer(28802671) },
			{ "Literacy", new Double(0.97) }
	};

}
