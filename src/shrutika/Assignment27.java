/*Write a program , if @BeforeMethod fails, testscripts will be marked as skip.*/
package shrutika;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment27 {

	@BeforeMethod
	public void openBrowser() {
		System.out.println("openBrowser()[@BeforeMethod] will fail with arithmatic exception");
		int x = 10 / 0;
		System.out.println(x);
	}

	@Test
	public void m1() {
		System.out.println("\n m1() will not execute as Beforemethod through Arithmantic exception");
	}

	@Test(alwaysRun = true)
	public void m2() {
		System.out.println("\n m2() always run is true if before method fails then no other @test get execute");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("\ncloseBrowser() will also be skipped as both test cases are not executed");
	}
}
