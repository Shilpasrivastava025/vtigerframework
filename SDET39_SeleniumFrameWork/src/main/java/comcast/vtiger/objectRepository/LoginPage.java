package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { 
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
		
	@FindBy(name="user_password")
	private WebElement userpasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//Getter Methods
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getUserpasswordTextField() {
		return userpasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Logics
	
	
	public void login(String userName , String Password)
	{
		userNameTextField.sendKeys(userName);
		userpasswordTextField.sendKeys(Password);
		loginButton.click();
	}
}
