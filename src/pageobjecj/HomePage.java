package pageobjecj;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage  {
	private WebDriver driver;
	By navbarBy=By.xpath("//nav[@class=\"mt-2\"]/ul/li[12]/a[@href=\"Examination/Report/StudentGradeCardDetail.aspx?MENU_CODE=Web_Result\"]");
	By listElement=By.tagName("li");
	By iframeBy=By.id("FrameContent");
	By arrowBy=By.id("drpSem_Arrow");
	By gradeBy=By.id("rdoResultType_0");
	By assesmentBy=By.id("rdoResultType_1");
	By show_button=By.id("btnshow");
	By image_button=By.id("ReportViewer1_ctl06_ctl04_ctl00_ButtonLink");
	By downloadlinkBy=By.cssSelector("a[onclick=\"$find('ReportViewer1').exportReport('PDF');\"]");
	 
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void navbar() {
		WebElement navbar=driver.findElement(navbarBy);
		navbar.click();
	}
	
	public WebElement list_element() {
		frame_switch();
		isclickable(arrowBy);
		WebElement arrow_btnElement=driver.findElement(arrowBy);
		List<WebElement> listelement=driver.findElements(listElement);
		arrow_btnElement.click();
	    WebElement test=retryingFindClick(listElement, driver);
        test.click();
		
		return null;
        
		
	}
	private void isclickable(By webelement) throws Error{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
              wait.until(ExpectedConditions.elementToBeClickable(webelement));
  }
	private void frame_switch() throws Error{
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
              wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeBy));
  }
	
	 private void isvisible(By webelement) throws Error{
	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	              wait.until(ExpectedConditions.visibilityOfElementLocated(webelement));
	  }
	 private void show_click() {
	        WebElement show=driver.findElement(show_button);
	        show.click();
	        
	  }
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
//			public static WebElement retryingClick(By by,WebDriver driver) {
//		        boolean result = false;
//		        int attempts = 0;
//		        while(attempts < 2) {
//		            try {
//		                List<WebElement> listelement=driver.findElements(by);
//		                WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(30));
//		                
//		                for (WebElement webElement : listelement) {
//		                	w.until(ExpectedConditions.elementToBeClickable(webElement));
//		                	if (webElement.getText().equals("SY BTech - CSE / TRIMESTER-V / 2020-21 / Middle")) {
//		                		return webElement;
//							}
//							
//						}
//		                result = true;
//		                break;
//		            } catch(StaleElementReferenceException e) {
//		            }
//		            attempts++;
//		        }
//				return null;
		}
		public void download() throws InterruptedException  {
           isclickable(downloadlinkBy);
		WebElement download_link= driver.findElement(downloadlinkBy);;
    	download_link.click();
		
		}
	public void grade_card() throws InterruptedException {
				isclickable(gradeBy);
				WebElement grade_radio_buttonElement=driver.findElement(gradeBy);
				if(grade_radio_buttonElement.isSelected()) {
//					 WebElement show=d river.findElement(show_button);
//				        show.click();
					show_click();
					isclickable(image_button);
					WebElement image_buttonElement=driver.findElement(image_button);
					image_buttonElement.click();
//					
//				download();
				}
				
			}
	public void assesment() throws InterruptedException {
		isclickable(assesmentBy);
		WebElement assesment_radio_buttonElement=driver.findElement(assesmentBy);
		Assert.assertFalse(assesment_radio_buttonElement.isSelected());
		assesment_radio_buttonElement.click();
		if(assesment_radio_buttonElement.isSelected()) {
			isclickable(show_button);
			 WebElement show=driver.findElement(show_button);
		        show.click();
//			show_click();
			isclickable(image_button);
			WebElement image_buttonElement=driver.findElement(image_button);
			image_buttonElement.click();
			
		}
	}
}
