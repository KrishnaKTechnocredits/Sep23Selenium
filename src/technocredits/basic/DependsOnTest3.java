package technocredits.basic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnTest3 {

	
	@BeforeMethod
	void verifyAddToCartTest() {
		System.out.println("verifyAddToCartTest"); //2
		int x = 10/0;
	}
	
	@Test(alwaysRun = true)
	void averifyProductPaymentTest() {
		System.out.println("verifyProductPaymentTest"); //3
	}
}
