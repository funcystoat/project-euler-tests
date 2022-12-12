package PageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import TestingClasses.Helpers;

public abstract class PageObjectBase {
	private WebDriver driver;
	private String baseUrl;

	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;

		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	protected void activateNewTab() {
		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastElement(handles);

		getDriver().switchTo().window(lastHandle);			
	}

	protected void navigate(String url) {
		String fullUrl = this.getBaseUrl() + url;
		this.getDriver().navigate().to(fullUrl);		
	}
}