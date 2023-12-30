package nikita;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Assignment3 {

	RemoteWebDriver driver;

	void launchUrl() {
		System.setProperty("webdriver.chrome.driver",".\\chromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com");		
	}
	
	void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void enterbasicdetails()  {
		System.out.println("Click on basic elements");
		driver.manage().window().maximize();
		sleep();
		WebElement basicelement= driver.findElement(By.id("basicelements"));
		basicelement.click();
		sleep();
		WebElement firstusername=driver.findElement(By.xpath("//input[@id='UserFirstName']"));
		sleep();
		firstusername.click();
		sleep();
		firstusername.sendKeys("Nikita");
		WebElement Lastusername=driver.findElement(By.id("UserLastName"));
		Lastusername.click();
		Lastusername.sendKeys("Naik");
		WebElement usercompanyname=driver.findElement(By.id("UserCompanyName"));
		usercompanyname.click();
		sleep();
		usercompanyname.sendKeys("Globant");
		sleep();
		WebElement submit=driver.findElement(By.xpath("//div[@id='firstRow']//div[@name='secondSegment'][1]//button"));
		submit.click();
		String expectedmsg=firstusername+ "and" +Lastusername+ "and" +usercompanyname;
		System.out.println(expectedmsg);
		System.out.println("Clicked on submit");
		System.out.println(expectedmsg);
		sleep();
		Alert alert= driver.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println();
		driver.switchTo().alert().accept();
		if(expectedmsg.equals(alertmsg)) {
			System.out.println("Actual and expected message is same");
		}
		else {
				System.out.println("Actual and expected message is not same");
			}
		}
		public static void main(String[] args){
			Assignment3 assignment3= new Assignment3();
			assignment3.launchUrl();
			assignment3.enterbasicdetails();
		}
	}