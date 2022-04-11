package Academy;

import java.io.IOException;


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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class validateTitle extends base {
	LandingPage l;
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
			driver=initializeDriver();
			log.info("Driver is initialized");
			driver.get(prop.getProperty("url"));
			log.info("Navigate to homepage");
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
	}
@Test
public void pageNavigation() throws IOException
	{
	//LandingPage l = new LandingPage(driver);
	l=new LandingPage(driver);
	l.getTitle().getText();
	Assert.assertEquals(l.getTitle().getText(),"FEATURED 2COURSES");
	log.info("Successfully validated text message");
	}
@Test
public void validateHeader() throws IOException
{
Assert.assertEquals(l.getheaderTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
System.out.println(l.getheaderTitle().getText());
}
@AfterTest
public void teardown()
{
	driver.close();
}
}
	