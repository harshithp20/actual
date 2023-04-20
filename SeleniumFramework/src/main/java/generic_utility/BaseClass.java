package generic_utility;

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
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.HomePage;
import pom.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	@BeforeSuite(groups= {"smoketest","regressiontest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups= {"smoketest","regressiontest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest","regressiontest"})
//	public void BC(String BROWSER)
	public void BC() throws Throwable
	{
		
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		System.out.println("Launching browser");
		sdriver=driver;
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups= {"smoketest","regressiontest"})
//	public void BM(String URL,String USERNAME,String PASSWORD)
	public void BM() throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Application");
	}
	
	@AfterMethod(groups= {"smoketest","regressiontest"})
	public void AM()
	{
		HomePage home=new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups= {"smoketest","regressiontest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterTest(groups= {"smoketest","regressiontest"})
	public void AT()
	{
		System.out.println("Parallel Execution Done");
	}
	
	@AfterSuite(groups= {"smoketest","regressiontest"})
	public void AS()
	{
		System.out.println("DataBase connection close");
	}

}
