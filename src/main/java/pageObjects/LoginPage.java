package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By login = By.cssSelector("input[value='Log In']");
	By forgotpassword = By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public ForgotPassword getForgotPassword()
	{
		
		driver.findElement(forgotpassword).click();
	return new ForgotPassword(driver);
	
	}
	
}
