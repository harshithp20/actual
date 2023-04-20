package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic_utility.Webdriver_Utility;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productslink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	//Getters method

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignout() {
		return signout;
	}
	
	//Business logic for more
	public void morelink(WebDriver driver)
	{
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.mouseoveronelement(driver, morelink);
	}
	
	//Campaign
	public void campaignslink()
	{
		campaignslink.click();
	}
	
	//Organization
	public void organizationlink()
	{
		organizationlink.click();
	}
	
	//Products
	public void productslink()
	{
		productslink.click();
	}
	
	//Sign out
	public void signoutLink(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(signoutimg).perform();
		signout.click();
	}
}
