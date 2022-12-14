package testing.testing_classes;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class SeleniumTestBase {
	protected WebDriver driver;
	protected String baseUrl;
	
	public SeleniumTestBase(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@BeforeTest
	protected void setup() {
		WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	
    	options.addArguments("start-maximized"); 
    	options.addArguments("enable-automation"); 
    	options.addArguments("--no-sandbox"); 
    	options.addArguments("--disable-infobars");
    	options.addArguments("--disable-dev-shm-usage");
    	options.addArguments("--disable-browser-side-navigation"); 
    	options.addArguments("--disable-gpu"); 
		
		this.driver = new ChromeDriver(options);
		this.getDriver().manage().window().maximize();
		this.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}

	@AfterTest
	protected void cleanup() {
		this.getDriver().quit();
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}
}