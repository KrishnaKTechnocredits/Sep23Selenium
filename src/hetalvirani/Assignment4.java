package hetalvirani;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch automationbykrishna.com");
		driver.navigate().to("http://automationbykrishna.com/");

		System.out.println("step - click on Basicelements");
		WebElement basicElement = driver.findElement(By.id("basicelements"));
		basicElement.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", alertBtn);
		alertBtn.click();

		System.out.println("VERIFY - Alert message should be as expected");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("AlertText is " + alertText);
		if (alertText.contains("TechnoCredits")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		alert.accept();
		driver.close();
	}
}
