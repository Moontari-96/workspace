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

public class Melonticket {
	public static void main(String[] args) throws Exception {
		// 프로그램 실행 시 필요한 인스턴스, 메서드
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			// 로그인 페이지 Start 멜론 계정 로그인
			driver.get(
					"https://member.melon.com/muid/family/ticket/login/web/login_inform.htm?cpId=WP15&returnPage=https://ticket.melon.com/performance/index.htm?prodId=209531");
			WebElement melonLogin = driver.findElements(By.className("melon")).get(0);
			melonLogin.click();

			// 멜론 계정 로그인 ID, PW 자동 입력 후 로그인
			WebElement inputID = driver.findElement(By.id("id"));
			js.executeScript("arguments[0].value=arguments[1]", inputID, Statics.MELON_ID);
			WebElement inputPW = driver.findElement(By.id("pwd"));
			js.executeScript("arguments[0].value=arguments[1]", inputPW, Statics.MELON_PWD);

			WebElement btnLogin = driver.findElement(By.id("btnLogin"));
			btnLogin.click();

			// 티켓팅 프로그램 날짜 선택
			// 티켓팅 할 페이지 url 입력
			driver.get("https://ticket.melon.com/performance/index.htm?prodId=209531");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dateSelect_20240705")));
			
			// ID값 변경 시 날짜 변경 가능 dateSelect_20240705 Ex)0705,0706,0707
			WebElement dateChoice = driver.findElement(By.id("dateSelect_20240705"));
			dateChoice.click();
			// 날짜 별 시간 초이스 배열값으로 시간 값 변경 가능. 처음값 0 ~ 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("item_time")));
			WebElement item_time = driver.findElements(By.className("item_time")).get(0);
			item_time.click();
			// 예매하기 버튼
			
			WebElement reserveBtn = driver.findElement(By.id("ticketReservation_Btn"));
			reserveBtn.click();
			// 클릭 시 예매창 윈도우 팝업
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			String defaultContent = driver.getWindowHandle(); 
			Set<String> windows = driver.getWindowHandles();
			for(String window : windows) {
				if(!window.equals(defaultContent)) {
					driver.switchTo().window(window);
					break;
				}
			}
			// iframe 접근 코드
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("oneStopDiv")));
		    WebElement oneStopDiv = driver.findElement(By.id("oneStopDiv"));
		    WebElement iframe = oneStopDiv.findElements(By.tagName("iframe")).get(0);
			driver.switchTo().frame(iframe);
			
			// 셀렉트 요소 검색 후 변수 저장
			// 그린팀
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("volume_11907_10067")));
			// WebElement selectElementGreen = driver.findElement(By.id("volume_11907_10067"));
			// 옐로우팀
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("volume_11909_10067")));
			WebElement selectElementYellow = driver.findElement(By.id("volume_11909_10067"));
			
			// 셀렉트 인스턴스 생성
			Select select = new Select(selectElementYellow);
			// 매수 설정 value(?) ?안에 숫자 입력
			select.selectByValue("1");
			
			// 매수 설정 후 다음 버튼
			WebElement btNext = driver.findElements(By.className("btNext")).get(0);

			if(btNext.getAttribute("class").contains("on")) {
				// 다음 결제 페이지로 넘어가는 버튼	
				WebElement nextBtn = driver.findElement(By.id("nextPayment"));
				nextBtn.click();
			}			
			// 무통장입금
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("payMethodCode003")));
			WebElement payMentRadio = driver.findElement(By.id("payMethodCode003"));
			payMentRadio.click();
			WebElement bankCode = driver.findElement(By.name("bankCode"));
			// 셀렉트 인스턴스 생성
			Select selectbk = new Select(bankCode);
			// 매수 설정 value(?) ?안에 은행명 입력
			// 은행별 value 코드 기업은행(03), 국민은행(04), 농협은행(11), 하나은행(81), 우리은행(20), 신한은행(88), 경남은행(39), 우체국(71), 부산은행(32), 대구은행(31)
			selectbk.selectByValue("04");
			// 현금영수증 발행 코드
			WebElement cashReceipts = driver.findElement(By.id("cashReceiptIssueCode1"));
			cashReceipts.click();
			// 010 자동배정 현금영수증 코드
			WebElement receiptMidNum = driver.findElement(By.id("cashReceiptRegTelNo2"));
			WebElement receiptLastNum = driver.findElement(By.id("cashReceiptRegTelNo3"));
			// midnum = 중간번호값 4자리, lastnum = 마지막 번호값 4자리
			receiptMidNum.sendKeys("5482");
			receiptLastNum.sendKeys("9107");
			
			// 현금영수증 미발행 코드
			// WebElement notcashReceipts = driver.findElement(By.id("cashReceiptIssueCode3"));
			// notcashReceipts.click();
			
			// 예매자동의
			WebElement chkAgreeAll = driver.findElement(By.id("chkAgreeAll"));
			chkAgreeAll.click();
			
			// 최종 결제 버튼
			WebElement btNextF = driver.findElements(By.className("btNext")).get(0);
			
			if(btNextF.getAttribute("class").contains("on")) {
				WebElement finalPaymentBtn = driver.findElement(By.id("btnFinalPayment"));
//				finalPaymentBtn.click();
			}
		} finally {
			Thread.sleep(10000);
			driver.quit();
		}

	}
}
