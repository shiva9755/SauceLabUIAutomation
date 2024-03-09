package com.ds.SauceLab;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.SauceLabHomePage;
import junit.framework.Assert;


public class AppTest extends DriverInitilization{
	private SauceLabHomePage homePage;
	
	@Test(dataProvider="data")
	public void loginSauceLab(String str,String str1) {
		
		homePage=loginPage.loginSaucelab(str, str1);
		Assert.assertEquals(driver.getTitle(),"Swag Labs" );
		System.out.println("This is the 1st test");
		
	}
	@Test
	public void AddProductToCart() {
		
		homePage=loginPage.loginSaucelab("standard_user", "secret_sauce");
		Assert.assertEquals(driver.getTitle(),"Swag Labs" );
		System.out.println("This is the 2st test");
		homePage.clickOnElementLink();
		homePage.clickOnAddToCartButton();
		homePage.checkCartItem();
		
	}
	@Test
	public void filterOptionValidation() {
		
		homePage=loginPage.loginSaucelab("standard_user", "secret_sauce");
		
		List<WebElement> ls=homePage.getFilterOptions();
		List<String> ls1;
		ls1=ls.stream().map(m->m.getText()).collect(Collectors.toList());
		
		for(int i=0;i<=ls1.size()-1;i++) {
			
			homePage.selectByIndex(i);
			List<String> list1;
			List<String> list2;
			List<String> list3;
			List<String> list4;
			
			switch(homePage.getFilterOptions().get(i).getText()) {
			
			case "Name (A to Z)":
				list1=homePage.getListOfProductsName();
				System.out.println(list1);
				break;
			case "Name (Z to A)":
				list2=homePage.getListOfProductsName();
				System.out.println(list2);
				break;
			case "Price (low to high)":
				list3=homePage.getListOfPriceValues();
				System.out.println(list3);
			    break;
			case "Price (high to low)":
				list4=homePage.getListOfPriceValues();
				System.out.println(list4);
				break;
				
			}
		}
			
	}
		
	@DataProvider(name="data")
	public Object[][] testData(){
		return new Object[][]{ 
				
				  {"standard_user","secret_sauce"} 
				/*
				 * {"locked_out_user","secret_sauce"}, {"problem_user","secret_sauce"},
				 * {"performance_glitch_user","secret_sauce"}, {"error_user","secret_sauce"},
				 * 
				 * {"visual_user","secret_sauce"}
				 */
				 
		};
				
	}
}
