package localisation;

import java.util.*;

public class PropertyResourceBundleTest {

	public static void main(String[] args) {

		/*
		 * Gets the default properties file (ResourceBundle.properties)
		 */
		ResourceBundle resBundle = ResourceBundle.getBundle(
				"localisation.ResourceBundle", Locale.getDefault());
		System.out.printf(resBundle.getString("Greeting"));
		System.out.println();

		/*
		 * Gets the properties file ending in fr (ResourceBundle_fr.properties)
		 */
		ResourceBundle resBundleFrCA = ResourceBundle.getBundle(
				"localisation.ResourceBundle", new Locale("fr"));
		System.out.printf(resBundleFrCA.getString("Greeting"));
		System.out.println();

		/*
		 * Gets the properties file ending in it (ResourceBundle_it.properties)
		 */
		ResourceBundle resBundleItIT = ResourceBundle.getBundle(
				"localisation.ResourceBundle", new Locale("it"));
		System.out.printf(resBundleItIT.getString("Greeting"));
		System.out.println();

	}
}
