import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam03 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("http://127.0.0.1:5500/selenium01.html");
		WebElement pop =  driver.findElement(By.id("pop"));
		pop.click();
		driver.switchTo().alert().accept();
		
		WebElement input =  driver.findElement(By.id("txt"));
		input.sendKeys("ABC");
		
		Thread.sleep(5000);
	    driver.quit();
	}
}
