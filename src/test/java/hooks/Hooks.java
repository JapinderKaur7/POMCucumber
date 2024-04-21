package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverManager.driverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class Hooks {
	
	private driverManager drivermanager;
	private configReader configreader;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		configreader= new configReader();
		prop= configreader.readConfigFile();
	}
	@Before(order=1)
	public void launchBrowser()
	{
		//String browser= prop.getProperty("browser");
		drivermanager= new driverManager();
		drivermanager.setup("chrome");
		driver= driverManager.getDriver();
		
	}
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	@After(order=1)
	public void TakeScreenshot(Scenario sc)
	{
		if(sc.isFailed()) {
		String Name= sc.getName().replaceAll(" ", "_");
		byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourcepath, "image/png", Name);}
		
	}

}
