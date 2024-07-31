package com.emp.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emp.qa.base.TestBase;
import com.emp.qa.pages.JobDetailsPage;
import com.emp.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	//Defining in class level so that throughout pgm we can use
	LoginPage loginPage;
	JobDetailsPage jobPage;
	
	//constructor calls super class(tstbase) constructor. For initializing properties also
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		//Object of login page for accessing all the methods of Login page
		loginPage = new LoginPage();	/* LoginPage loginPage = new LoginPage(); */
	}
	
	@Test(priority=1)
	public void signinTest() throws InterruptedException
	{
      loginPage.signin();
	}

	
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		loginPage.signin();
		jobPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//storing in home page reference
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
