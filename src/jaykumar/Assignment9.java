/*Assignment9 Nov19 (Dropdown)
- Navigate to https://www.facebook.com/
- Click on 'Create new accout'
- Enter name, surname, mobile or email & password
- Select DOB
- Select Gender (Custom)
- Select your pronoun
- Enter Gender*/

package jaykumar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {
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
		waitABit(3000);
		
		submitDetails("Jaykumar", "Bankar", "123456", "Jay123456");
		
		System.out.println("STEP - Enter DOB");
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		selectDropDown(dayElement).selectByVisibleText("13");
		
		WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
		selectDropDown(monthElement).selectByIndex(10);
		
		WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
		selectDropDown(yearElement).selectByValue("1997");
		
		System.out.println("STEP - Select custom gender");
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		WebElement genderElement = driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select genderSelect = new Select(genderElement);
		genderSelect.selectByIndex(2);
		
		System.out.println("STEP - Verify gender selection");
		String gender = "He";
		String genderText = genderSelect.getFirstSelectedOption().getText();
		if(genderText.contains(gender)) {
			System.out.println("Gender selection test passed");
		}else {
			System.out.println("Gender selection test failed");
		}
		
		System.out.println("STEP - Close browser");
		driver.close();
	}
	
	public static void main(String[] args) {
		new Assignment9().selectTestCases();
	}
}	
