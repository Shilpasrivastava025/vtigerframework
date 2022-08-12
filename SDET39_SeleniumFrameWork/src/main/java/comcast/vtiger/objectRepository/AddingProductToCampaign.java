package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingProductToCampaign {
	public AddingProductToCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement plusProduct;
	
	@FindBy(name="search_text")
	private WebElement searchProductName;
	
	@FindBy(name="search")
	private WebElement ProductName;

	
	
	public WebElement getPlusProduct() {
		return plusProduct;
	}

	public WebElement getSearchProductName() {
		return searchProductName;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	//business Logic
	public void AddingProductToCampaign()
	{
		plusProduct.click();
	}
	
	public void SearchProductName(String name)
	{
		searchProductName.sendKeys(name);
	}
	public void ProductName()
	{
		ProductName.click();
	}
}
