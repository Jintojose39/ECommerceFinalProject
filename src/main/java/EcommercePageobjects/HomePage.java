package EcommercePageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".fas.fa-store.text-warning.fa-2x")

	WebElement companyLogo;

	@FindBy(xpath = " //p[@class='lead text-center']")

	WebElement copyrightMessage;

	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	WebElement catlogo;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")

	WebElement contactOpt;

	@FindBy(xpath = "//a[contains(text(),'About')]")

	WebElement aboutOption;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")

	WebElement SignUp;

	@FindBy(xpath = "//a[normalize-space()='Sign In']")

	WebElement SignIn;

	@FindBy(xpath = "//input[@placeholder='Search']")

	WebElement searchButton;

	@FindBy(xpath = "//h1[normalize-space()='All Products']")

	WebElement allProductsBanner;

	@FindBy(xpath = "//img[@alt='Galaxy A30']")
	WebElement productImage;

	public void EHomePage() {

		boolean clogo = companyLogo.isDisplayed();

		System.out.println(clogo);

		System.out.println("Company logo is Displayed in the Home Page" + ":" + clogo);

		String expectedmsg = "Copyright © 2019 E-Commerce";

		String cmessage = copyrightMessage.getText();

		System.out.println(cmessage.equals(expectedmsg));

		System.out.println("CopyRight Message presented in the Home Page" + ":" + cmessage);
		boolean categoryLogo = catlogo.isDisplayed();
		System.out.println("Categories is presented" + ":" + categoryLogo);

		boolean contactOption = contactOpt.isDisplayed();

		System.out.println("Contact Option is presented in Home Page" + ":" + contactOption);

		boolean about = aboutOption.isDisplayed();

		System.out.println("About Option is presented in the Home Page" + ":" + about);

		boolean signup = SignUp.isDisplayed();

		System.out.println("Sign up is Presented in the Home Page" + ":" + signup);

		boolean signin = SignIn.isDisplayed();

		System.out.println("Sign in is Presented in the Home Page" + ":" + signin);

		boolean search = searchButton.isEnabled();

		System.out.println("Search button is Presented in the Home Page" + ":" + searchButton);

		boolean allProducts = allProductsBanner.isDisplayed();

		System.out.println("All Products banner is Presented in the Home Page" + ":" + allProducts);

		boolean productDisplay = productImage.isDisplayed();

		System.out.println("Product is presented on the HomePage" + ":" + productDisplay);

	}

}
