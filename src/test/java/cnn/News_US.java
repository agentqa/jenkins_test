package cnn;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import working_on_jenkins.Login;

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
		WebElement screenshot = driver.findElement(By.id("maincontent"));
		Login.takeAscreenShot(screenshot);
	}
	
	@Test
	public void searchForWorld() {
		String loc = "//a[@name='world' and @class='sc-fjdhpX sc-chPdSV cfnoGA']";
		driver.findElement(By.xpath(loc)).click();
		WebElement screenshot = driver.findElement(By.id("maincontent"));
		Login.takeAscreenShot(screenshot);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
