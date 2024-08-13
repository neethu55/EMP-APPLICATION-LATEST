package com.emp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emp.qa.base.TestBase;

public class JobDetailsPage extends TestBase
{

	@FindBy(xpath="//div[@class='col-md-9 removePaddingLeft form-area-container']//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")
	WebElement postMenu;
/*
	@FindBy(id="react-select-2-option-2")
	WebElement post; */
	
	@FindBy(xpath="//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")
	WebElement subjectMenu;
	
	@FindBy(id="react-select-5-option-4")
	WebElement subject;
	
	@FindBy(xpath="//div[4]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")
	WebElement campusMenu;
	
	@FindBy(id="react-select-4-option-5")
	WebElement campus;
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	WebElement SaveJobDetail;
	
	@FindBy(xpath="//button[normalize-space()='Apply Here']")
	WebElement applyBtn;
	
	//Initializing the Page Objects:
	public JobDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	 public boolean verifyLinkPresent() 
	 {
	         try {
	             return applyBtn.isDisplayed();
	             } catch (Exception e) 
	             {
	             return false;
	             }
	 }
	 
	 public void clickOnApplyLink() throws InterruptedException
		{
			Thread.sleep(1000);
			applyBtn.click();
			Thread.sleep(1000);
		}
	
	public void clickOnPostMenu(String post) throws InterruptedException
	{
		Thread.sleep(3000);
		if (postMenu != null && postMenu.isDisplayed() && postMenu.isEnabled()) {
			postMenu.click();
			} else {
			System.out.println("Post Applied For is not clickable or visible.");
			}
		Thread.sleep(3000);
		/*post.click();//selection of post- Teaching*/
		WebElement selected_post=driver.findElement(By.id(post));
		selected_post.click();
		Thread.sleep(3000);
	}
	public void clickOnSubjectMenu() throws InterruptedException{
		Thread.sleep(1000);
		if (subjectMenu != null && subjectMenu.isDisplayed() && subjectMenu.isEnabled()) {
			subjectMenu.click();
			} else {
			System.out.println("Subject/Job category is not clickable or visible.");
			}
		Thread.sleep(1000);
		subject.click();//selection of subject - Botany
		Thread.sleep(1000);
	}
	
	public void clickOnCampusMenu() throws InterruptedException{
		Thread.sleep(1000);
		if (campusMenu != null && campusMenu.isDisplayed() && campusMenu.isEnabled()) {
			campusMenu.click();
			} else {
			System.out.println("Campus Menu is not clickable or visible.");
			}
		Thread.sleep(1000);
		campus.click();///selection of campus - Nodal center
		Thread.sleep(1000);
	}
	
	public PersonalDetailsPage SaveJobDetails() throws InterruptedException{
		SaveJobDetail.click();
		Thread.sleep(3000);
		return new PersonalDetailsPage();
	}
	//page chaining in POM. Clicking on save should return next landing page object

	
	//Reason for launching browser for each test cases - If executing many test cases in same browser without closing, browser will be exhausted causing cache/cookies/mem issues
       
    //ie; test cases should be independent/test cases should be separated -- independent with each other
   	//before each test case -- launch the browser and login
   	//@test -- execute test case
   	//after each test case -- close the browser

}
