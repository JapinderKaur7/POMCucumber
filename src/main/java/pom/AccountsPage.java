package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@CacheLookup
	@FindBy(css = "div.entry-content nav a")
	public List<WebElement> section;
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public int getAccountsSections()
	{
		return section.size();
	}
	
	public List<String> AccountsSectionList()
	{
		List<String> list= new ArrayList<String>();
		for(WebElement e: section)
		{
			String text= e.getText();
			System.out.println(text);
			list.add(text);
		}
		return list;
	}

}
