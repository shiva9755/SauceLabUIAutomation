package com.ds.SauceLab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageObject.SauceLabLoginPage;

public class DriverInitilization {
	public WebDriver driver;
	public SauceLabLoginPage loginPage;
	
	
	@BeforeMethod
	@Parameters("browser") 
	public void setup(String str) {
		
		if(str.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			
			
		}else if(str.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}else if(str.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		
		loginPage=new SauceLabLoginPage(driver);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}
