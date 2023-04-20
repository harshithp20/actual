package product;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;
import pom.CreateProductandDeleteProductCreationPage;
import pom.HomePage;
import pom.ValidationandVerificationPage;

public class CreateProductandDeleteProductTest extends BaseClass {
	@Test
	public void CreateProductandDeleteProduct() throws Throwable {
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
		
		HomePage home=new HomePage(driver);
		home.productslink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		CreateProductandDeleteProductCreationPage cpdpcp=new CreateProductandDeleteProductCreationPage(driver);
		cpdpcp.createproductimage();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//Random ran=new Random();
		//int RanNum=ran.nextInt(1000);
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		//String productdata = elib.getExceldata("Product", 0, 0)+RanNum;
		String productdata = elib.getExcelDataFormatter("Product", 0, 0)+RanNum;
		
		/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String productdata = cell.getStringCellValue()+RanNum;*/
		
		cpdpcp.productnametext(productdata);
		//driver.findElement(By.name("productname")).sendKeys(productdata);
		System.out.println(productdata);
		
		cpdpcp.savebutton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		home.productslink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productdata+"']/../preceding-sibling::td[1]")).click();
		
		cpdpcp.deleteproduct();
		//driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.switchtoalertandaccept(driver);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		
		ValidationandVerificationPage validate=new ValidationandVerificationPage(driver);
		String actualdata = validate.ValidationandVerificationofProductdeletion(driver, productdata);
		/*List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag=false;
		for(WebElement wb:lists)
		{
			String act = wb.getText();
			if(act.contains(productdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Product not deleted");
		}*/
		
//		home.signoutLink(driver);
		Assert.assertEquals(actualdata, productdata);
	}

}
