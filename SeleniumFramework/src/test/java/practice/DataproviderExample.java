package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic_utility.Excel_Utility;


public class DataproviderExample {
	
	@Test(dataProvider = "dataProvider")
	public void readData(String from,String to) 
	{
		System.out.println(from+"------"+to);
	}
	
	@DataProvider
	public Object[][]dataProvider() throws Throwable
	{
		Object[][] objarr=new Object[3][2];
		Excel_Utility elib=new Excel_Utility();
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				objarr[i][j]=elib.getExceldata("Dataprovider", i, j);
			}
		}
		return objarr;
		
	}
//	@Test(dataProvider = "dataProvider" )
//	public void Booktickets(String src,String des)
//	{
//		System.out.println("Book tickets from "+src+ " to " +des);
//	}
//	@DataProvider
//	public Object[][] dataProvider()
//	{
//		Object[][] objarr=new Object[3][2];
//		
//		objarr[0][0]="Banglore";
//		objarr[0][1]="Goa";
//		
//		objarr[1][0]="Mysore";
//		objarr[1][1]="Manglore";
//		
//		objarr[2][0]="Banglore";
//		objarr[2][1]="Hubli";
//		return objarr;
//		
//	}
//	@Test(dataProvider ="dataProvider")
//	public void booktickets(String src, String des)
//	{
//		System.out.println("Book tickets from "+src+ " to " +des);
//	}
//	@DataProvider
//	public Object[] [] dataProvider() throws Throwable
//	{
//		Excel_Utility ex=new Excel_Utility();
//		Object[][] objarr=new Object[3][2];
//		for(int i=0; i<3; i++)
//		{
//			for(int j=0; j<2; j++)
//			{
//				objarr[i][j]=ex.getExceldata("Dataprovider", i, j);
//			}
//		}
//		return objarr;
//		
//	}
}
