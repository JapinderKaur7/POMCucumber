package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class driverManager {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public WebDriver setup(String browser)
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.getCapability(browser);
		
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{ 
			driver= new ChromeDriver();    //Handled by SeleniumManager, it is the new replacement of Webdriver Manager. Itis part of selenium and is not external dependancy
			//WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}
		else
		{
			System.out.println("This is not a correct browser value" +browser);
			System.exit(0);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	
	public static synchronized WebDriver getDriver() {
		return tl.get();
	}

}
