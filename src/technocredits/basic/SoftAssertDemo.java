package technocredits.basic;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	
	@Test
	void verifySoftAssertTest() {
		String str = "techno";
		String str1 = "Maulik";
		String str2 = "maulik";
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println(1);
		softAssert.assertTrue(1==2, "comparing 1 with 2, doesnt match");
		System.out.println(2);
		softAssert.assertEquals(str1, str2, "str1 value : " + str1 + " is not equals to str2 value : "+ str2);
		System.out.println(3);
		
		Assert.assertEquals(34, 44);
		System.out.println("After hard assert");
		
		softAssert.assertNull(str);
		System.out.println(str);
		
		softAssert.assertAll();
		System.out.println("Hi");
	
	}
}
