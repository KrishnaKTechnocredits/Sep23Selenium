/*- Navigate to http://automationbykrishna.com
-> Navigate Basic elements
-> Checkboxes and radios - Select multiple checkboxes
-> Inline checkboxes - select multiple Inline checkboxes*/
package shrutika;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10 {

	WebDriver driver;

	void setup(String url) {
		System.out.println("Step 1 : Launch Chrome Browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Step 2 : Open given URL");
		driver.get(url);
	}

	void verifyBasicElementCheckbox() {
		setup("http://automationbykrishna.com");

		System.out.println("Step 3 :Navigate Basic elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		System.out.println("Step 4 :Checkboxes and radios - Select multiple checkboxes");
		WebElement checkbox1 = driver.findElement(
				By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[2]//input[@type='checkbox']"));
		WebElement checkbox2 = driver.findElement(
				By.xpath("(//div[@class='form-group']//div[@class='checkbox'])[3]//input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", checkbox1);
		checkbox1.click();
		checkbox2.click();
		if (checkbox1.isSelected() && checkbox2.isSelected())
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		System.out.println("Step 5 :Inline checkboxes - select multiple Inline checkboxes");
		WebElement inlineCheckbox1 = driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
		WebElement inlineCheckbox2 = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
		WebElement inlineCheckbox3 = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));
		inlineCheckbox1.click();
		inlineCheckbox2.click();
		inlineCheckbox3.click();
		if (inlineCheckbox1.isSelected() && inlineCheckbox2.isSelected() && inlineCheckbox3.isSelected())
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

		System.out.println("Step 6 :Close the Browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment10().verifyBasicElementCheckbox();
	}
}
