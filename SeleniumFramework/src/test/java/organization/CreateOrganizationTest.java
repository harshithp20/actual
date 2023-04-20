package organization;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import pom.HomePage;
import pom.OrganizationCreationPage;
import pom.ValidationandVerificationPage;

//@Listeners(generic_utility.Listeners.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(retryAnalyzer = generic_utility.RetryAnalyser.class)
//	@Test(groups={"smoketest","regressiontest"})
	public void CreateOrganization() throws Throwable{
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
		
//		Property_Utility plib=new Property_Utility();
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
		home.organizationlink();
		//Used assert here to take Screenhot
//		Assert.assertEquals(false, true);
		//driver.findElement(By.linkText("Organizations")).click();
		
		OrganizationCreationPage org=new OrganizationCreationPage(driver);
		org.organizationcreateimage();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String exceldata = elib.getExceldata("Organization", 0, 0)+RanNum;
		//String exceldata = elib.getExcelDataFormatter("Organization", 0, 0)+RanNum;
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String exceldata = cell.getStringCellValue()+RanNum;*/
		
		org.organizationnamestext(exceldata);
		//driver.findElement(By.name("accountname")).sendKeys(exceldata);
		
		org.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
		 String actualdata = validate.ValidationandVerificationoforganization(driver, exceldata);
		
		/*String actdata = driver.findElement(By.cssSelector("span[class=dvHeaderText]")).getText();
		if(actdata.contains(exceldata))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}*/
		
//		home.signoutLink(driver);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertEquals(actualdata, exceldata);
	}
}


