package com.crm.sdet.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.AddingProductToCampaign;
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.CreateProductAndDelete;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
import comcast.vtiger.objectRepository.ProductToCampaign;

@Test

public class CreateCampaignWithProductTest extends BaseClass {
@Test(groups="SmokeTest")
	public void CampaignWithProduct() throws Throwable{
	
		System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver.exe");
			
		WebDriver_Utility wbUlitity= new WebDriver_Utility();
		Java_Utility Jutility= new Java_Utility();
		File_Utility FUtility= new File_Utility();
		Excel_Utility EUtilites= new Excel_Utility();
		
		String Url = FUtility.getPropertyKeyValue("url");
		String username = FUtility.getPropertyKeyValue("un");
		String password = FUtility.getPropertyKeyValue("pwd");
	
		driver.manage().window().maximize();
		wbUlitity.waitForPageToLoad(driver);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickProductsLink();
		
		CreateProductAndDelete productPage = new CreateProductAndDelete(driver);
		productPage.PlusProduct();
		
		int ranNum=Jutility.getRandomNumber();
		String ProductName= EUtilites.ExcelData("Products", 2, 0)+ranNum;

		productPage.ProductnameField(ProductName);
		productPage.SaveProduct();
		
		
		homePage.clickMore();
		homePage.clickCampaignsLink();
		
		CampaignPage campaign= new CampaignPage(driver);
		campaign.PlusIcon();
		
		AddingProductToCampaign add = new AddingProductToCampaign(driver);
		add.AddingProductToCampaign();
		
		wbUlitity.switchToWindow(driver, "Products&action");
		add.SearchProductName(ProductName);
		add.ProductName();
		
		wbUlitity.switchToBackWindow(driver, "Campaigns&action");
		
		campaign.CampaignNameTextField();
		
		int ranNum1=Jutility.getRandomNumber();
	    String campaignName = EUtilites.ExcelData("Campaign", 2, 0)+ranNum1;
		campaign.CampaignName(campaignName);
		campaign.CampaignSaveButton();
	
	     	WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	     	wbUlitity.mouseHover(driver, ele);
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
			
		}
}


