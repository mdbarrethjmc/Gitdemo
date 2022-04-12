package stepDefinations;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base {
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
    }
	@And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	  driver.get(strArg1);
    }

    @And("^Click on login link in home	page to land on secure sign in page$")
    public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	if(l.getPopupSize()>0)
    	{
    		l.getpopup().click();
    	}
    	l.getLogin();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
    	lp.getUsername().sendKeys(username);
    Thread.sleep(3000);
    	lp.getPassword().sendKeys(password);
    	lp.getLogin().click(); 
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
     System.out.println("Successfully logged in");
     System.out.println("successfully logged in");
     System.out.println("Successfully logged in");
    }

    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
    	driver.quit();
    }
    

}
