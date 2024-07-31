package com.emp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.emp.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	//global variables
	public static WebDriver driver;
	public static Properties prop;
	
	//constructor which is public
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			//Reading the properties
			FileInputStream ip = new FileInputStream("E:\\1WORKSPACE\\pjtname\\src\\main\\java\\com\\emp\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization() throws InterruptedException
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
	}
	
	
}
