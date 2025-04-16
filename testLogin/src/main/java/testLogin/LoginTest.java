package testLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\svish\\OneDrive\\Desktop\\java-stuff\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://localhost:3000");
//		
		
	}
	@Test
	public void testLogin() {
		driver.get("http://localhost:3000");
		driver.findElement(By.id("username")).sendKeys("sujeet@123");
		driver.findElement(By.id("password")).sendKeys("sujeet@123");
		driver.findElement(By.id("loginBtn")).click();
		
		String expectedUrl = "http://localhost:3000/home";
		String currentUrl = driver.getCurrentUrl();
		assert currentUrl.equals(expectedUrl) : "Error Login! Expected " + expectedUrl +" But got : "+currentUrl;
	}
	@AfterClass
	public void tearDown() {
		driver.quite();
	}
}
