package selenium2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ustjavasdetb424\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get( "http:/www.google.com");
	  System.out.println("Google loaded");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  

}
