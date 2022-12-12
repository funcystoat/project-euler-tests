package PageObjects;

import org.openqa.selenium.WebDriver;

public class HomePageObject extends PageObjectBase {
	
	public HomePageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePageObject navigate() {
		getDriver().navigate().to(getBaseUrl());	

		return this;
	}
}