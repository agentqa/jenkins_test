package working_on_jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTwo {
	
public static WebDriver driver;

	
	@BeforeMethod
	@Parameters({"browser2","url" })
	public void setUp(String browser2, String url) {
		if (browser2.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--Incognito"); 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
		}else if(browser2.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-private");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}else {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--New InPrivate");
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
			
	}
	@Test
	public void searNecklaces() {
		
		driver.findElement(By.xpath("//div[@id='menu_106093']/descendant::a[1]")).click();
		Login.takeAscreenShot(driver.findElement(By.xpath("//div[@class='_1ttGg']/picture")));
		String expected = "Custom Necklaces for Women - MYKA";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual,expected,"The test faile");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
