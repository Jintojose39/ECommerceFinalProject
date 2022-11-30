package EcommerceTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommercePageobjects.OrderHistoryPage;
import resources.ECBase;

public class OrderHistoryPageValidation extends ECBase {

	public WebDriver driver;

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);
	}

	@Test(priority = 1)

	public void signIn() throws IOException {
		SignInPageValidation spv = new SignInPageValidation();
		spv.signInCheck("Jinto@159", "Password@159");
	}

	@Test(priority = 2)

	public void orderHistoryCheck() {
		OrderHistoryPage ohp = new OrderHistoryPage(driver);
		ohp.EcorderHistory();
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
