/*Assignment27 26Nov
Write a program (WAP), if @BeforeMethod fails, testscripts will be marked as skip.
*/
package yogeshchhatwani;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Yogesh_Assignment27 {
	@BeforeMethod
	public void setup() {
		System.out.println("Before method fails with arithmatic exception");
		int x = 10 / 0;
		System.out.println(x);
	}

	@Test(alwaysRun = true)
	public void m1() {
		System.out.println("Always run is true if before method fails and no other @test runs");
	}

	@Test
	public void m2() {
		System.out.println("This will not be executed as before method would through Arithmantic exception)");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("This will also be skipped as both test cases are not executed");
	}
}
