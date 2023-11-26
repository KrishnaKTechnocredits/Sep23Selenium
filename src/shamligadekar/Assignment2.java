package shamligadekar;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {
	
	WebDriver driver;	
	WebElement usernameElement;
	WebElement passwordElement;
	
	void launchBrowser(String url) {
		System.out.println("STEP - Launch chrome browser");
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait(3000);
		System.out.println("STEP-Navigate to "+url);
		driver.get(url);
	}

	void verifyAlert(String expectedalertmessage) {
		System.out.println("Verify Alert Message");
		Alert alert=driver.switchTo().alert();
		String alertmessage=alert.getText();
		System.out.println("Alert Messsage is :"+alertmessage);
		if(alertmessage.equals(expectedalertmessage)) {
			System.out.println("Verify Alert Test Pass");
		}
		else {
			System.out.println("Verify Alert Test Fail");
		}	
		wait(3000);
		alert.accept();
	}
	
	void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void login(String userName, String password) {
		System.out.println("STEP-Enter UserName");
		usernameElement=driver.findElement(By.id("unameSignin"));
		usernameElement.sendKeys(userName);
		
		System.out.println("STEP-Enter Password");
		passwordElement=driver.findElement(By.id("pwdSignin"));
		passwordElement.sendKeys(password);
				
		WebElement loginBtn = driver.findElement(By.id("btnsubmitdetails"));
		wait(3000);
		loginBtn.click();
	}
	
	void clearDetails() {
		System.out.println("STEP- Clease username and password ");
		usernameElement.clear();
		passwordElement.clear();
	}

	void testCases() {
		launchBrowser("http://automationbykrishna.com/");
		System.out.println("STEP-Click on registration link");
		driver.findElement(By.id("registration2")).click();
		
		login("ShamliGadekar", "Shamli@1234");
		verifyAlert("Success!");
		wait(3000);
		clearDetails();		
		
		login("ShamliGadekar", "Sham34");
		verifyAlert("Failed! please enter strong password");
		clearDetails();
		wait(3000);
		
		System.out.println("STEP- Browser close");
		driver.close();
	}

	public static void main(String[] args) {
		Assignment2 assignment2= new Assignment2();
		assignment2.testCases();
	}
}
