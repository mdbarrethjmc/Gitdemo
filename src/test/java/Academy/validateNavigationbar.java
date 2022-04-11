package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateNavigationbar extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
public void initialize() throws IOException
{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
}
@Test
public void pageNavigation() throws IOException
	{
	LandingPage l = new LandingPage(driver);
	Assert.assertTrue(l.getNavbar().isDisplayed());
	log.info("Navigation bar is displayed");
	}
@AfterTest
public void teardown()
{
	driver.close();
}
}
	