import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Exam02 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver duration 시간 만큼 대기가 가능 최대 시간 지정 그전에 요소를 찾으면 종료
		// driver.get("http://www.naver.com");
		
		// WebElement buttonLogin = list.get(0);
		// buttonLogin.click();
		
		// 네이버 로그인 페이지로 이동
	    driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");
	    // 로그인 코드
	    WebElement inputID = driver.findElement(By.id("id"));
	    js.executeScript("arguments[0].value=arguments[1]", inputID, Statics.NAVER_ID);
	    
	    WebElement inputPW = driver.findElement(By.id("pw"));
	    js.executeScript("arguments[0].value=arguments[1]", inputPW, Statics.NAVER_PW);
	    // inputID.sendKeys("abc1234");
	    // inputPW.sendKeys("abc12345768");
	    
	    WebElement buttonLogin = driver.findElement(By.id("log.login"));
	    buttonLogin.click();
	    driver.get("https://mail.naver.com/v2/folders/0/all"); // 로그인 이후 mail로 이동
	    
	    // Thread.sleep(2000); // 명시적 대기 : 싱크를 맞추기 위한 지연 코드 작성 좋은방법이 아님
	    // 메일로 이동 후 내게쓰기로 이동
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button_write_to_me")));
	    WebElement writeToMe = driver.findElement(By.className("button_write_to_me"));
	    writeToMe.click();
	    
	    // 내게쓰기 제목 입력 코드
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject_title")));
	    WebElement inputTitle = driver.findElement(By.id("subject_title"));
	    inputTitle.sendKeys("제목입력되는지 확인");
	    // 내게쓰기 콘텐츠 내용 입력 코드
	    // iframe 접근 코드
	    WebElement editorBody = driver.findElements(By.className("editor_body")).get(0);
	    WebElement iframe = editorBody.findElements(By.tagName("iframe")).get(0);
	    driver.switchTo().frame(iframe);
	    // 접근 후 클래스 찾는 용도
	    List<WebElement> list= driver.findElements(By.className("workseditor-content"));
	    list.get(0).sendKeys("이 메일은 자동 봇이 보내는 메일입니다");
	    // 메일발송 코드
	    driver.switchTo().parentFrame();
	    WebElement sendMail = driver.findElements(By.className("button_write_task")).get(0);
	    sendMail.click();
	    Thread.sleep(5000);
	    driver.quit();
	}
}

