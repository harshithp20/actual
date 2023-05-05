package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingPrice {

	public static void main(String[] args)  throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa", Keys.ENTER);
		
		List<WebElement> searchdata = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		//List<WebElement> searchdata=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(searchdata.size());
		for (WebElement we : searchdata) 
		{
			
			
		String prodId = we.getAttribute("data-asin");
		WebElement prodname = driver.findElement(By.xpath("//div[@data-asin='"+prodId+"']//span[@class='a-size-medium a-color-base a-text-normal']"));
		WebElement price = driver.findElement(By.xpath("//div[@data-asin='"+prodId+"']//span[@class='a-price']"));
//		WebElement prodname = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
//		WebElement price = driver.findElement(By.xpath("//span[@class='a-price']"));
	    System.out.print(prodname.getText()+"\t");
		System.out.println(price.getText());
	    
	    System.out.println("------------------------------------");
	
	   }
	}

}
