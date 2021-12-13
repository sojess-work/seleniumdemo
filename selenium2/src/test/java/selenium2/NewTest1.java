package selenium2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	WebDriver driver;
  @Test
  public void test_search() throws InterruptedException {
	  	WebElement search = driver.findElement(By.id("search"));
		search.sendKeys("Astrid TV Unit");
		driver.findElement(By.id("search_button")).click();
		System.out.println("Searched Astrid TV Unit");
		Thread.sleep(5000);
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	 	 System.setProperty("webdriver.chrome.driver","C:\\Users\\ustjavasdetb424\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://www.urbanladder.com/tv-units?src=g_topnav_storage_living-storage_tv-units";
		driver.get(baseUrl);
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.linkText("Close")).click();
		System.out.println("Closed pop-up");
		TimeUnit.SECONDS.sleep(5);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
