package page.objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ArchivePageObject extends PageObjectBase {
	
	@FindBy(how=How.CSS, using=".jump_to")
	WebElement goToProblemTextbox;
	
	@FindBy(how=How.CSS, using="#problems_table_page p")
	WebElement problemsTablePageDescription;
	
	static final String urlExtension = "/archives";
	
	public ArchivePageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl + urlExtension);
	}

	public String goToProblem(String problemNumber) {
		goToProblemTextbox.sendKeys(problemNumber);
		goToProblemTextbox.sendKeys(Keys.RETURN);
		
		return this.getCurrentUrl();
	}
	
	public void clearProblemTextbox() {
		goToProblemTextbox.clear();
	}
	
	public String getNumberOfProblems() {
		String numberOfProblems = problemsTablePageDescription.getText();
		
		Pattern p = Pattern.compile("to \\d+");
		Matcher m = p.matcher(numberOfProblems);
		
		// The value we want starts at index 3 of the above REGEX
		while(m.find()) 
			numberOfProblems = m.group().substring(3);

		return numberOfProblems;
	}
}