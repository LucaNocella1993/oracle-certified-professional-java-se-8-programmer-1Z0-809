package ocp.examples.localization;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Localization extends ListResourceBundle {
	private int count = 0;
	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "count", count++ } };
	}
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("ocp.examples.localization.Localization");
		System.out.println(rb.getObject("count") + " " +
				rb.getObject("count"));
	}
}

/*
 Java supports properties file resource bundles and Java class resource bundles
 	.java Java class
 		resource bundles contain String keys and any type of classes as values
 	.properties 
 		Properties file resource bundles contain String keys and String values
 */