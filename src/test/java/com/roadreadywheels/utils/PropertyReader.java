package com.roadreadywheels.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static Properties envProperties = new Properties();
	private static Properties configProperties = new Properties();
	private static Properties dataProperties = new Properties();

	static {

		try {
			InputStream readEnv = PropertyReader.class.getClassLoader().getResourceAsStream("env.properties");
			envProperties.load(readEnv);

			String env = envProperties.getProperty("env");

			InputStream readConfig = PropertyReader.class.getClassLoader()
					.getResourceAsStream(env + "-config.properties");
			configProperties.load(readConfig);

			InputStream readData = PropertyReader.class.getClassLoader()
					.getResourceAsStream(env + "-data.properties");
			dataProperties.load(readData);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getConfigProperty(String key) {
		return configProperties.getProperty(key);
	}

	public static String getDataProperty(String key) {
		return dataProperties.getProperty(key);
	}

}
