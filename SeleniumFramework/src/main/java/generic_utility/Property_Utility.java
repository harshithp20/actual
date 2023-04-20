package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
	/**
	 * This method is used to get common properties of whole project from a property file
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Harshith
	 */
	public String getKeyValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String Value = pro.getProperty(key);
		return Value;
	}
	

}
