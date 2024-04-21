package stepDef;

import org.junit.Assert;

import driverManager.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;


public class LoginSteps {
	
	private static String actualTitle;
	private LoginPage loginPage= new LoginPage(driverManager.getDriver());
	

@Given("user is on login page")
public void user_is_on_login_page() {
    driverManager.getDriver().get("https://shop.demoqa.com/my-account/");
}

@When("user gets the title of the page")
public void user_gets_the_title_of_the_page() {
	actualTitle = loginPage.getTitle();
	System.out.println("The title of the page is " +actualTitle);
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedTitle) {
    Assert.assertTrue(actualTitle.contains(expectedTitle));

}

@Then("forgot password link should be displayed")
public void forgot_password_link_should_be_displayed() {
	Assert.assertTrue(loginPage.LostPassword.isDisplayed());
}

@When("user enters username {string}")
public void user_enters_username(String uname) {
    loginPage.sendUsername(uname);
}

@And("user enters password {string}")
public void user_enters_password(String pwd) {
    loginPage.sendPassword(pwd);
}

@And("user clicks on Login button")
public void user_clicks_on_login_button() {
    loginPage.clickLogin();
}

@Then("user gets sees Dashboard link")
public void user_gets_sees_dashboard_link() {
    Assert.assertTrue(loginPage.Dashboard.isDisplayed());
}


}
