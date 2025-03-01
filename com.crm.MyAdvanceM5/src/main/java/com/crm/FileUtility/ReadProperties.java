package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static String getData(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream("./src/test/resources/DwsLogin.properties");
		prop.load(fi);
		String data = prop.getProperty(key);
		return data;
	}
}

