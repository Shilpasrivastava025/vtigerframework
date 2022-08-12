package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	//Declaration
		@FindBy(linkText="Organizations")
		private WebElement OrganizationsButtonLink;
		
		@FindBy(linkText="Products")
		private WebElement ProductsButtonLink;
		
		@FindBy(linkText="More")
		private WebElement MoreButtonLink;
		
		@FindBy(linkText="Campaigns")
		private WebElement CampaignsButtonLink;
		
		@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
		private WebElement SignOutIcon;
		
		@FindBy(xpath="//a[@href=\"index.php?module=Users&action=Logout\"]")
		private WebElement SignOutButton;
		
		
		//Getter Methods
		public WebElement getOrganizationsButtonLink() {
			return OrganizationsButtonLink;
		}

		public WebElement getProductsButtonLink() {
			return ProductsButtonLink;
		}

		public WebElement getMoreButtonLink() {
			return MoreButtonLink;
		}

		public WebElement getCampaignsButtonLink() {
			return CampaignsButtonLink;
		}
		
		public WebElement getSignOutButton() {
			return SignOutButton;
		}

		//Business Logics
		/**
		 * Used to Perform all tasks in specific Module
		 * @author Shilpa
		 */
		
		public void clickOrganizationLink()
		{
			OrganizationsButtonLink.click();
		}
		
		public void clickProductsLink()
		{
			ProductsButtonLink.click();
		}
		
		public void clickMore()
		{
			MoreButtonLink.click();
		}
		
		public void clickCampaignsLink()
		{
			CampaignsButtonLink.click();
		}
		
		public void SignOutIconLink()
		{
			SignOutIcon.click();
		}
		
		public void SignOutButton(WebDriver driver)
		{
			
			Actions action= new Actions(driver);
			action.moveToElement(SignOutIcon).click().perform();
			SignOutIcon.click();
			
		}
		
		
}
