package EcommerceTestCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommercePageobjects.ReviewPage;
import resources.ECBase;

public class ReviewPageValidation extends ECBase {

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);
	}

	@Test(priority=1)
	
	public void signIn() throws IOException {
		SignInPageValidation spv=new SignInPageValidation();
		
		spv.signInCheck("Jinto@159","Password@159");
	}
	
	@Test(priority=2)
	public void ECReviewCheck() throws IOException, InterruptedException {

		ReviewPage rwp = new ReviewPage(driver);

		rwp.ECReviewPage();

	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
