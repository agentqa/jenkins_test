package cnn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class News_US {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--Incognito");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.cnn.com/");

	}
	
	@Test
	public void searchForUS() {
		String loc = "//a[@name='us' and @class='sc-fjdhpX sc-chPdSV cfnoGA']";
		driver.findElement(By.xpath(loc)).click();
	}
	
	@Test
	public void searchForWorld() {
		String loc = "//a[@name='world' and @class='sc-fjdhpX sc-chPdSV cfnoGA']";
		driver.findElement(By.xpath(loc)).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
