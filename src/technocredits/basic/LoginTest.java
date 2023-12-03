package technocredits.basic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	@BeforeTest
	public void loginBeforeTest() {
		System.out.println("LoginDashboardTest :  Launch browser and do login");
	}

	/*
	 * @BeforeClass public void loginBeforeClass() {
	 * System.out.println("Login Before Class"); }
	 */

	@Test
	public void m1() {
		System.out.println("Login m1");
	}

	@Test
	public void loginM2() {
		System.out.println("Login m2");
	}

	/*
	 * @AfterClass public void loginAfterClass() {
	 * System.out.println("Login After Class"); }
	 */
	
	@AfterTest
	public void loginAfterTest() {
		System.out.println("LoginDashboardTest : Kill browser");
	}
}
