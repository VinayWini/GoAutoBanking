package com.GoAutoBanking.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.GoAutoBanking.PageObject.AddCustomerPage;
import com.GoAutoBanking.PageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass

{
    @Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(username);
		lp.SetPwd(password);
		lp.ClickLogin();
		
		Thread.sleep(2000);
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.ClickAddCustomer();
		
		addCust.CustomerTBox("Vinay");
		addCust.SelectGender("male");
		addCust.SelectCustDOB("10","15","1995");
		Thread.sleep(2000);
		addCust.CustAddrss("INDIA");
		addCust.SelectCity("BENGALURU");
		addCust.SelectState("KARNATAKA");
		addCust.SelectPincode("5700101");
		addCust.SelectMobiNo("9123961946");
		addCust.CustMailid(BaseURL);
		String emaill=Randomstring()+"@gmail.com";
		addCust.CustMailid(emaill);
		addCust.CustPassword("abcdef");
		
		addCust.ClickSubmitBtn();
		Thread.sleep(2000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			CaptureScreen(driver,"AddNewCustomer");
			Assert.assertTrue(false);
		}
	}
    
    
	
}
