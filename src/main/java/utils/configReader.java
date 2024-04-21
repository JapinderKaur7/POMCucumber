package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	Properties prop;
	
	public Properties readConfigFile()
	{
		prop= new Properties();
		try {
			FileInputStream ip= new FileInputStream("C:\\Automation\\Workspace\\POMCucumberSeries\\src\\test\\resources\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
