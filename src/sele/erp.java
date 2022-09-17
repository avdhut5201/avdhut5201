	package sele;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageobjecj.HomePage;
import pageobjecj.Loginpage;
				
public class erp {

	
	public static void main(String[] args) throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", "Tools\\chromedriver.exe");
		WebDriver dChromedriver=new ChromeDriver();
		 WebDriverWait w=new WebDriverWait(dChromedriver, Duration.ofSeconds(30));
	dChromedriver.get("https://erp.mitwpu.edu.in/");
	dChromedriver.manage().window().maximize();
	Loginpage loginpage=new Loginpage(dChromedriver);
	loginpage.login_input("S1032200787", "FynS@3XbZH6ZMWH");
	WebElement success_lablElement=loginpage.captch_handle();
	Assert.assertEquals(success_lablElement.getText(),"Success" );
	WebElement button=dChromedriver.findElement(By.id("btnLogin"));
	button.click();
	HomePage homePage=new HomePage(dChromedriver);
	homePage.navbar();
	homePage.list_element();
	homePage.grade_card();
    homePage.download();
    homePage.assesment();
    w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[onclick=\"$find('ReportViewer1').exportReport('PDF');\"]")));
   dChromedriver.findElement(By.cssSelector("a[onclick=\"$find('ReportViewer1').exportReport('PDF');\"]")).click();

	}
	
//	public static  void myfunction() {
//		 try {
//			 Robot robot = new Robot();
//	   Thread mthread = new Thread(mlauncher);
//		   mthread.start();
//
//		  robot.keyPress(KeyEvent.VK_ENTER);
//		  robot.keyRelease(KeyEvent.VK_ENTER);
//
//		 } catch (Exception e) {
//		          e.printStackTrace();
//		       }
//	}
	public static WebElement retryingFindClick(By by,WebDriver driver) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                List<WebElement> listelement=driver.findElements(by);
                WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(30));
                
                for (WebElement webElement : listelement) {
                	w.until(ExpectedConditions.elementToBeClickable(webElement));
                	if (webElement.getText().equals("SY BTech - CSE / TRIMESTER-V / 2020-21 / Middle")) {
                		return webElement;
					}
					
				}
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
		return null;
       
}

}
