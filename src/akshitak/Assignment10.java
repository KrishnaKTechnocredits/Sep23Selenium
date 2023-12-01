package akshitak;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import okio.Timeout;
//import org.openqa.selenium.support.ui.Select;

public class Assignment10 {

	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
	}

	void clickBasicElement() {
		navigatrURL();
		System.out.println("Click Basic Element");
		driver.findElement(By.id("basicelements")).click();
	}

	void scrollTillView() {
		clickBasicElement();
		WebElement we = driver
				.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='col-lg-10']/div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", we);
	}

	void singleCheckbox() {
		scrollTillView();
		driver.findElement(By.xpath("//form[@class='form-horizontal adminex-form']//div[@class='col-lg-10']/div[1]")).click();
		System.out.println("Single checkbox selected");
	}

	void clickAllCheckbox() {
		singleCheckbox();
		List<WebElement> wList = driver.findElements(By.xpath("//div[@class='col-lg-10']/label"));
		int index = 0;
		for (WebElement name : wList) {
			name.click();
			index++;
		}
		System.out.println("Multicheckbox selected");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment10().clickAllCheckbox();
	}
}
