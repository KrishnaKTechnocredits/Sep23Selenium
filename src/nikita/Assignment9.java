package nikita;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment9 {

WebDriver driver;
	
	void setup(String url) {
		System.out.println("Launch url");
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void scrollDown() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", " ");
	}
	
	void scrollToElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	
	void facebookSignUp(String fname, String lname,String mobilenum,String password,String selectday, int selectmonth, String selectyear) {
		sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstname']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='lastname']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);
		sleep(2000);
		//driver.findElement(By.xpath("//input[@name='reg_email__'])")).click();
		//driver.findElement(By.xpath("//input[@name='reg_email__'])")).sendKeys(mobilenum);
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobilenum);
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).click();
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
		
		Select day=new Select(driver.findElement(By.id("day")));
		day.selectByValue(selectday);
		Select month= new Select(driver.findElement(By.id("month")));
		month.selectByIndex(selectmonth);
		Select year= new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText(selectyear);
		WebElement radiobutton= driver.findElement(By.xpath("//input[@value='-1']"));
		radiobutton.click();
		if(radiobutton.isSelected()) {
			System.out.println("Test case passed");
		}
			else {
				System.out.println("Test case failed");
			}
		WebElement pronounelement= driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
		Select pronoundropdown=new Select(pronounelement);
		pronoundropdown.selectByValue("2");
		}		

	public static void main(String[] args) {
		Assignment9 assignment9= new Assignment9();
		assignment9.setup("https://www.facebook.com/signup");
		assignment9.facebookSignUp("Nora", "Fatehi", "8756451119", "Dec@2023", "9", 4, "1967");;
	}
}
