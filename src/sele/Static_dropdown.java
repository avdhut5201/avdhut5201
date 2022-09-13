package sele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_dropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\Chromedriver96\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement select_dropElement=driver.findElement(By.cssSelector(""));
		Select dropSelect=new Select(select_dropElement);	
		dropSelect.selectByIndex(3);
		System.out.println(dropSelect.getFirstSelectedOption().getText());
	

	}

}
