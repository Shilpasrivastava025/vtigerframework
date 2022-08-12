package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductToCampaign {
	
	public void CampaignToProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	//Declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement PlusIcon;
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	@FindBy(name="button")
	private WebElement SaveButton;
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement ForCampaign;
	
	@FindBy(name="campaignname")
	private WebElement CampaignName;
	
	@FindBy(name="button")
	private WebElement CampaignSaveButton;
	
	//getters

	public WebElement getPlusIcon() {
		return PlusIcon;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}

	public WebElement getCampaignSaveButton() {
		return CampaignSaveButton;
	}
	public WebElement getForCampaign() {
		return ForCampaign;
	}
	
	//Business Login
	/*
	 * @author Shilpa
	 */
	public void createProductWithCampaign(String name, String Campaign)
	{
		
		ProductName.sendKeys(name);
		SaveButton.click();
		ForCampaign.click();
		CampaignSaveButton.click();
	}
	public void clickPlus()
	{
		PlusIcon.click();
	}

	public void createProductWithCampaign(String productName) {
		CampaignName.sendKeys(productName);
		
	}
	
}
	

