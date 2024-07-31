package com.emp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emp.qa.base.TestBase;

public class JobDetailsPage extends TestBase
{

	@FindBy(xpath="//div[@class='col-md-9 removePaddingLeft form-area-container']//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]")
	WebElement postMenu;
	
	@FindBy(id="react-select-2-option-2")
	WebElement post; 
	
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
	
	//Initializing the Page Objects:
	public JobDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPostMenu() throws InterruptedException{
		postMenu.click();
		Thread.sleep(1000);
		post.click();//selection of post- Teaching
	}
	
	public void clickOnSubjectMenu() throws InterruptedException{
		subjectMenu.click();
		Thread.sleep(1000);
		subject.click();//selection of subject - Botany
	}
	
	public void clickOnCampusMenu() throws InterruptedException{
		campusMenu.click();
		Thread.sleep(1000);
		campus.click();//selection of campus - Nodal center
	}
	
	public PersonalDetailsPage SaveJobDetails(){
		SaveJobDetail.click();
		return new PersonalDetailsPage();
	}
	
	
}
