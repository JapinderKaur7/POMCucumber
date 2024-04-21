package stepDef;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverManager.driverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.AccountsPage;
import pom.LoginPage;

public class AccountsPageSteps {
	
	private LoginPage login=new LoginPage(driverManager.getDriver());
	private AccountsPage accountsPage;
	
	@Given("User is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable dataTable) {
	    List<Map<String,String>> cred=dataTable.asMaps();
	    
	    String uname=cred.get(0).get("username");
	    String pwd=cred.get(0).get("password");
	    
	    driverManager.getDriver().get("https://shop.demoqa.com/my-account/");
	    accountsPage= login.doLogin(uname, pwd);
	}

	@Given("User is on the Accounts Page")
	public void user_is_on_the_accounts_page() {
		accountsPage.getAccountsPageTitle();
		
	    
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable expectedList) {
		List<String> expectedAccountsList= expectedList.asList();
		System.out.println("Expected Accounts List " +expectedAccountsList);
		List<String> actualList= accountsPage.AccountsSectionList();
		System.out.println("Actual Accounts List " +actualList);
		
		Assert.assertTrue(expectedAccountsList.containsAll(actualList));
	    
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer actualCount) {
	   Assert.assertTrue(accountsPage.getAccountsSections()==actualCount);
	}


}
