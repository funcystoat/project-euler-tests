package TestingClasses;

import org.testng.annotations.Test;

import PageObjects.ArchivePageObject;
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
		String problemNumber = "43";
		String expectedUrl = "https://projecteuler.net/problem=" + problemNumber;
		
		String currentUrl = 
				new HomePageObject(this.getDriver(), this.getBaseUrl())
				.navigate()
				.goToArchivePage()
				.goToProblem(problemNumber);
		
		Assert.assertEquals(currentUrl, expectedUrl, "Wrong URL.");
	}
	
	
	@Test
	public void canLookupAllProblemsByNumber() {
		ArchivePageObject archivePage 
			= new HomePageObject(this.getDriver(), this.getBaseUrl())
				.navigate()
				.goToArchivePage();

		Integer reps = Integer.parseInt(archivePage.getNumberOfProblems());
		
		for (int i = 1; i < reps; i++) {
			String problemNumber = "" + i;
			String expectedUrl = "https://projecteuler.net/problem=" + problemNumber;

			String currentUrl = 
					archivePage
					.goToProblem(problemNumber);

			Assert.assertEquals(currentUrl, expectedUrl, "Wrong URL.");
			
			this.driver.navigate().back();
			archivePage.clearProblemTextbox();
		}
	}
	
	
}