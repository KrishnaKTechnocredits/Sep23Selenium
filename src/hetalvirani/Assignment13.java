package hetalvirani;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment13 {

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
		
		List<WebElement> listOfcoloum = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		int coloumsize=listOfcoloum.size();
		
		List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowsize=listOfRow.size();
		
		System.out.println("Step-print last row data");
		for(int index=1;index<=coloumsize;index++) {
			String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowsize+"]/td["+index+"]")).getText();
			System.out.print(text);
			System.out.print(" ");
		}
		driver.close();
	}
	public static void main(String[] args) {
		new Assignment13().verify();
	}

}
