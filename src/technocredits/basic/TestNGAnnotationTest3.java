package technocredits.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationTest3 {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BM");
	}
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
	}
	
	@Test(priority = -10)
	public void dashboardTest() {
		System.out.println("Dashboard Test");
	}
	
	@Test
	public void cartTest() {
		System.out.println("Cart Test");
	}
	
	@AfterClass
	public void close() {
		System.out.println("close");
	}
}
