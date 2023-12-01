package akshitak;

		import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.support.ui.Select;

		public class Assignment23 {

			WebDriver driver;

			void luanchChrome() {
				System.setProperty("webdriver.chrome.driver", "D:\\Technocresdits\\Sep2023\\Chrome_Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

			void navigatrURL() {
				luanchChrome();
				driver.get("https://datatables.net/");
			}

			void selectPageSize() {
				navigatrURL();
				Select se = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
				se.selectByValue("100");
			}
			
			void sortLocation() {
				selectPageSize();
				List<WebElement> list =  driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
				ArrayList<String> al = new ArrayList<String>();
				for(WebElement name : list) {
					al.add(name.getText());
				}
				Collections.sort(al);
				System.out.println("Expected List : " + al);
				driver.findElement(By.xpath("//table[@id='example']/thead/tr/th[3]")).click();
				List<WebElement> list1 =  driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
				ArrayList<String> output = new ArrayList<String>();
				for(WebElement name : list1) {
					output.add(name.getText());
				}
				System.out.println("Sorted List : "+output);
				if(al.equals(output)) {
					System.out.println("Sorting suceessfull");
				}
				else
					System.out.println("Sorting Fail");
			}
	
		public static void main(String[] args) {
		  new Assignment23().sortLocation();
		}
}
