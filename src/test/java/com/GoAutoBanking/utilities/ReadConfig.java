package com.GoAutoBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("E:\\Learning\\GoAutoBanking\\Configuration\\config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		    }
		catch(Exception e)
		{
			System.out.println("Exception is: "+ e.getMessage());
		}
	}
  
	public String GetapplicationURL()
	{
	String	url=pro.getProperty("BaseURL");
	return url;
	}
	
	public String Getusername()
	{
	String	usrname=pro.getProperty("username");
	return usrname;
	}
	
	public String Getpassword()
	{
	String	passwrd=pro.getProperty("password");
	return passwrd;
	}
	public String Getchromepath()
	{
	String	chrmpath=pro.getProperty("chromepath");
	return chrmpath;
	}
	
	public String Getgeckopath()
	{
	String	gpath=pro.getProperty("geckopath");
	return gpath;
	
	}
	
	public String Getedgepath()
	{
	String	epath=pro.getProperty("edgepath");
	return epath;
	
	}
	
}
