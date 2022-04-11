package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector("div[class='text-center'] h2");
	private By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By headerTitle =By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage getLogin()
	{
		driver.findElement(signin).click();
		LoginPage lp=new LoginPage(driver);
		//return driver.findElement(signin);
		return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavbar()
	{
		return driver.findElement(navBar);
	}
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getpopup()
	{
		return driver.findElement(popup);
	}
	public WebElement getheaderTitle()
	{
		return driver.findElement(headerTitle);
	}
}
