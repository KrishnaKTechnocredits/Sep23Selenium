//select all checkbox deselect at least one and get list of selected one

package akshitak;

/*
Assignment11 Nov19 (Multiselect dropdown & deselect)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.

*/

//select all checkbox deselect at least one and get list of selected one

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment11 {
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
	}

	@BeforeMethod
	void basicElement() {
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Find Alert button");
		basicElement();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[@class='col-lg-10']/label[1]")));
	}

	@Test
	void selectAllCheckbox() {
		System.out.println("Select all checkbox");
		Select se = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		for (int index = 0; index <= 4; index++) {
			se.selectByIndex(index);
		}
		System.out.println("Unslect one checkbox");
		driver.findElement(By.xpath("//select[@class='form-control']/option[2]")).click();
		System.out.println("Get list of selected checkbox");
		List<WebElement> list = se.getAllSelectedOptions();
		for (WebElement name : list) {
			System.out.println(name.getText());
		}
		driver.close();
	}
}
