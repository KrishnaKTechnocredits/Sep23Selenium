package technocredits.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemoTest2 {
	WebDriver driver;

	void setUp(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();// Launch Chrome Browser

		System.out.println("STEP - Maximize browser");
		driver.manage().window().maximize();

		System.out.println("STEP - Navigate to URL");
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 250 ms default pooling
	}

	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void printAvailableDropdownOptions() {
		setUp("https://www.facebook.com/");
		System.out.println("STEP - Click on Create new account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();

		//waitABit(3000);
		System.out.println("STEP - Click on Custom");
		driver.findElement(By.xpath("//input[@value='-1']")).click(); // 250 + 250 + 250 + 250 250 + 250 + 250 + 250 250 + 250 + 250 + 250 250 + 250 + 250 + 250 
		
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		System.out.println("Is Dropdown MultiSelect ? " + genderSelect.isMultiple());
		
		genderSelect.selectByValue("2");
		//genderSelect.deselectByValue("2");

		// String selectedOptionText = genderSelect.getFirstSelectedOption().getText();
		// System.out.println(selectedOptionText);

		List<WebElement> listOfOptions = genderSelect.getOptions();

		for (WebElement e : listOfOptions) {
			if(e.isSelected())
				System.out.println(e.getText());
		}

		/*
		 * for(int index=0;index<listOfOptions.size();index++) { WebElement e =
		 * listOfOptions.get(index); System.out.println(e.getText()); }
		 */
	}

	public static void main(String[] args) {
		new DropdownDemoTest2().printAvailableDropdownOptions();
	}
}
