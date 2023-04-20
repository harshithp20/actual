package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAsset {
	@Test
	public void createCustomer()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true, false);
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void m1()
	{
		String expName = "Harshith";
		String actName = "Harshith P";
		Assert.assertEquals(actName, expName);
	}
	
	
	

}
