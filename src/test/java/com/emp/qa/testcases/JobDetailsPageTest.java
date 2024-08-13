package com.emp.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.emp.qa.base.TestBase;
import com.emp.qa.pages.JobDetailsPage;
import com.emp.qa.pages.LoginPage;
import com.emp.qa.pages.PersonalDetailsPage;
import com.emp.qa.util.TestUtil;

public class JobDetailsPageTest extends TestBase
{
	LoginPage loginPage;
	JobDetailsPage jobPage;
	PersonalDetailsPage personaldetailspage;
	String sheetName = "postmenu";


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
	
	@DataProvider
	public Object[][] getCareersTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	//Data driven approach
	@Test(priority=1, dataProvider="getCareersTestData")
	public void clickOnMenuTest(String post) throws InterruptedException
	{
		jobPage.clickOnPostMenu(post);
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




