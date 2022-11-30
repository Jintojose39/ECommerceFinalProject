package EcommerceErrorCheckTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommerceErrorCheckPageObjects.SignUpPageErrorMsg1;
import EcommercePageobjects.SignUpPage;
import resources.ECBase;

public class SignupPageErrorMessgeValidation1 extends ECBase {

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test

	public void SignUpCheck() throws IOException {

		// Sign up page =SP

		SignUpPageErrorMsg1 sp = new SignUpPageErrorMsg1(driver);

		sp.ECSignUpPage();

	}

	@AfterTest

	public void tearDown() {
		driver.close();

	}
}