package shamligadekar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment14 {
	WebDriver driver;

	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void webTableTestCases(){
		setUp("http://automationbykrishna.com");
		System.out.println("STEP - Click on Demo Tables link");
		driver.findElement(By.id("demotable")).click();
		waitABit(3000);	

		List<WebElement> listOfCol = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th"));
		int columnsCount = listOfCol.size();

		List<WebElement> listOfRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		int rowsCount = listOfRow.size();

		System.out.println("STEP - Print last row data");
		for(int index=1; index<=columnsCount; index++) {
			System.out.print(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+rowsCount+"]/td["+index+"]")).getText());
			System.out.print(" ");
		}

		System.out.println("\n"+"STEP - Close browser");
		driver.close();

	}

	public static void main(String[] args) {
		new Assignment14().webTableTestCases();
	}

}
