package campaigns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import pom.CreateCampaignwithProductCreationPage;
import pom.HomePage;
import pom.ValidationandVerificationPage;

public class CeateCampaignwithProductTest extends BaseClass {
	@Test(groups="regressiontest")
	public void CeateCampaignwithProduct() throws Throwable {
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
//		LoginPage LoginPage=new LoginPage(driver);
//		LoginPage.loginToApp(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
		HomePage home=new HomePage(driver);
		home.productslink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateCampaignwithProductCreationPage ccpcp=new CreateCampaignwithProductCreationPage(driver);
		ccpcp.createproductimage();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String productdata = elib.getExceldata("Product", 0, 0)+RanNum;
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue()+RanNum;*/
		
		ccpcp.productnametext(productdata);
		//driver.findElement(By.name("productname")).sendKeys(productdata);
		
		ccpcp.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		home.morelink(driver);
		home.campaignslink();
		ccpcp.campaigncreateimage();
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		

		String CampData = elib.getExceldata("Campaign", 0, 0)+RanNum;
		
		/*FileInputStream fes1=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book1 = WorkbookFactory.create(fes1);
		Sheet sheet1 = book1.getSheet("Campaign");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		String CampData = cell1.getStringCellValue()+RanNum;*/
		
		ccpcp.campaignnametext(CampData);
		//driver.findElement(By.name("campaignname")).sendKeys(CampData);
		ccpcp.selectdropdown();
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wlib.switchwindow(driver, "Products&action");
		
		/*Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		while(id.hasNext())
		{
			String wid = id.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
		}*/
		
		ccpcp.searchbox(productdata);
		//driver.findElement(By.id("search_txt")).sendKeys(productdata);
		ccpcp.searchbutton();
		//driver.findElement(By.name("search")).click();
		
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
		
		wlib.switchwindow(driver, "Campaigns&action");
		
		/*Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> id1 = allId1.iterator();
		while(id1.hasNext())
		{
			String wid1 = id1.next();
			driver.switchTo().window(wid1);
			String title = driver.getTitle();
			if(title.contains("Campaigns&action"))
			{
				break;
			}
		}*/
		
		ccpcp.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
		String actualdata1 = validate.ValidationandVerificationofCampaignAddition(driver, CampData);
		String actualdata2 = validate.ValidationandVerificationofProductAddition(driver, productdata);
		/*String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(act.contains(CampData))
		{
			System.out.println("Campaign Pass");
		}
		else
		{
			System.out.println("Campaign Fail");
		}
		
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if(actData.contains(productdata))
		{
			System.out.println("Product Pass");
		}
		else
		{
			System.out.println("Product Fail");
		}*/
//		home.signoutLink(driver);
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertEquals(actualdata1, CampData);
		Assert.assertEquals(actualdata2, productdata);
	}

}
