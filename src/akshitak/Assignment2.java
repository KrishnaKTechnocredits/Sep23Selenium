package akshitak;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");

		System.out.println("Launch Chrome");
		WebDriver driver = new ChromeDriver();

		System.out.println("Maximize Window");
		driver.manage().window().maximize();

		System.out.println("Navigate to");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Click on Registration link");
		driver.findElement(By.id("registration2")).click();

		Thread.sleep(2000);
		System.out.println("Enter UserName");
		driver.findElement(By.id("unameSignin")).sendKeys("Akshita");

		Thread.sleep(2000);
		System.out.println("Enter Password");
		driver.findElement(By.id("pwdSignin")).sendKeys("Reset@1234");

		Thread.sleep(2000);
		System.out.println("Click Login Button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		Thread.sleep(2000);
		System.out.println("Verify Alert Sucess Message");
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals("Success!"))
			System.out.println("Success Alert message match");
		else
			System.out.println("Success Alert message didnot match");

		alert.accept();

		System.out.println("Clear userName field");
		driver.findElement(By.id("unameSignin")).clear();

		System.out.println("Clear Password field");
		driver.findElement(By.id("pwdSignin")).clear();

		System.out.println("Enter UserName");
		driver.findElement(By.id("unameSignin")).sendKeys("Akshita");

		System.out.println("Enter Password");
		driver.findElement(By.id("pwdSignin")).sendKeys("Rese");

		System.out.println("Click Login Button");
		driver.findElement(By.id("btnsubmitdetails")).click();

		System.out.println("Verify Alert Sucess Message");
		Alert alert1 = driver.switchTo().alert();
		if (alert1.getText().equals("Failed! please enter strong password"))
			System.out.println("Failed Alert message match");
		else
			System.out.println("Failed Alert message didnot match");
		alert1.accept();
		driver.close();
	}
}
