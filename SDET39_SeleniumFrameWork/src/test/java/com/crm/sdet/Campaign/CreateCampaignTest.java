package com.crm.sdet.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.Excel_Utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.CampaignPage;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;
@Listeners(comcast.vtiger.genericUtility.ListenerImplementationClass.class)
public class CreateCampaignTest extends BaseClass{
@Test(groups="regressionTest")
public void CreateCampaign()throws Throwable
{
	
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
	homePage.clickMore();
	homePage.clickCampaignsLink();
	
	CampaignPage campaign= new CampaignPage(driver);
	campaign.PlusIcon();
	
	int ranNum=Jutility.getRandomNumber();
	
    String campaignName = EUtilites.ExcelData("Campaign", 2, 0);
    
	campaign.CampaignName(campaignName);
	campaign.CampaignSaveButton();
	
	String msg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();	
	homePage.getSignOutButton().click();
		driver.close();
	}

}
