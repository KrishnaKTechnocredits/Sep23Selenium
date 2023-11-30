package akshitak;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment20 {

	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("https://datatables.net/");
	}

	void selectPageSize() {
		navigatrURL();
		Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
		se.selectByValue("100");
	}
	
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
	
	public static void main(String[] args) {
		new Assignment20().employeeAtPosition();
	}
}
