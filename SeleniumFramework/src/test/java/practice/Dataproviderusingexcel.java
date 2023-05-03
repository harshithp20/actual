package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;

public class Dataproviderusingexcel {
	
	@Test(dataProvider = "getData")
	public void readData(String from,String to)
	{
		System.out.println(from+"------"+to);
	}
	
	
	@DataProvider
	public Object[][]getData() throws Throwable
	{
		Excel_Utility elib=new Excel_Utility();
		Object[][]value=elib.readMultilpleData("Dataprovider");
		return value;
		
	}

}
