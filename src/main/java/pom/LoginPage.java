package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@CacheLookup
	@FindBy(xpath="//a[text()='Lost your password?']")
	public WebElement LostPassword;
	
	@CacheLookup
	@FindBy(id="username")
	public WebElement Username;
	
	@CacheLookup
	@FindBy(id="password")
	public WebElement Password;
	
	@CacheLookup
	@FindBy(xpath="//button[@name='login']")
	public WebElement LoginButton;
	
	@CacheLookup
	@FindBy(xpath="//nav/ul/li/a[text()='Dashboard']")    ////nav/ul/li/a[text()='Dashboard']
	public WebElement Dashboard;
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void sendUsername(String uname)
	{
		Username.sendKeys(uname);
	}
	public void sendPassword(String pwd)
	{
		Username.sendKeys(pwd);
	}
	public void clickLogin()
	{
		LoginButton.click();
	}
	
	public AccountsPage doLogin(String username,String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		return new AccountsPage(driver);
	}
}
