package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPageValidation {
	public void CampaignPageValidation(WebDriver driver)
	{
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement addcampaigndata;

	public WebElement getAddcampaigndata() {
		return addcampaigndata;
	}
	
	public String actualCampaignName()
	{
		return addcampaigndata.getText();
	}

}
