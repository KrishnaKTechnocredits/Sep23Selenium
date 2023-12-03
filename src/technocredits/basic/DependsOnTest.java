package technocredits.basic;

import org.testng.annotations.Test;

public class DependsOnTest {
	
	@Test
	void searchAddToCartTest() {
		System.out.println("SearchAddToCartTest"); //1
	}
	
	@Test(dependsOnMethods = "searchAddToCartTest")
	void verifyAddToCartTest() {
		System.out.println("verifyAddToCartTest"); //2
		int x = 10/0;
	}
	
	@Test(dependsOnMethods = "verifyAddToCartTest")
	void averifyProductPaymentTest() {
		System.out.println("verifyProductPaymentTest"); //3
	}
}
