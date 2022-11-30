package EcommerceErrorCheckTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommerceErrorCheckPageObjects.SignUpPageErrorMsg1;
import EcommerceErrorCheckPageObjects.SignUpPageErrorMsg2;
import EcommercePageobjects.SignUpPage;
import resources.ECBase;

public class SignupPageErrorMessgeValidation2 extends ECBase {
	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test

	public void SignUpCheck() throws IOException {

		// Sign up page =SP

		SignUpPageErrorMsg2 sp = new SignUpPageErrorMsg2(driver);
		
		sp.ECSignUpPage();
		String expName="JINTOLKJHGFDGHJKYLHGFGFDHJFGH"
				+ "JDFGJDFGHJFGHJGHJGHJGFJFGHJFGH"
				+ "FGHJFGHJFGHJFGGHJFGJFGHJFGHJGFHJHGFJGFHJ";
		
		String actName=driver.findElement(By.xpath("//body/nav[1]/div[1]/ul[1]/li[4]/a[1]")).getText();
		
		Assert.assertEquals(actName,expName);
		
		System.out.println(actName);
			
	}

	@AfterTest

	public void tearDown() {
		driver.close();

	}
}