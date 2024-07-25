package com.GoAutoBanking.Testcases;



import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.GoAutoBanking.PageObject.LoginPage;

public class TC_loginTest_001 extends BaseClass

{
@Test
 public void LoginCheck() throws IOException
 {
	
		
		LoginPage lp=new LoginPage(driver);
		
		lp.SetUserName(username);
		logger.info("UN is entered");
		
		lp.SetPwd(password);
		logger.info("PWD is entered");
		
		lp.ClickLogin();
		
		System.out.println("Title: "+ driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			CaptureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
		
	 }
	
}
