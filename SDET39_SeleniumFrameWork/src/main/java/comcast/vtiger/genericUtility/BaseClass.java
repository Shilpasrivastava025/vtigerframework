package comcast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public WebDriver driver=null;
public static WebDriver sdriver;
File_Utility FileUtility =new File_Utility();

   @BeforeSuite()
	public void BS()
	{
	System.out.println("DataBase Connection");
	}

   @BeforeTest
	public void BT()
	{
	System.out.println("Execute Script in Parallel Mode");
	}
   //@Parameters("BROWSER")
    @BeforeClass(groups= {"smokeTest","regressionTest"})
	public void BC() throws Throwable
	{
    System.out.println("Launching the Browser");
    	
   String BROWSER = FileUtility.getPropertyKeyValue("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
	sdriver=driver;
		}
	
		@BeforeMethod
		public void BM() throws Throwable
		{
		System.out.println("Login to Application");
		
		String Url=FileUtility.getPropertyKeyValue("url");
		String Username=FileUtility.getPropertyKeyValue("username");
		String Password=FileUtility.getPropertyKeyValue("password");
		driver.get(Url);
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(Username, Password);
		}
	
		@AfterMethod
		public void AM()
		{
		System.out.println("logout from Application");
		}
		@AfterClass
		public void AC()
		{
		System.out.println("closing the Browser");
		}
		@AfterTest
		public void At()
		{
		System.out.println("parallel Execution is done");
		}
		@AfterSuite
		public void AS()
		{
		System.out.println("Data Base Connection Close");
		}
		}
			