package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Homepage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
			driver=initializeDriver();
			driver.get(prop.getProperty("url"));
			driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
	}
@Test(dataProvider="getData")
public void pageNavigation(String userName, String passWord, String text) throws IOException, InterruptedException
	{
	driver.get(prop.getProperty("url"));
	LandingPage l = new LandingPage(driver);
	LoginPage lp = l.getLogin();
//	l.getLogin().click();
	
	//Thread.sleep(2000);
	//LoginPage lp = new LoginPage(driver);
	lp.getUsername().sendKeys(userName);
	lp.getPassword().sendKeys(passWord);
	System.out.println(text);
	log.info("successfully validate text message");
	lp.getLogin().click(); 
	 ForgotPassword fp=lp.getForgotPassword();
	 fp.getEmail().sendKeys("mdbareeth");
	 fp.getSendmeInstructions().click();
	
	}
@AfterTest
public void teardown()
{
	driver.close();
}
@DataProvider
public Object[][] getData()
{
	Object[][] data = new Object[2][3];
	data[0][0] = "mohamed@cognizant.com";
	data[0][1] = "12345";
	data[0][2] = "first array";
	
	data[1][0] = "Barreth@cognizant.com";
    data[1][1] = "54321";
	data[1][2] = "second array";
	return data;
	
	
}

}
