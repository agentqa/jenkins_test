package working_on_jenkins;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;



public class Login {
	
	public static WebDriver driver;

	
	@BeforeMethod
	@Parameters({"browser","url" })
	public void setUp(String browser, String url) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--Incognito"); 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
		}else if(browser.equals("firefox")) {
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
		takeAscreenShot(driver.findElement(By.xpath("//div[@class='_1ttGg']/picture")));
		String expected = "Custom Necklaces for Women - MYKA";
		String actual = driver.getTitle();
		
		Assert.assertEquals(actual,expected,"The test faile");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public static void takeAscreenShot(WebElement screenshot) {
		double name = Math.random();
//		WebElement screenshot = driver.findElement(By.xpath("//div[@class='section where-to']"));
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File distiantion = new File(System.getProperty("user.dir")+"\\screenshots\\screen"+name+".png");
		try {
			FileHandler.copy(source, distiantion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
