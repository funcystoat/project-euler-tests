package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObject extends PageObjectBase {
	
	@FindBy(how=How.CSS, using="[href='archives']")
	WebElement archiveButton;
	
	public HomePageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePageObject navigate() {
		getDriver().navigate().to(getBaseUrl());

		return this;
	}
	
	public ArchivePageObject goToArchivePage() {
		this.archiveButton.click();
		
		return new ArchivePageObject(getDriver(), getBaseUrl());
	}
}