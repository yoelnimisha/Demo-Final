package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider()
	{
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config file"+e.getMessage());
		}
	}

	public String getDataFromConfig(String key)
	{
		return pro.getProperty(key);
	}

	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}

	public String getUrl()
	{
		return pro.getProperty("url");
	}

}
