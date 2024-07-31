package com.emp.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emp.qa.base.TestBase;

public class LoginPage extends TestBase
{

	//Page Factory - OR:
		@FindBy(xpath="//input[@placeholder='Email Address']")
		WebElement username;
		
		@FindBy(xpath="//input[@id='loginPassword']")
		WebElement password;
		
		@FindBy(xpath="//button[normalize-space()='Continue']")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[@name='signIn']")
		WebElement signInBtn;
	
		//Initializing the Page Objects:
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		//This is pointing to the current class objs
		//Actions:
		public void signin() throws InterruptedException
		    {
			Thread.sleep(1000);
			signInBtn.click();
			Thread.sleep(1000);
			}
		
		public JobDetailsPage login(String un, String pwd) throws InterruptedException{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			    	//JavascriptExecutor js = (JavascriptExecutor)driver;
			    	//js.executeScript("arguments[0].click();", loginBtn);
			Thread.sleep(1000);
			return new JobDetailsPage();
		}
}
