package technocredits.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationTest2 {
	
	@BeforeClass
	public void init() {
		System.out.println("init");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BM");
	}
	
	@Test
	public void m1() {
		System.out.println("m1");
	}
	
	@Test
	public void m2() {
		System.out.println("m2");
	}
	
	@AfterClass
	public void close() {
		System.out.println("close");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AM");
	}
}
