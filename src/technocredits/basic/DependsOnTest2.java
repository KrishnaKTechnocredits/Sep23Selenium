package technocredits.basic;

import org.testng.annotations.Test;

public class DependsOnTest2 {
	
	@Test
	void searchAddToCartTest() {
		System.out.println("SearchAddToCartTest"); //1
		int x = 10/0;
	}
	
	@Test
	void verifyAddToCartTest() {
		System.out.println("verifyAddToCartTest"); //2
		int x = 10/0;
	}
	
	@Test(dependsOnMethods = {"verifyAddToCartTest","searchAddToCartTest"}, alwaysRun = true)
	void averifyProductPaymentTest() {
		System.out.println("verifyProductPaymentTest"); //3
	}
}
