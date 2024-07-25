package com.GoAutoBanking.Testcases;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.GoAutoBanking.utilities.ReadConfig;



import java.time.Duration;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String BaseURL=readconfig.GetapplicationURL();
	public String username=readconfig.Getusername();
	public String password=readconfig.Getpassword();
	public static  WebDriver driver;
	
	public static Logger logger;
	

	@Parameters("Browser")
	@BeforeClass
	public void setup(String br)
	{
	
		  logger=Logger.getLogger("AutoBanking");
		  PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver", readconfig.Getchromepath());
		  driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			 System.setProperty("webdriver.firefox.driver", readconfig.Getgeckopath());
			  driver = new FirefoxDriver();
		}
		
		else if(br.equals("edge"))
		{
			 System.setProperty("webdriver.firefox.driver", readconfig.Getedgepath());
			  driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BaseURL);
		logger.info("URL is opened");
	   
   
	}
	
    @AfterClass
    public void teardown() 
    {
    	driver.quit();
    }
    
    public void CaptureScreen(WebDriver driver, String Tname) throws IOException
    {
    	TakesScreenshot ts= (TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	  File target =new File(System.getProperty("user.dir")+"/ScreenShot/"+"tname"+".png");
    	  FileUtils.copyFile(source, target);
    	  System.out.println("ScreenShotTaken");
    	  
    }
    
    public String Randomstring()
    {
    String	rstring =RandomStringUtils.randomAlphabetic(8);
    return (rstring);
    }
    
    public String Randomnum()
    {
    String	rnum =RandomStringUtils.randomNumeric(4);
    return (rnum);
    }
    
}
