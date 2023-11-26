/*Write a program (WAP), if @BeforeMethod fails, testscripts will be marked as skip.*/

package onkar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment27 {
	
	@BeforeMethod
	void m1() {
		System.out.println("Method is failing due to arithmatic exception");
		int x = 10/0;
	}
	
	@Test
	void m2() {
		System.out.println("As cofiguration itself is failed, m2 will not get executed");
	}
	
	@Test(alwaysRun = true)
	void m3() {
		System.out.println("Even if alwaysRun = true is added, m3 will not be executed due to failure in configuration");
	}
	
	@AfterMethod
	void m4() {
		System.out.println("This execution also will not be done");
	}
}
