package practice1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
public class FirstPt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(); 
		
		driver.get("https://www.amazon.in/");  // opening url
		System.out.println(driver.getTitle());  //Printing title
		//Task to select books from search dropdown
		driver.findElement(By.id("searchDropdownBox")).click();
		Select dd = new Select(driver.findElement(By.id("searchDropdownBox")));
		dd.selectByVisibleText("Books");
		//Searching for books related to search keyword TCS
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("TCS");
		
		driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
		//Clicking on first visible element by link using link text
		driver.findElement(By.linkText("ssc english 215 tcs shifts 3rd edition english medium")).click();
		//Moving to new window

		ArrayList<String> newTab= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1)); 
		//Implementing explicit wait
		WebDriverWait time = new WebDriverWait(driver,Duration.ofSeconds(10));
		 
		time.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='submit.add-to-cart']")));
		//implementing mousehover action to confirm wait time
		WebElement cart = driver.findElement(By.xpath("//*[@name='submit.add-to-cart']"));

		Actions hover= new Actions(driver);
		hover.moveToElement(cart);
		hover.perform();
		//Implementing Screenshot 
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
			Files.copy(ss,new File("D:\\Documents\\tt.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		//driver.quit();  //closing browser
		

	}

}
