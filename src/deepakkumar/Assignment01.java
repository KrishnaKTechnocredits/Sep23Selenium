/*

1. Launch Chrome Browser
2. Navigate to "http://automationbykrishna.com"
3. Verify title should be "Login Signup Demo"
4. Navigate to "https://www.technocredits.com/courses"
5. Verify title should be "Krishna’s Courses"
6. Navigate back
7. Verify title should be "Login Signup Demo"
8. Navigate forward
9. Verify title should be "Krishna’s Courses"
10. Refresh page
11. Verify title should be "Krishna’s Courses"
12. Verfiy current url should be https://www.technocredits.com/courses

*/

package deepakkumar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {
	// TODO Auto-generated method stub
	WebDriver dr;

	public void verifyTitles() {
		dr.get("http://automationbykrishna.com");
		System.out.println("STEP : Navigation to 1st url");

		String expectedTitle1 = "Login Signup Demo";
		String expectedTitle2 = "Krishna’s Courses";

		System.out.println("STEP : Verify title should be \"Login Signup Demo\"-GET Action");
		String actualTitle1 = dr.getTitle();
		if (actualTitle1.equals(expectedTitle1)) {
			System.out.println("Title is " + actualTitle1 + ", hence Passed!");
		} else
			System.out.println("Title is " + actualTitle1 + ", hence Failed!");

		System.out.println("STEP : Verify title should be \"Krishna’s Courses\"-NAVIGATE Action");
		dr.navigate().to("https://www.technocredits.com/courses");
		String actualTitle2 = dr.getTitle();
		if (actualTitle2.equals(expectedTitle2)) {
			System.out.println("Title is " + actualTitle2 + ", hence Passed!");
		} else
			System.out.println("Title is " + actualTitle2 + ", hence Failed!");

		System.out.println("STEP : Verify title should be \"Login Signup Demo\"-BACK Action");
		dr.navigate().back();
		actualTitle1 = dr.getTitle();
		if (actualTitle1.equals(expectedTitle1)) {
			System.out.println("Title is " + actualTitle1 + ", hence Passed!");
		} else
			System.out.println("Title is " + actualTitle1 + ", hence Failed!");

		System.out.println("STEP : Verify title should be \"Krishna’s Courses\"-FORWARD Action");
		dr.navigate().forward();
		actualTitle2 = dr.getTitle();
		if (actualTitle2.equals(expectedTitle2)) {
			System.out.println("Title is " + actualTitle2 + ", hence Passed!");
		} else
			System.out.println("Title is " + actualTitle2 + ", hence Failed!");

		System.out.println("STEP : Verify title should be \"Krishna’s Courses\"-REFRESH Action");
		dr.navigate().refresh();
		actualTitle2 = dr.getTitle();
		if (actualTitle2.equals(expectedTitle2)) {
			System.out.println("Title is " + actualTitle2 + ", hence Passed!");
		} else
			System.out.println("Title is " + actualTitle2 + ", hence Failed!");

		System.out.println("STEP : Verify title should be \"Krishna’s Courses\"-GET_CURRENT_URL Action");
		String expectedCurrentURL = "https://www.technocredits.com/courses";
		String actualCurrentURL = dr.getCurrentUrl();
		if (actualCurrentURL.equals(expectedCurrentURL)) {
			System.out.println("Title is " + actualCurrentURL + ", hence Passed!");
		} else
			System.out.println("Title is " + actualCurrentURL + ", hence Failed!");

	}

	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
	}

	public static void main(String[] args) {
		Assignment01 output = new Assignment01();
		output.LaunchBrowser();
		output.verifyTitles();
	}
}
