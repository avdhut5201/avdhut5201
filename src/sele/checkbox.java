package sele;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\Chromedriver96\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		boolean state;
//		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		Assert.assertFalse(driver.findElements(By.cssSelector("input[type=checkbox]")).);
//		driver.findElements(By.cssSelector("input[type=checkbox]")).
//		Assert.assertTrue(driver.findElement(By.cssSelector("input[type=checkbox]")).isSelected());
//		driver.findElement(By.cssSelector("input[type=checkbox]")).clear();
		List<WebElement> checkboxElement=driver.findElements(By.cssSelector("input[type=checkbox]"));
		for (WebElement checkbox : checkboxElement) {
			Assert.assertFalse(checkbox.isSelected());
			checkbox.click();
			System.out.println(checkbox.getAttribute("value")+"Is selected");
			Assert.assertTrue(checkbox.isSelected());
			checkbox.click();
			System.out.println(checkbox.getAttribute("value")+" Is unselected");
			
		}
		
		System.out.println(checkboxElement.size());
		driver.close();
//		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

	}
	
}//
