package EcommerceTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommercePageobjects.SignUpPage;
import resources.ECBase;

public class SignupPageValidation extends ECBase {

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test

	public void SignUpCheck() throws IOException {

		// Sign up page =SP

		SignUpPage sp = new SignUpPage(driver);

		sp.ECSignUpPage();

		String confirmationmsg = driver
				.findElement(By.xpath("//h1[normalize-space()='Your account has been " + "successfully created']"))
				.getText();
		
		System.out.println(confirmationmsg);
		String expmsg = "YOUR ACCOUNT HAS BEEN SUCCESSFULLY CREATED";
		Assert.assertEquals(confirmationmsg, expmsg);
	}

	@AfterTest

	public void tearDown() {
		driver.close();

	}
}