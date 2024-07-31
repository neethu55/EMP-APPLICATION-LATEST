package com.emp.qa.testcases;

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
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	
	}
	
	
	@Test(priority=1)
	public void clickOnPostMenuTest() throws InterruptedException
	{
		jobPage.clickOnPostMenu();
	}
	
	@Test(priority=2)
	public void clickOnSubjectMenuTest() throws InterruptedException
	{
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
		jobPage.SaveJobDetails();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}




