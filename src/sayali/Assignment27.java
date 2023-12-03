/* Write a program (WAP), if @BeforeMethod fails, testscripts will be marked as skip. */

package sayali;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment27 {

	@BeforeMethod
	void m1() {
		System.out.println("Method fails due to Arithmetic Exception");
		int x = 30 / 0;
	}

	@Test
	void m2() {
		System.out.println("Skipped execution as before method fails.");
	}

	@Test(alwaysRun = true)
	void m3() {
		System.out.println("Even if alwaysRun = true is added, this will be skipped as before method fails.");
	}

	@AfterMethod
	void m4() {
		System.out.println("Will be Skipped as above test cases not executed.");
	}
}