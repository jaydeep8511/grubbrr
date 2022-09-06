package com.grubbrr.init;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertiesFile {

	public static Properties prop;

	public PropertiesFile(String filepath1) throws Exception {

		FileReader reader = new FileReader(filepath1);
		prop = new Properties();
		prop.load(reader);
	}

	public String getValue(String propValue) throws IOException {

		return prop.getProperty(propValue);
	}
	
	public String signUp() throws IOException {

		return prop.getProperty("signup");
	}	
}
