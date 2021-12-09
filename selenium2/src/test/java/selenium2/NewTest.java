package selenium2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
  @Test(priority=0)
  public void test_checkbox() {
	  WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[2]/div/label"));
		checkbox.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.id("filters_availability_In_Stock_Only")).isSelected());
  }
  @Test(priority=1)
  public void test_radio() throws InterruptedException {
	  List<WebElement> radio =  driver.findElements(By.name("price_limit"));
		Actions actions = new Actions(driver);
		for(int i=0;i<radio.size();i++) {
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]"))).perform();
			System.out.println("Cursor hovered over to price");
			radio.get(i).click();
			System.out.println(radio.get(i).getAttribute("value")+"- button clicked");
			Thread.sleep(5000);
		}
  }
  @Test(priority=2)
  public void test_dropdown() throws InterruptedException {
	  Actions actions = new Actions(driver);
	  for(int i=2;i<3;i++) {
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span"));
			actions.moveToElement(dropdown).perform();
			System.out.println("Cursor hovered over to "+dropdown.getText());
			WebElement dropdownEl=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li["+i+"]"));
			dropdownEl.click();
			System.out.println(dropdownEl.getText()+"- button clicked");
			Thread.sleep(5000);
	}
  }
  @Test(priority=3)
  public void test_search() throws InterruptedException {
	  WebElement search = driver.findElement(By.id("search"));
		search.sendKeys("Astrid TV Unit");
		driver.findElement(By.id("search_button")).click();
		System.out.println("Searched Astrid TV Unit");
		Thread.sleep(5000);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
		driver = new ChromeDriver();
		String baseUrl = "https://www.urbanladder.com/tv-units?src=g_topnav_storage_living-storage_tv-units";
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Close")).click();
		System.out.println("Closed pop-up");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
