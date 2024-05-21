import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Melonticket2 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			driver.get(
					"https://member.melon.com/muid/family/ticket/login/web/login_inform.htm?cpId=WP15&returnPage=https://ticket.melon.com/performance/index.htm?prodId=209531");
			WebElement melonLogin = driver.findElements(By.className("melon")).get(0);
			melonLogin.click();

			WebElement inputID = driver.findElement(By.id("id"));
			js.executeScript("arguments[0].value=arguments[1]", inputID, Statics.MELON_ID);
			WebElement inputPW = driver.findElement(By.id("pwd"));
			js.executeScript("arguments[0].value=arguments[1]", inputPW, Statics.MELON_PWD);

			WebElement btnLogin = driver.findElement(By.id("btnLogin"));
			btnLogin.click();

			driver.get("https://ticket.melon.com/performance/index.htm?prodId=209531");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dateSelect_20240705")));
			
			WebElement dateChoice = driver.findElement(By.id("dateSelect_20240705"));
			dateChoice.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("item_time")));
			WebElement item_time = driver.findElements(By.className("item_time")).get(0);
			item_time.click();
			
			WebElement reserveBtn = driver.findElement(By.id("ticketReservation_Btn"));
			reserveBtn.click();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			String defaultContent = driver.getWindowHandle(); 
			Set<String> windows = driver.getWindowHandles();
			for(String window : windows) {
				if(!window.equals(defaultContent)) {
					driver.switchTo().window(window);
					break;
				}
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("oneStopDiv")));
		    WebElement oneStopDiv = driver.findElement(By.id("oneStopDiv"));
		    WebElement iframe = oneStopDiv.findElements(By.tagName("iframe")).get(0);
			driver.switchTo().frame(iframe);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("volume_11909_10067")));
			WebElement selectElementYellow = driver.findElement(By.id("volume_11909_10067"));
			
			Select select = new Select(selectElementYellow);
			select.selectByValue("1");
			
			WebElement btNext = driver.findElements(By.className("btNext")).get(0);

			if(btNext.getAttribute("class").contains("off")) {
				WebElement nextBtn = driver.findElement(By.id("nextPayment"));
				nextBtn.click();
			}			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("payMethodCode003")));
			WebElement payMentRadio = driver.findElement(By.id("payMethodCode003"));
			payMentRadio.click();
			WebElement bankCode = driver.findElement(By.name("bankCode"));
			Select selectbk = new Select(bankCode);
			selectbk.selectByValue("04");
			WebElement cashReceipts = driver.findElement(By.id("cashReceiptIssueCode1"));
			cashReceipts.click();
			WebElement receiptMidNum = driver.findElement(By.id("cashReceiptRegTelNo2"));
			WebElement receiptLastNum = driver.findElement(By.id("cashReceiptRegTelNo3"));
			receiptMidNum.sendKeys("5482");
			receiptLastNum.sendKeys("9107");
			
			WebElement chkAgreeAll = driver.findElement(By.id("chkAgreeAll"));
			chkAgreeAll.click();
			
			WebElement btNextF = driver.findElements(By.className("btNext")).get(0);
			
			if(btNextF.getAttribute("class").contains("off")) {
				WebElement finalPaymentBtn = driver.findElement(By.id("btnFinalPayment"));
			}
		} finally {
			Thread.sleep(10000);
			driver.quit();
		}

	}
}
