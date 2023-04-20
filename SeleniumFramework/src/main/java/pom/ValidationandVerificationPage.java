package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerificationPage {
	
	public ValidationandVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement actualorganizationname;
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement actualcampaignname;
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement actualproductname;
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement actcampname;
	
	@FindBy(xpath = "//span[@id='dtlview_Product']")
	private WebElement actproname;
	
	
	//Getter method
	public WebElement getActualorganizationname() {
		return actualorganizationname;
	}
	
	public WebElement getActualcampaignname() {
		return actualcampaignname;
	}

	public WebElement getActualproductname() {
		return actualproductname;
	}

	public WebElement getActcampname() {
		return actcampname;
	}

	public WebElement getActproname() {
		return actproname;
	}

	//Business logic
	public String ValidationandVerificationoforganization(WebDriver driver,String data)
	{
		String actdata =actualorganizationname.getText();
		if(actdata.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		return actdata;
		
	}
	
	public String ValidationandVerificationofCampaign(WebDriver driver,String data)
	{
		String actdata = actualcampaignname.getText();
		if(actdata.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		return actdata;
	}
	
	public String ValidationandVerificationofProduct(WebDriver driver,String data)
	{
		String actdata = actualproductname.getText();
		if(actdata.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		return actdata;
	}
	
	public String ValidationandVerificationofProductdeletion(WebDriver driver, String productdata)
	{
List<WebElement> lists = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
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
		}
		return productdata;
	}
	
	public String ValidationandVerificationofCampaignAddition(WebDriver driver,String data)
	{
	String act =actcampname.getText();
	if(act.contains(data))
	{
		System.out.println("Campaign Pass");
	}
	else
	{
		System.out.println("Campaign Fail");
	}
	return act;
  }
	
	public String ValidationandVerificationofProductAddition(WebDriver driver,String data)
	{
		String actData =actproname.getText();
		if(actData.contains(data))
		{
			System.out.println("Product Pass");
		}
		else
		{
			System.out.println("Product Fail");
		}
		return actData;
	}
	
}
