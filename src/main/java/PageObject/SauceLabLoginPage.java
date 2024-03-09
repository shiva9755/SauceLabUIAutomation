package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabLoginPage {
	
	private WebDriver driver;
	private SauceLabHomePage homePage;
	
	@FindBy(css="#user-name")
	private WebElement userName;
	@FindBy(css="#password")
	private WebElement password;
	@FindBy(css="#login-button")
	private WebElement button;
	
	public SauceLabLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void enterUserName(String str) {
		userName.sendKeys(str);
	}
	
	public void enterPassword(String str) {
		password.sendKeys(str);
	}
	
	public void clickButton() {
		button.click();
		
	}
	public SauceLabHomePage loginSaucelab(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickButton();
		homePage=new SauceLabHomePage(driver);
		return homePage;
	}
	
}
