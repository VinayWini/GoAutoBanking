package com.GoAutoBanking.Testcases;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.GoAutoBanking.PageObject.LoginPage;
import com.GoAutoBanking.utilities.ExtentManager;
import com.GoAutoBanking.utilities.XLUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class TC_LoginDDT_002 extends BaseClass

{
	public String username="";
	public String password="";
	public String usern="";
	public String passw="";
	XLUtils u= new XLUtils();
	  ExtentTest test = ExtentManager.getExtentTest();

	  @Test(dataProvider = "loginDataProvider")
	public void LoginDDT(String username,String password) throws InterruptedException, IOException
	{
		 
	
		 if (test != null) {
	            test.log(Status.INFO, "Executing testMethod1");
	        }
			LoginPage lp= new LoginPage(driver);
			lp.SetUserName(username);
			//logger.info("User Name provided");
			lp.SetPwd(password);
			//logger.info("PWD provided");
			lp.ClickLogin();
			
			Thread.sleep(1000);
	
	
	if(IsAlertPresent()==true)
	{
		
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login Failed");
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login passed");
		lp.ClickLogout();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	}
	  
	
	public boolean IsAlertPresent()
	{  
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() throws InvalidFormatException, IOException
	{
		String path= "E:\\Learning\\GoAutoBanking\\src\\test\\java\\com\\GoAutoBanking\\TestData\\LoginData.xls";
		String username =u.getData(path,"Sheet1", "username",1 );
		System.out.println(username);
		String password =u.getData(path,"Sheet1", "password",1 );
		System.out.println(password); 
		
		String usern =u.getData(path,"Sheet1", "username",2 );
		System.out.println(username);
		String passw =u.getData(path,"Sheet1", "password",2 );
		System.out.println(password); 
      
		return new Object[][] 
        		{
            {username, password},
            {usern, passw},
                };
    }
	

	
	
}
