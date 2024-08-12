package com.emp.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emp.qa.base.TestBase;
import com.emp.qa.pages.JobDetailsPage;
import com.emp.qa.pages.LoginPage;
import com.emp.qa.pages.PersonalDetailsPage;

public class JobDetailsPageTest extends TestBase
{
	LoginPage loginPage;
	JobDetailsPage jobPage;
	PersonalDetailsPage personaldetailspage;
	
	public JobDetailsPageTest()
	{
		super();
	}//constructor. properties will be initialized
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization(); //driver will be initialized
		loginPage = new LoginPage();
		Thread.sleep(1000);
		loginPage.signin();
		jobPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		 if (jobPage.verifyLinkPresent()) 
		 {
			 System.out.println("The link is present on the page. User has applied already before");
			 jobPage.clickOnApplyLink();

		 } 

	else  {
	           System.out.println("The link is not present on the page. It is newly registered login");
	       }	 
		 
	}
	
	@Test(priority=1)
	public void clickOnPostMenuTest() throws InterruptedException
	{
		jobPage.clickOnPostMenu();
	}
	
	@Test(priority=2)
	public void clickOnSubjectMenuTest() throws InterruptedException
	{
		jobPage.clickOnPostMenu();
		Thread.sleep(1000);
		jobPage.clickOnSubjectMenu();
	}
	
	@Test(priority=3)
	public void clickOnCampusMenuTest() throws InterruptedException
	{
		jobPage.clickOnCampusMenu();
	}
	
	@Test(priority=4)
	public void SaveJobDetailsTest() throws InterruptedException
	{
		jobPage.clickOnPostMenu();
		Thread.sleep(1000);
		jobPage.clickOnSubjectMenu();
		Thread.sleep(1000);
		jobPage.clickOnCampusMenu();
		Thread.sleep(1000);
		jobPage.SaveJobDetails();
		Thread.sleep(1000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}




