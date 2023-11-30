package akshitak;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment17 {

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

	void getUniqueNameList() {
		selectPageSize();
		System.out.println("Unique Name List");
		List<WebElement> list =  driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		//Set<String> hs = new LinkedHashSet<String>();
		for(WebElement name: list) {
			System.out.println(name.getText());
			//hs.add(name.getText());
		}
		//System.out.println(hs);
	}
	
	public static void main(String[] args) {
		new Assignment17().getUniqueNameList();
	}
}
