import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam04 {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("http://127.0.0.1:5500/selenium01.html");
		WebElement pop =  driver.findElement(By.id("pop"));
		pop.click();
		
		// driver.getWindowHandle(); // 단수형 셀레니움 켰을 때 브라우저 윈도우 창 주소 가장 Parent 창
		String defaultContent = driver.getWindowHandle(); // 복수형 셀레니움 켰을 때 모든 팝업 창의 주소를 리스트에 담아서 반환
		Set<String> windows = driver.getWindowHandles(); // 복수형 셀레니움 켰을 때 모든 팝업 창의 주소를 리스트에 담아서 반환
		System.out.println(windows.size());
		for(String window : windows) {
			if(!window.equals(defaultContent)) {
				driver.switchTo().window(window);
			}
		}
		driver.findElement(By.id("txt")).sendKeys("테스트 확인");
		
		Thread.sleep(5000);
	    driver.quit();
	}
}
