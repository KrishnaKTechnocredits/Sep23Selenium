package akshitak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment20 {

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
	void employeeAtPosition() {
		selectPageSize();
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Map<String,Integer> hm = new HashMap<String,Integer>();
		for(WebElement name: list) {
			String position = name.getText();
			if(hm.containsKey(position)) {
				int count = hm.get(position);
				hm.put(position, count+1);
			}
			else {
				hm.put(position,1);
			}
		}
		System.out.println(hm);
	}
}
