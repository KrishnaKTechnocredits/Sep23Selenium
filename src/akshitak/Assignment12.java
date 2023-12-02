package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment12 {
	WebDriver driver;

	@BeforeClass
	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("demotable")).click();
	}

	@Test
	void countRowColumn() {
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
		System.out.println("Number of column : " + list.size());
		List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		System.out.println("Number of Rows : " + row.size());
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}