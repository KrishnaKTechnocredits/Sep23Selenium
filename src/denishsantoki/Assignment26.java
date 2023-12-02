/*Please cover below annotations
@Test (alphabetical order)
Priority(priority=1)
dependsOnMethods : @Test(dependsOnMethods="m1")
alwaysRun : @Test(alwaysRun = true)
assign Groups to the test, run them from testng.xml
enabled : @Test(enabled=false)
*/
package denishsantoki;

import org.testng.annotations.Test;

public class Assignment26 {
	
	@Test(groups = "Regression")
	void test1() {
		System.out.println("\n test1() Priority [by default] = 0");
	}

	@Test(groups = "Regression")
	void test2() {
		System.out.println("\n test2() method will fail with arithmetic exception");
		int x = 10 / 0;
		System.out.println(x);
	}

	@Test(priority = -1, groups = "Smoke")
	void test3() {
		System.out.println("\n test3()Lower the number higher the priority.It will execute at the first in sequence");
	}

	@Test(dependsOnMethods = "test1", groups = "groupTest")
	void m1() {
		System.out.println("\nAs per alphabetical order, m1() should have been executed before test1. But as we added dependsOnMethod = test1, test1 will execute before m1");
	}

	@Test(priority = 4, groups = "Smoke")
	void test4() {
		System.out.println("\nHigher the number lower the priority. test4() will execute at the end in sequence");
	}

	@Test(dependsOnMethods = { "test1", "test2" }, groups = "groupTest")
	void m2() {
		System.out.println("\nm2() will wait for execution of test1 and test4. But this test will be skipped as test2 will be failed due to Airthmatic exception");
	}

	@Test(dependsOnMethods = { "test1", "test2" }, alwaysRun = true, groups = "dependsOn")
	void m3() {
		System.out.println("\nm3() will wait for execution of test1 and test2 and as we have added alwaysRun = true, this method will also get execute though test2 will be failed due to Airthmatic exception");
	}

	@Test(enabled = false)
	void m4() {
		System.out.println("\nm4()  will not be executed as enabled=false[default value of @Test is enabled true]");
	}
}
