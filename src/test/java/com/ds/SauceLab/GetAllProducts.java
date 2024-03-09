package com.ds.SauceLab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObject.SauceLabHomePage;
import junit.framework.Assert;

public class GetAllProducts extends DriverInitilization {

	@Test
	public void GetALLItemText() {
		SauceLabHomePage homePage;
		homePage=loginPage.loginSaucelab("standard_user", "secret_sauce");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		  List<WebElement>
		  ls=driver.findElements(By.cssSelector(".inventory_item_name"));
		  
		  for(WebElement e: ls) {
			  System.out.println(e.getText());
			  
		 }
	      
	}

}
