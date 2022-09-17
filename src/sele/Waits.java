package sele;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\Chromedriver96\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver,itemsNeeded);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
    	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
    	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
    	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
    	driver.findElement(By.cssSelector("button.promoBtn")).click();
    	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
    	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}
	public static  void addItems(WebDriver driver,String[] itemsNeeded)

	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			//Brocolli - 1 Kg
			//Brocolli,    1 kg
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			System.out.println(formattedName);
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//  check whether name you extracted is present in arrayList or not-
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(formattedName)) {
				j++;

				//click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
			
		}
	
	}
}
	
//span[@class='_aamw']//div[@class='_abm0 _abm1']//*[name()='svg']
//a[contains(@class,'qi72231t nu7423ey n3hqoq4p r86q59rh b3qcqh3k fq87ekyn bdao358l fsf7x5fv rse6dlih s5oniofx m8h3af8h l7ghb35v kjdc1dyq kmwttqpk srn514ro oxkhqvkx rl78xhln nch0832m cr00lzj9 rn8ck1ys s3jn8y49 icdlwmnq _aa-z _aa-- _ac_u _a6hd')]