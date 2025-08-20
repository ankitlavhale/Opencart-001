package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@AfterClass
	public void teatdown() {
		driver.quit();
	}
	public String randomString() {
		String stringgenrated = RandomStringUtils.randomAlphabetic(5);
		return stringgenrated;
	}
	public String randomNumeber() {
		String Numbergenrated = RandomStringUtils.randomNumeric(10);
		return Numbergenrated;
	}
	public String randomAlpha() {
		String stringgenrated = RandomStringUtils.randomAlphabetic(4);
		String Numbergenrated = RandomStringUtils.randomNumeric(4);
		return (stringgenrated+"@"+Numbergenrated);
	}

}
