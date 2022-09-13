package sele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dynsmic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Tools\\\\Selenium\\\\Chromedriver96\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		   Thread.sleep(2000L);
		   /*int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();//4 times
			i++;

		}*/
		   System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();

		}

		System.out.println(driver.findElement(By.id("btnclosepaxoption")).getText());
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		

	}

}
