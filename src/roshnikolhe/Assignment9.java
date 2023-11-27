/*Assignment9 Nov19 (Dropdown)
- Navigate to https://www.facebook.com/
- Click on 'Create new accout'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Custom)
- Select your pronoun
- Enter Gender

Hint: Use select class
selectByText("");
selectByValue("");
selectByIndex();
*/
package roshnikolhe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {
	
WebDriver driver;	
	
	void setUp() {
		System.out.println("Step1. Launch Chrome Browser");
		//String setProperty = System.setProperty("webdriver.chrome.driver","D:\\Technocredits\\Projects\\IDE\\Sep23Selenium\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("Step2. Maximize the window");
		driver.manage().window().maximize();
		
		System.out.println("Step3. Navigate to https://www.facebook.com/");
		driver.get("https://www.facebook.com/");
	}
	
	void waitABit(int ms) {
		try {
			Thread.sleep(ms);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	
	void createNewAccount() {
		waitABit(5000);
		System.out.println("Step4. Click on 'Create New Account'");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		waitABit(3000);
		System.out.println("Step5. Enter Name, Surname, Email, Password");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Roshni");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kolhe");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("roshni@kolhe.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("roshni@kolhe.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("techno@123");
		
		waitABit(3000);
		System.out.println("Step6 Select DOB");
		System.out.println("Step6.1 Select Day");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select daySelect = new Select(dayElement);
		daySelect.selectByIndex(4);
		//int day = Integer.parseInt(((WebElement) daySelect).getText());
		//System.out.println("Selected day is: " + daySelect);
		
		waitABit(3000);
		System.out.println("Step6.2. Select Month");
		WebElement monthElement = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select monthSelect = new Select(monthElement);
		monthSelect.selectByVisibleText("Feb");
		//String month = monthElement.getText();
		//System.out.println("Selected month is: " + month);
		
		waitABit(3000);
		System.out.println("Step6.3. Select Year");
		WebElement yearElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearSelect = new Select(yearElement);
		yearSelect.selectByVisibleText("2010");
		//int year = Integer.parseInt(yearElement.getText());
		//System.out.println("Selected day is: " + year);
		
		waitABit(3000);
		System.out.println("Step7. Select Gender as 'Custom'");
		WebElement genderRadio = driver.findElement(By.xpath("//label[text()='Custom']"));
		genderRadio.click();
		boolean flag = genderRadio.isSelected();
		if(flag){
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		waitABit(3000);
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByIndex(1);

		System.out.println("STEP 8- Verify gender selection");
		String gender = "He";
		String genderText = genderSelect.getFirstSelectedOption().getText();
		if(genderText.contains(gender)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
	}
	
	void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		Assignment9 assignment9 = new Assignment9();
		assignment9.setUp();
		assignment9.createNewAccount();
		assignment9.waitABit(3000);
		assignment9.closeBrowser();
	}	
}
