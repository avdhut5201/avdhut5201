package sele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Instagram_like_post {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Tools\\\\Selenium\\\\Chromedriver96\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver dChromeDriver=new ChromeDriver();
		WebDriverWait w =new WebDriverWait(dChromeDriver, Duration.ofSeconds(5));
		dChromeDriver.get("https://www.instagram.com/");
	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
		WebElement login_username=dChromeDriver.findElement(By.cssSelector("input[name='username']"));
		WebElement login_password=dChromeDriver.findElement(By.cssSelector("input[name='password']"));
		WebElement login_LogIn=dChromeDriver.findElement(By.xpath("//button/div[contains(text(), 'Log In')]"));
		login_username.sendKeys("avdhutjsh5201@gmail.com");
		login_password.sendKeys("avdhut@1811");
		login_LogIn.click();

	}

}
