//Assignment9 Nov19 (Dropdown)
//- Navigate to https://www.facebook.com/
//- Click on 'Create new accout'
//- Enter name, surname, mobile or email & password
//- Select DOB
//- Select Gender (Custom)
//- Select your pronoun
//- Enter Gender
//
//Hint: Use select class
//selectByText("");
//selectByValue("");
//selectByIndex();

package pushpag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {
	WebDriver driver;

	public void setBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to https://www.facebook.com/
		System.out.println("Step 1 - Navigate to https://www.facebook.com/");
		driver.navigate().to("https://www.facebook.com/");
		wait(3000);
	}

	public void fillDetails() {

		// - Click on 'Create new account'
		System.out.println("Step 2 - Click on 'Create new account'");
		WebElement createAccountElement = driver.findElement(By.xpath("//a[text() = 'Create new account']"));
		createAccountElement.click();
		wait(3000);

		// - Enter name, surname, mobile or email & password
		System.out.println("Step 3 - Enter name, surname, mobile or email & password ");
		WebElement fnameElement = driver.findElement(By.xpath("//input[@name= 'firstname']"));
		fnameElement.sendKeys("Pushpa");

		WebElement lnameElement = driver.findElement(By.xpath("//input[@name= 'lastname']"));
		lnameElement.sendKeys("Gite");

		WebElement emailElement = driver.findElement(By.xpath("//input[@name= 'reg_email__']"));
		emailElement.sendKeys("pushpa.gite1209@gmail.com");

		WebElement reenterEmailElement = driver.findElement(By.xpath("//input[@name= 'reg_email_confirmation__']"));
		reenterEmailElement.sendKeys("pushpa.gite1209@gmail.com");

		WebElement passwordElement = driver.findElement(By.xpath("//input[@name= 'reg_passwd__']"));
		passwordElement.sendKeys("Pa$$w0rd");

		// - Select DOB
		System.out.println("Step 4 - Select DOB");
		Select selectDay = new Select(driver.findElement(By.xpath("//select[@name= 'birthday_day']")));
		selectDay.selectByVisibleText("12");

		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name= 'birthday_month']")));
		selectMonth.selectByIndex(8);

		Select selectYear = new Select(driver.findElement(By.xpath("//select[@name= 'birthday_year']")));
		selectYear.selectByValue("1996");

		// - Select Gender (Actual gender);
		System.out.println("Step 5 - Select Gender (Actual gender)");
		WebElement genderElement = driver.findElement(By.xpath("//label[text() = 'Custom']"));
		genderElement.click();

		// - Select your pronoun
		System.out.println("Step 6 - Select your pronoun");
		Select selectPronoun = new Select(driver.findElement(By.name("preferred_pronoun")));
		selectPronoun.selectByVisibleText("She: \"Wish her a happy birthday!\"");
		
		//- Enter Gender
		System.out.println("Step 7 - Enter Gender");
		WebElement customGenderEle = driver.findElement(By.name("custom_gender"));
		customGenderEle.sendKeys("Female");

	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public void closeDriver() {
		driver.close();
	}

	public static void main(String[] args) {
		Assignment9 assignment9 = new Assignment9();
		assignment9.setBrowser();
		assignment9.wait(3000);
		assignment9.fillDetails();
		assignment9.wait(3000);
		assignment9.closeDriver();

	}
}