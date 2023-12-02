package akshitak;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment10 {

	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Get URL");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
	}

	@BeforeMethod
	void clickBasicElementsingleCheckbox() {
		System.out.println("Click Basic Element");
		driver.findElement(By.id("basicelements")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement check = driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='col-lg-10']/div[1]"));
		js.executeScript("arguments[0].scrollIntoView(true)", check);
		check.click();
		System.out.println("Single checkbox selected");
	}

	@Test
	void clickAllCheckbox() {
		List<WebElement> wList = driver.findElements(By.xpath("//div[@class='col-lg-10']/label"));
		int index = 0;
		for (WebElement name : wList) {
			name.click();
			index++;
		}
		System.out.println("Multicheckbox selected");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
