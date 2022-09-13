package pageobjecj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
	 WebDriver driver;
	 By usernameBy=By.id("txtUserId");
	 By passwordBy=By.id("txtPassword");
	 By buttonBy=By.id("txtPassword");
//	 By captchaBy=By.xpath("//div[@id='ReCaptchContainer']");
	 By loginBy=By.id("btnLogin");
	public Loginpage(WebDriver driver) {
		this.driver=driver;
//	    PageFactory.initElements(driver, this);
	}
	public void login_input(String username_1,String password_1) {
		WebElement username=driver.findElement(usernameBy);
		WebElement password=driver.findElement(passwordBy);
		username.sendKeys(username_1);
		password.sendKeys(password_1);
		
	}
	public WebElement captch_handle() {
		By captchaBy=By.xpath("//div[@id='ReCaptchContainer']");
		isvisible(captchaBy);
		WebElement captch=driver.findElement(captchaBy);
		captch.click();
		By captcha_messageBy=By.cssSelector("label#lblMessage");
		isclickable(captcha_messageBy);
		WebElement captcha_message=driver.findElement(captcha_messageBy);
		return captcha_message;
		
		
		
	}
	
	public WebElement Login_() {
		isclickable(buttonBy);
		WebElement login_button=driver.findElement(buttonBy);
		return login_button;
	}
	 private void isvisible(By webelement) throws Error{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
              wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));
  }
	 private void isclickable(By webelement) throws Error{
	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	              wait.until(ExpectedConditions.elementToBeClickable(webelement));
  }	
	
	
		
}
