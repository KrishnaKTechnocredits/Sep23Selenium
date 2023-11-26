/*Please cover below annotations
@Test (alphabetical order)
Priority(priority=1)
dependsOnMethods : @Test(dependsOnMethods="m1")
alwaysRun : @Test(alwaysRun = true)
assign Groups to the test, run them from testng.xml
enabled : @Test(enabled=false)

Note: Create and run testNg.xml*/

package onkar;

import org.testng.annotations.Test;

public class Assignment26 {
	
	@Test(groups = "smoke")
	void m1() {
		System.out.println("Priority = 0");
	}
	
	@Test(priority = 1, groups = "smoke")
	void m2() {
		System.out.println("Method is having lower priority i.e 1. It will execute at last in sequence");
	}
	
	@Test(priority = -1, groups = "smoke")
	void m3(){
		System.out.println("Method with negative priority. It will get executed at highest priority");
	}
	
	@Test(dependsOnMethods="m1", groups = "dependsOn")
	void a1() {
		System.out.println("As per alphabetical order, it should have been executed before m1. But as we added dependsOnMethod = m1, it will execute after m1 is executed");
	}
	
	@Test(groups = "smoke")
	void m4() {
		System.out.println("This method will fail with arithmetic exception");
		int x = 10/0;
	}
	
	@Test(dependsOnMethods={"m1","m4"}, groups = "dependsOn")
	void a2() {
		System.out.println("Will wait for execution of m1 and m4. But this test will be skipped as m4 is failed");
	}
	
	@Test(dependsOnMethods={"m1","m4"}, alwaysRun = true, groups = "dependsOn")
	void a3() {
		System.out.println("Will wait for execution of m1 and m4 and the execution should be skipped. But as we have added alwaysRun = true, this method will get execute");
	}
	
	@Test(enabled=false)
	void a4() {
		System.out.println("This test case will not be replayed as we set (enabled=false)");
	}
}
