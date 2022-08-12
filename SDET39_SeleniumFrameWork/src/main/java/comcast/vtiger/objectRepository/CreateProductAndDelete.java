package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductAndDelete {
	public CreateProductAndDelete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//initialization
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement PlusIcon;
	
	@FindBy(name="productname")
	private WebElement productnameField;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	@FindBy(name="Delete")
	private WebElement Del;

	
	//Getters
	public WebElement getPlusIcon() {
		return PlusIcon;
	}

	public WebElement getProductnameField() {
		return productnameField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDel() {
		return Del;
	}
	
	
	
	// Business Script
	/* used for Creating new Product
	 * @author Shilpa
	 */
	public void PlusProduct()
	{
		PlusIcon.click();
	}
	public void ProductnameField (String name) 
	{
			productnameField.sendKeys(name);
	}
	public void SaveProduct() {
		
			saveButton.click();
	}
	public void deleteProduct()
	{
		Del.click();
	}
	
}
