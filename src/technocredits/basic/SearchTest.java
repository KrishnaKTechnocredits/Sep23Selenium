package technocredits.basic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest {
	
	@BeforeTest
	public void SearchBeforeTest() {
		System.out.println("SearchFilterTest :  Launch browser and do login");
	}
	
	
	@Test
	public void searchM1() {
		System.out.println("Search m1");
	}
	
	@Test
	public void searchM2() {
		System.out.println("Search m2");
	}
	
	@AfterTest
	public void searchAfterTest() {
		System.out.println("SearchFilterTest : Kill browser");
	}
}
