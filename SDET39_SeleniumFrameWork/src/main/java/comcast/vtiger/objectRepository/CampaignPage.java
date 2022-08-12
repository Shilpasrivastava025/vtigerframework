package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement PlusIcon;
	
	@FindBy(name="campaignname")
	private WebElement CampaignName;
	
	@FindBy(name="button")
	private WebElement Savebutton;

	public WebElement getPlusIcon() {
		return PlusIcon;
	}


	
	// Business Logic
	
	public WebElement getCampaignName() {
		return CampaignName;
	}



	public WebElement getSavebutton() {
		return Savebutton;
	}



	public void PlusIcon()
	{
		PlusIcon.click();
	}
	public void CampaignNameTextField()
	{
		CampaignName.click();
	}
	public void CampaignName(String name)
	{
		CampaignName.sendKeys(name);
	}
	public void CampaignSaveButton()
	{
		
		Savebutton.click();
	}
}
