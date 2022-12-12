package TestingClasses;

import org.testng.annotations.Test;

import PageObjects.HomePageObject;

import org.testng.Assert;

public class HomePageTests extends ProjectEulerTestBase {
	
	@Test
	public void canNavigateToHomePageTest() {
		String expectedUrl = "https://projecteuler.net/";
		
		String currentUrl = 
				new HomePageObject(this.getDriver(), this.getBaseUrl())
				.navigate()
				.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, expectedUrl, "Wrong URL.");
	}
	
	@Test
	public void canLookupSpecificProblemByNumber() {
		String expectedUrl = "https://projecteuler.net/archives";
		
		String currentUrl = 
				new HomePageObject(this.getDriver(), this.getBaseUrl())
				.navigate()
				.goToArchivePage()
				.getCurrentUrl();
		//TODO: Make an ArchivePageObject and implement looking up problem by number
		
		Assert.assertEquals(currentUrl, expectedUrl, "Wrong URL.");
	}
}