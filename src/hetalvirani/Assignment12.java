package hetalvirani;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment12 {
	
	WebDriver driver;

	void setUp(String url) {
		System.out.println("Step - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shree\\eclipse-workspace\\SEP23Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("step - Launch url");
		driver.get(url);
	}

	void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void verifyTableRowCount() {
		setUp("http://automationbykrishna.com");
		System.out.println("step - click on demotables");
		WebElement demoTable = driver.findElement(By.xpath("//a[@id='demotable']"));
		demoTable.click();

		wait(3000);
		List<WebElement> listOfElements = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody//tr"));
		System.out.println(listOfElements.size());
		if(listOfElements.size()==9) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		List<WebElement> listOfElements2 = driver.findElements(By.xpath("//table[@class='table table-striped']/thead//th"));
		System.out.println(listOfElements2.size());
		if(listOfElements2.size()==5) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
			
	}
	public static void main(String[] args) {
		new Assignment12().verifyTableRowCount();
	}
}
