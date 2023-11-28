package akshitak;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Assignment4 {
	WebDriver driver;

	void luanchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
		System.out.println("Luanch Chrome");
		driver = new ChromeDriver();
		System.out.println("Maximize window");
		driver.manage().window().maximize();
	}

	void navigatrURL() {
		luanchChrome();
		System.out.println("Get URL");
		driver.get("http://automationbykrishna.com/");
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	void basicElement() {
		navigatrURL();
		System.out.println("Navigate to Basic Element");
		driver.findElement(By.id("basicelements")).click();
		wait(2000);
		System.out.println("Find Alert button");
	}

	void scrollTillView() {
		basicElement();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",
				driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
	}

	void clickAlert() {
		scrollTillView();
		Alert alert = driver.switchTo().alert();
		wait(2000);
		String message = alert.getText();
		System.out.println(message);
		wait(2000);
		if (message.contains("TechnoCredits"))
			System.out.println("Techno found on alert");
		else
			System.out.println("Techno not found on alert");
		alert.accept();
		//driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		new Assignment4().clickAlert();
	}
}
