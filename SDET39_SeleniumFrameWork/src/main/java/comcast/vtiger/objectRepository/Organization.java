package comcast.vtiger.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
public Organization(WebDriver driver)
{
	PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
private WebElement CreateOrganizationPlusSign;

@FindBy(name="accountname")
private WebElement OrganizationName;

@FindBy(name="button")
private WebElement SaveButton;

public WebElement getCreateOrganizationPlusSign() {
	return CreateOrganizationPlusSign;
}

public WebElement getOrganizationName() {
	return OrganizationName;
}

public WebElement getSaveButton() {
	return SaveButton;
}

//Business Logic

public void CreateOrganizationPlusSign()
{
	CreateOrganizationPlusSign.click();
}
public void OrganizationName(String name)
{
	OrganizationName.sendKeys(name);	
	
}
public void SaveButton()
{
	SaveButton.click();
}
}
