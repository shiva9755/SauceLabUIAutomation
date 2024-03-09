package PageObject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SauceLabHomePage {
	
private WebDriver driver;
	
	@FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
	private WebElement elementLink;
	@FindBy(css=".inventory_details_desc_container button")
	private WebElement addToCartButton;
	@FindBy(css=".shopping_cart_link")
	private WebElement goToCartIcon;
	@FindBy(css=".active_option")
	private WebElement filterActiveOption;
	@FindBy(css=".product_sort_container")
	private WebElement filterDropdownValues;
	@FindBy(css=".inventory_item_price")
	private List<WebElement> PriceListOfAllProduct;
	@FindBy(css=".inventory_item_name")
	private List<WebElement> nameOfAllProducts;
	
	public SauceLabHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnElementLink() {
		elementLink.click();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public void checkCartItem() {
		goToCartIcon.click();
	}
	
	public List<WebElement> getFilterOptions() {
		Select select=new Select(filterDropdownValues);
		
		return select.getOptions();	
	}
	
	public void selectByVisibleText(String str) {
		Select select=new Select(filterDropdownValues);
		
		select.selectByVisibleText(str);
	}
	
	public void selectByIndex(int i) {
		Select select=new Select(filterDropdownValues);
		
		select.selectByIndex(i);
	}
	
	public void selectByValue(String str) {
		Select select=new Select(filterDropdownValues);
		
		select.selectByValue(str);
	}
	
	public List<String> getListOfPriceValues(){
		List<String> ls=PriceListOfAllProduct.stream().map(m->m.getText()).collect(Collectors.toList());
		return ls;
	}
	
	public List<String> getListOfProductsName(){
		
			List<String> ls=nameOfAllProducts.stream().map(m->m.getText()).collect(Collectors.toList());
			return ls;
		
	}

}
