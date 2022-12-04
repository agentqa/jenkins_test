package working_on_jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	
	public static WebDriver driver;
	
	@Test
	public void login() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://google.com");
		Thread.sleep(2000);
	}
	

}
