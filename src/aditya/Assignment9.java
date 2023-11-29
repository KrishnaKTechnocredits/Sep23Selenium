package aditya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;;
public class Assignment9 {
	
			WebDriver driver;
			
			void setup(String url) {
				System.out.println("STEP - Launch chrome browser");
				// System.setProperty("webdriver.chrome.driver",
				// ".\\chromeDriver\\chromedriver.exe");
				driver =new ChromeDriver();// Launch Chrome Browser

				System.out.println("STEP - Maximize browser");
				driver.manage().window().maximize();

				System.out.println("STEP - Launch facebook.com");
				driver.get(url);
				
			}

			void basicElement() throws InterruptedException{
				setup("https://www.facebook.com/");
				System.out.println("Step: Click on Create new account button");
				WebElement CreatenewAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
				CreatenewAccount.click();
				Thread.sleep(8000);
				WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
				firstName.sendKeys("Aditya");
				
				 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kunjir");
				
				 driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("adityakunjir12@gmail.com");
				 
				 driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("ADK@223@123");
				 
				 Select BDay = new Select(driver.findElement(By.id("day")));
				 BDay.selectByValue("30");
				 System.out.println("Date Selected");
				 
				 Select month = new Select(driver.findElement(By.id("month")));
				 month.selectByIndex(5);
				 System.out.println("Month Selected");
				 
				 Select year = new Select(driver.findElement(By.id("year")));
				 year.selectByVisibleText("1998");
				 System.out.println("Year Selected");
				 
				 driver.findElement(By.xpath("//input[@value='-1']")).click();
				 System.out.println("Custom Selected");
				 Thread.sleep(3000);
				 
				 Select CustomeGender = new Select(driver.findElement(By.xpath("//select[@name='preferred_pronoun']")));
				 CustomeGender.selectByIndex(2);
				 System.out.println("Pronoun");
				 
				 driver.quit();
				 System.out.println("All test Executed ");
				 
			}
			
			
			public static void main(String[] args) throws InterruptedException {
				Assignment9 as9 = new Assignment9();
				as9.basicElement();
			}
	}

