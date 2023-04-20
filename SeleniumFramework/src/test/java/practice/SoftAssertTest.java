package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void createContact()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		SoftAssert st=new SoftAssert();
		st.assertEquals(false, true);
		System.out.println("Step 3");
		System.out.println("Step 4");
		st.assertAll();
	}
	@Test
	public void m1()
	{
		String expName = "Harshith P";
		String actName = "Harshith P";
		Assert.assertEquals(actName, expName);
	}
}
