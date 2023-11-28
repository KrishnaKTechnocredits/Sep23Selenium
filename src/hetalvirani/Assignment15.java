package hetalvirani;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment15 {

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

	void verify() {
		setUp("http://automationbykrishna.com");
		System.out.println("Step-click on demotable link");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		wait(3000);
		
		List<WebElement> listOfcoloum = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		int lastrowcount = driver.findElements(By.xpath("//table[@class='table']/tbody/tr")).size();
		
		System.out.println("Step-print all data of table");
		for(int rowindex=1;rowindex<=lastrowcount;rowindex++) {
			for(int index=1;index<=listOfcoloum.size();index++) {
				String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowindex+"]/td["+index+"]")).getText();
				if(index==listOfcoloum.size()) {
					System.out.print(text);
				}else {
					System.out.print(text + " ");
				}
			}
			System.out.println();
		}
		driver.close();
	}
	public static void main(String[] args) {
		new Assignment15().verify();
	}

}

