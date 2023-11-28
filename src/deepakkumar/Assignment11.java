/*
Assignment11 Nov19 (Multiselect dropdown & deselect)
- Navigate to http://automationbykrishna.com/index.html
- Navigate Basic elements
- Checkboxes and radios - Select multiple checkboxes
- Checkboxes and radios - DesSelect atleast 1 checkboxes
- Get List of all selected checkboxes.

*/

package deepakkumar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment11 {
	WebDriver dr;

	public void launchBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\chromeDriver\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get(url);
	}

	public void tempWait(int mSecs) {
		try {
			Thread.sleep(mSecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollFunction(WebDriver dr, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public void checkboxRadioButton() {
		launchBrowser("http://automationbykrishna.com/index.html");
		dr.findElement(By.xpath("//a[@id='basicelements']")).click();
		tempWait(4000);

		WebElement e = dr.findElement(By.xpath("//input[@id='optionsRadios2']"));
		scrollFunction(dr, e);

		System.out.println("STEP: All Inline Checkboxes Selected");
		dr.findElement(By.xpath("//input[@id='inlineCheckbox1']")).click();
		dr.findElement(By.xpath("//input[@id='inlineCheckbox2']")).click();
		WebElement inlineCheckbox3 = dr.findElement(By.xpath("//input[@id='inlineCheckbox3']"));
		inlineCheckbox3.click();
		System.out.println("STEP: One Checkbox UnSelected");
		inlineCheckbox3.click();
		if (!inlineCheckbox3.isSelected()) {
			System.out.println("3rd inline checkobox is deselected");
		} else
			System.out.println("3rd inline checkobox is selected");

		System.out.println("STEP: MULTI-SELECT selection");
		Select multiSelect = new Select(dr.findElement(By.xpath("//select[@class='form-control']")));
		multiSelect.selectByIndex(0);
		multiSelect.selectByIndex(1);
		multiSelect.selectByIndex(2);
		multiSelect.selectByIndex(3);
		List<WebElement> selectedValues = multiSelect.getAllSelectedOptions();
		for (WebElement temp : selectedValues) {
			System.out.println(temp.getText());
		}
		System.out.println("STEP: Deselect Action on MULTI-SELECT field");
		multiSelect.deselectByIndex(2);

		System.out.println("STEP: Final list of selected values");
		List<WebElement> finalSelectedValues = multiSelect.getAllSelectedOptions();
		for (WebElement temp : finalSelectedValues) {
			System.out.println(temp.getText());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment11 output = new Assignment11();
		output.checkboxRadioButton();
	}
}
