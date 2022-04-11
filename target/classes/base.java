package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class base {
	public Properties prop;
	public WebDriver driver;

	@Test
	public WebDriver initializeDriver() throws IOException {
		//Properties prop = new Properties();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties"));
		
		prop.load(fis);
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			//System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\AZIZ FARHAN\\eclipse-workspace\\Chrome\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",
					(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe"));
			//C:\Users\AZIZ FARHAN\eclipse-workspace\E2Eproject\src\main\java\resources\chromedriver.exe
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firebox")) {

		} else if (browserName.equals("IE")) {
			//
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
		
		public String getScreenshotpath(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			return destinationFile;
		}

	}
	
