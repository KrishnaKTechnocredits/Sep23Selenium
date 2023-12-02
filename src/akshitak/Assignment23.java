package akshitak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment23 {

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
		driver.get("https://datatables.net/");
	}

	@BeforeMethod
	void selectPageSize() {
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");
	}

	@Test
	void sortLocation() {
		selectPageSize();
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement name : list) {
			al.add(name.getText());
		}
		Collections.sort(al);
		System.out.println("Expected List : " + al);
		driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]")).click();
		List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		ArrayList<String> output = new ArrayList<String>();
		for (WebElement name : list1) {
			output.add(name.getText());
		}
		System.out.println("Sorted List : " + output);
		if (al.equals(output)) {
			System.out.println("Sorting suceessfull");
		} else
			System.out.println("Sorting Fail");
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
