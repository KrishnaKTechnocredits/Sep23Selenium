package technocredits.basic;

import org.testng.annotations.Test;

public class GroupDemoTest {
	
	@Test(groups = "smoke")
	public void m1() {
		System.out.println("m1");
	}
	
	@Test(groups = "regression")
	public void m2() {
		System.out.println("m2");
	}
	
	@Test(groups = "regression")
	public void m3() {
		System.out.println("m3");
	}
	
	@Test(groups = "e2e")
	public void m4() {
		System.out.println("m4");
	}
	
	@Test(groups = {"e2e","smoke"})
	public void m5() {
		System.out.println("m5");
	}
	
	@Test(groups = {"e2e","regression"})
	public void m6() {
		System.out.println("m6");
	}
}
