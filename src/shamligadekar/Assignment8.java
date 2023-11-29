package shamligadekar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment8 {

	WebDriver driver;

	void setUp(String url){
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("STEP - Launch: "+url);
		driver.get(url);
	}

	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void submitDetails(String fName, String lName, String mob, String password) {
		System.out.println("STEP - Enter Details");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mob);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
	}

	Select selectDropDown(WebElement e) {
		Select oSelect = new Select(e);
		return oSelect;
	}

	void selectTestCases() {
		setUp("https://www.facebook.com/");

		System.out.println("STEP - Click on Create New Account");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		wait(3000);

		submitDetails("Shamli", "Gadekar", "123456", "Shamli@123");

		System.out.println("STEP - Enter DOB");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		selectDropDown(dayElement).selectByVisibleText("22");

		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		selectDropDown(monthElement).selectByIndex(3);

		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		selectDropDown(yearElement).selectByValue("1996");


		System.out.println("STEP - Select gender");
		WebElement genderElement = driver.findElement(By.xpath("//input[@value='1']"));
		genderElement.click();

		System.out.println("STEP - Verify gender selection");
		if(genderElement.isSelected()) {
			System.out.println("Gender selection test passed");
		}else {
			System.out.println("Gender selection test failed");
		}

		System.out.println("STEP - Close browser");
		driver.close();
	}

	public static void main(String[] args) {
		new Assignment8().selectTestCases();
	}
	
}
