package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	WebDriver driver;
	@BeforeTest
	public void setupcode() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void LaunchurL() {
		driver.get("https://www.facebook.com");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 2)
	public void CreatingLoginPage() {
		driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//*[@name=\"firstname\"]")).sendKeys("sanju");
		driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys("maladinni");
		driver.findElement(By.xpath("aria-label=\"Mobile number or email address\"")).sendKeys("8867216951");
		driver.findElement(By.xpath("//*[@aria-label=\"Mobile number or email address\"]")).sendKeys("sanju@9343");

	}
}
