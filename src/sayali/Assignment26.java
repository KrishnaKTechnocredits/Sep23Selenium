/*Please cover below annotations
@Test (alphabetical order)
Priority(priority=1)
dependsOnMethods : @Test(dependsOnMethods="m1")
alwaysRun : @Test(alwaysRun = true)
assign Groups to the test, run them from testng.xml
enabled : @Test(enabled=false)
Note: Create and run testNg.xml*/

package sayali;

import org.testng.annotations.Test;

public class Assignment26 {

	@Test(groups = "sanity")
	void m1() {
		System.out.println("Priority = 0");
	}

	@Test(priority = 1, groups = "sanity")
	void m2() {
		System.out.println("This method gets executed at last.");
	}

	@Test(priority = -1, groups = "sanity")
	void m3(){
		System.out.println("This method gets executed as of highest priority");
	}

	@Test(dependsOnMethods="m1", groups = "dependsOn")
	void n1() {
		System.out.println("This method is depends On Method m1, so it will execute after m1 execution.");
	}

	@Test(groups = "sanity")
	void m4() {
		System.out.println("Method fails with ArithmeticException");
		int x = 30/0;
	}

	@Test(dependsOnMethods={"m1","m4"}, groups = "dependsOn")
	void n2() {
		System.out.println("This method depends on execution of m1 and m4 but will be skipped as m4 will fail.");
	}

	@Test(dependsOnMethods={"m1","m4"}, alwaysRun = true, groups = "dependsOn")
	void n3() {
		System.out.println("Execution  of this method should be skipped as m4 will fail but as 'alwaysRun = true' is added, method will get execute successfully.");
	}

	@Test(enabled=false)
	void n4() {
		System.out.println("Will not execute as we set (enabled=false)");
	}
}