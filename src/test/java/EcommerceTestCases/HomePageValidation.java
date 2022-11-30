package EcommerceTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommercePageobjects.HomePage;
import resources.ECBase;

public class HomePageValidation extends ECBase {

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}
	
	@Test()

	public void  HomePageCheck() {
		HomePage ech =new HomePage(driver);
		ech.EHomePage();
		
	
	}
	
	@AfterTest

	public void tearDown() {
		driver.close();

	}

}
