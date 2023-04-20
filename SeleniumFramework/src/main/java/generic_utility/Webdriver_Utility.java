package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {
	
	/**
	 * This method is used wait for page to load before identifying any synchronized element in DOM
	 * @param driver
	 * @author Harshith
	 */
	public void implicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**
	 * This method is used to switch to any window based on the window title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author Harshith
	 */
	
	public void switchwindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> id1 = allId1.iterator();
		while(id1.hasNext())
		{
			String wid1 = id1.next();
			driver.switchTo().window(wid1);
			String title = driver.getTitle();
			if(title.contains(PartialWindowTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method id used to maximize the focusing window
	 * @param driver
	 * @author Harshith
	 */
	public void max(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void mouseoveronelement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void switchtoalertandaccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	

}
