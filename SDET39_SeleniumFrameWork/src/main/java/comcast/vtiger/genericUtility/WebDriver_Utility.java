package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {

	/**
	 * Wait for page to load before identifying any synchronized element
	 * @param driver
	 * @author Shilpa
	 */
	public void waitForPageToLoad(WebDriver driver)
	 {
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }

	
	/**
	 * After every action it will wait for perform next action 
	 * @param driver
	 * @author Shilpa
	 */
	public void scriptTimeOut(WebDriver driver)
	 {
	    driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	 }
	
	
	/**
	 * To wait for element to be Clickable in GUI and check for the Expected Condition in every 
	 * 500milisections
	 * @param driver
	 * @param element
	 * @author Shilpa
	 */
	public void explicitWaitClick(WebDriver driver, WebElement element )
	{
		
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	/**
	 * To wait for element to be Clickable in GUI and check for specific element for every 
	 * 500miliseconds
	 * @author Shilpa
	 */
	public void waitWithCustomTimeOut(WebDriver driver , WebElement element, int pollingTime)
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	
	
	/**
	 * To switch to Any Window based on window Title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author shilpa
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle)
	{
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it= child.iterator();
		while(it.hasNext())
		{
			String child_window=it.next();
			driver.switchTo().window(child_window);
			if(driver.getTitle().contains("Campaigns&action"))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param PartialWindow
	 */
	
	public void switchToBackWindow(WebDriver driver, String PartialWindow)
	{
		Set<String> child = driver.getWindowHandles();
   		Iterator<String> it=child.iterator();
   		while(it.hasNext())
   		{
   			String window = it.next();
   			driver.switchTo().window(window);
   			if(driver.getTitle().contains("Campaigns&action"));
   			{
   				break;
   			}
   		}
	}
	
	/**
	 * To switch to Alert and Accept
	 * @param driver
	 * @author Shilpa
	 */
	public void acceptTheAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 *  To switch to Alert and Dismiss
	 * @param driver
	 * @author Shilpa
	 */
	public void dismissTheAlert(WebDriver driver)
	{
	 driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * To Move to specific Element
	 * @param driver
	 * @param element
	 * @author Shilpa
	 */ 
	public void mouseHover(WebDriver driver, WebElement element) 
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	
	/**
	 * To double Click the Specific Element
	 * @param driver
	 * @param element
	 * @author Shilpa
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions a= new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * To Perform DragandDrop the specific element to another location
	 * @param driver
	 * @param source
	 * @param target
	 * @author Shilpa
	 */
	public void dragAndDrop(WebDriver driver , WebElement source , WebElement target)
	{
		Actions a = new Actions(driver);
	    a.dragAndDrop(source, target).perform();
	}
	
	
	/**
	 * To Switch the Frame window based on Index
	 * @param driver
	 * @author Shilpa
	 */
	public void switchToFrame(WebDriver driver, int index )
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * Used to switch to frame based on id Or frame
	 * @param driver
	 * @param element
	 * @author Shilpa
	 */
	
	public void switchToFrame( WebDriver driver, WebElement id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * To select by index value
	 * @param element
	 * @param text
	 * @author Shilpa
	 */
	public void selectByIndex(WebElement element, int index)
	{
		Select s=  new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * To select By Visible Text
	 * @param element
	 * @param text
	 * @author Shilpa
	 */
	public void selectByVisibleText(WebElement element, String text)
	{
		Select s=  new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specific element 
	 * @param  driver
	 * @author Shilpa
	 * 
	 */
	public void mouseOverOnElement(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	  /**
      *@param Driver
	  *@param element
	  *@author Shilpa
	  */
	
	public void mouseOverOnElement(WebDriver driver ,WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element).perform();
	}
}
