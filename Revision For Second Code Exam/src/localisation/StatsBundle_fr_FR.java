package localisation;

import java.util.ListResourceBundle;

public class StatsBundle_fr_FR extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		
		return contents;
		
	}
	
	public Object[][] contents = {
		
			{ "GDP", new Integer(20200) },
			{ "Population", new Integer(58317450) },
			{ "Literacy", new Double(0.99) }
			
	};

}
