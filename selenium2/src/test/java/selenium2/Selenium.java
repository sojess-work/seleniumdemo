package selenium2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wwwso\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.urbanladder.com/tv-units?src=g_topnav_storage_living-storage_tv-units";
		driver.get(baseUrl);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Close")).click();
		System.out.println("Closed pop-up");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//checking if checkbox is working
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[2]/div/label"));
		checkbox.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.id("filters_availability_In_Stock_Only")).isSelected());
		//checking radio button
		List<WebElement> radio =  driver.findElements(By.name("price_limit"));
		Actions actions = new Actions(driver);
		for(int i=0;i<radio.size();i++) {
			actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]"))).perform();
			System.out.println("Cursor hovered over to price");
			radio.get(i).click();
			System.out.println(radio.get(i).getAttribute("value")+"- button clicked");
			Thread.sleep(5000);
		}
		//checking dropdown
		for(int i=2;i<3;i++) {
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span"));
			actions.moveToElement(dropdown).perform();
			System.out.println("Cursor hovered over to "+dropdown.getText());
			WebElement dropdownEl=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li["+i+"]"));
			dropdownEl.click();
			System.out.println(dropdownEl.getText()+"- button clicked");
			Thread.sleep(5000);
	}
		//checking searchbox
				WebElement search = driver.findElement(By.id("search"));
				search.sendKeys("Astrid TV Unit");
				driver.findElement(By.id("search_button")).click();
				System.out.println("Searched Astrid TV Unit");
				Thread.sleep(5000);
				
				driver.close();
		}
	
		
		
		

	}

