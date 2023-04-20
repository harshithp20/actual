package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Create constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="user_name")private WebElement usernameTxt;
	
	@FindBy(name="user_password")private WebElement passwordTxt;
	
	@FindBy(id="submitButton")private WebElement submitBtn;
	
	//Utilization
	public WebElement getUsernameTxt() {
		return usernameTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	//Business logic
	
	public void loginToApp(String username, String password)
	{
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		submitBtn.click();
	}
}
