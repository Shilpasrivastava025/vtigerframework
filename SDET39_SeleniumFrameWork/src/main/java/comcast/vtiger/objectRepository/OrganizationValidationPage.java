package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidationPage {
	public OrganizationValidationPage( WebDriver driver)
	{
			PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement actualCampainData;
		
		public WebElement getActualCampainData() {
			return actualCampainData;
		}
		
		public String actualCampaignName()
		{
		return actualCampainData.getText();	
		}
		
}
