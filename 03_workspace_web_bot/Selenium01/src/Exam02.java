import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Exam02 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		driver.get("http://www.naver.com");
//		List<WebElement> list = driver.findElements(By.className("MyView-module__link_login___HpHMW"));
//		WebElement buttonLogin = list.get(0);
//		buttonLogin.click();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");
	    WebElement inputID = driver.findElement(By.id("id"));
	    WebElement inputPW = driver.findElement(By.id("pw"));
	    js.executeScript("arguments[0].value=arguments[1]", inputID, Statics.NAVER_ID);
	    js.executeScript("arguments[0].value=arguments[1]", inputPW, Statics.NAVER_PW);
	    
	    WebElement buttonLogin = driver.findElement(By.id("log.login"));
	    buttonLogin.click();
//	    inputID.sendKeys("abc1234");
//	    inputPW.sendKeys("abc12345768");
	}
}
