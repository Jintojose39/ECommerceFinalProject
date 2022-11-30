package EcommerceTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import EcommercePageobjects.CartPage;
import EcommercePageobjects.OrderHistoryPage;
import resources.ECBase;

public class EndFlowEcommerce extends ECBase {

	public WebDriver driver;

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);
	}

	@Test(priority = 1)

	public void homePage() {

		HomePageValidation hmpv = new HomePageValidation();
		hmpv.HomePageCheck();
	}

	@Test(priority = 2)

	public void signIn() throws IOException {
		SignInPageValidation spv = new SignInPageValidation();
		spv.signInCheck("Jinto@159", "Password@159");
	}

	@Test(priority = 3)

	public void cartCheck() throws IOException, InterruptedException {

		CartPage cp = new CartPage(driver);
		cp.ECcartPage();
		String cartexpmsg = "THANKS FOR PLACING YOUR ORDER";
		System.out.println("Expected Message" + ":" + cartexpmsg);
		String cartactmsg = driver.findElement(By.xpath("//h1[normalize-space()='Thanks for placing your order']"))
				.getText();
		System.out.println("Actual Message" + ":" + cartactmsg);
		Assert.assertEquals(cartactmsg, cartexpmsg);
		String orderidmsg = driver.findElement(By.xpath("//div[@class='text-center']//p[1]")).getText();
		System.out.println("Order id Message" + ":" + orderidmsg);

	}

	@Test(priority = 4)
	public void OrderHistory() {
		OrderHistoryPage order = new OrderHistoryPage(driver);
		order.EcorderHistory();

	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}