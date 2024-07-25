package com.GoAutoBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
    
	@FindBy(name="uid")
	WebElement Txtunm;
	
	@FindBy(name="password")
	WebElement Txtpwd;
	
	@FindBy(name="btnLogin")
	WebElement Clkbtn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement Lnklogout;
	
	public void SetUserName(String Uname)
	{
		Txtunm.sendKeys(Uname);
	}
	
	public void SetPwd(String pwd)
	{
		Txtpwd.sendKeys(pwd);
	}
	public void ClickLogin()
	{
		Clkbtn.click();
	}
	
	public void ClickLogout()
	{
		Lnklogout.click();
	}
	
}
