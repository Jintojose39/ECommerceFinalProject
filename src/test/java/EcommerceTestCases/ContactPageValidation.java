package EcommerceTestCases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import EcommercePageobjects.ContactPage;
import resources.ECBase;

public class ContactPageValidation extends ECBase {

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test

	public void ContactPageCheck() throws IOException {

		ContactPage cp = new ContactPage(driver);
		cp.EcContactPage();
	}

	@AfterTest

	public void tearDown() {
		driver.close();

	}

}
