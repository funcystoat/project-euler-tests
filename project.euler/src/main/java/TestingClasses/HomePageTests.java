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
}