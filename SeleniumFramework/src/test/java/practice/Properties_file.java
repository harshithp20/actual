package practice;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Properties_file {

	public static void main(String[] args) throws Throwable {
        WebDriver driver=new EdgeDriver();
		
		//Path of the property file or Setting connection between Script and property file(External resource)
		FileInputStream fis=new FileInputStream("./src/test/resources\\commondata.properties.txt");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Harshith P\\Desktop\\commondata.properties.txt");
		
		//To call methods from the property class in order to load or fetch data from property file to the script  (Fetching the data)
		Properties pro=new Properties();
		pro.load(fis);  //loading the data of the file to properties class
		
		//Call methods of properties class and storing data as variables
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//Now using variables in test script without hard coding 
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
	}

}
