package campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import pom.CampaignCreationPage;
import pom.HomePage;
import pom.ValidationandVerificationPage;

public class CreateCampaignTest extends BaseClass {
	@Test(groups="smoketest")
	public void CreateCampaign() throws Throwable {
		//1st approach to launch single browser 
		//WebDriver driver=new ChromeDriver();
		
		//2nd approach to launch single browser 
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		//3rd approach to launch multiple through property file browser 
//		Property_Utility plib=new Property_Utility();
//		WebDriver driver;
//		String BROWSER = plib.getKeyValue("browser");
//		
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.max(driver);
		wlib.implicitlywait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Property_Utility plib=new Property_Utility();
//		String URL = plib.getKeyValue("url");
//		String USERNAME = plib.getKeyValue("username");
//		String PASSWORD = plib.getKeyValue("password");
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
//		driver.get(URL);
		
		//driver.get("http://localhost:8888/");
		
//		LoginPage LoginPage = new LoginPage(driver);
//		LoginPage.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		HomePage home=new HomePage(driver);
		home.morelink(driver);
		home.campaignslink();
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();
		
		CampaignCreationPage cam=new CampaignCreationPage(driver);
		cam.campaigncreateimage();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String CampData = elib.getExceldata("Campaign", 0, 0)+RanNum;
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Campaign");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String CampData = cell.getStringCellValue()+RanNum;*/
		
		cam.campaignnametext(CampData);
		//driver.findElement(By.name("campaignname")).sendKeys(CampData);
		
		cam.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
		String actualdata = validate.ValidationandVerificationofCampaign(driver, CampData);
		
		/*String actdata = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actdata.contains(CampData))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
//		home.signoutLink(driver);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertEquals(actualdata, CampData);

	}

}
