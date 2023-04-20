package practice;

import org.testng.annotations.DataProvider;

import generic_utility.Excel_Utility;

public class Dataproviderusingexcel {
	
	public void readData(String from,String to)
	{
		System.out.println(from+"------"+to);
	}
	
	
	@DataProvider
	public Object[][]getDat() throws Throwable
	{
		Excel_Utility elib=new Excel_Utility();
		Object[][]value=elib.readMultilpleData("Dataprovider");
		return value;
		
	}

}
