package technocredits.basic;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {
	
	void processData() {
		System.out.println("Hi");
	}
	
	@BeforeMethod
	public void init() {
		System.out.println("init");
	}
	
	@Test
	public void m1() {
		System.out.println("m1");
		System.out.println("m1 end");
	}
	
	@Test
	public void m2() {
		System.out.println("m2");
	}
	
	@AfterMethod
	public void close() {
		System.out.println("close");
		int x = 10/0;
		System.out.println("close - end");
	}
}
