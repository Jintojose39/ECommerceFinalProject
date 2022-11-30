package EcommercePageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	public Properties paymentdata = new Properties();
	public WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Galaxy A30']")

	WebElement productClick;

	@FindBy(xpath = "//button[normalize-space()='Add to Cart']")

	WebElement addToCart;

	@FindBy(xpath = "//span[normalize-space()='Pay with Card']")

	WebElement payTocard;

	@FindBy(xpath = "//iframe[@name='stripe_checkout_app']")

	WebElement cartFrame;

	@FindBy(xpath = "//*[@id=\"email\"]")

	WebElement cartEmail;

	@FindBy(xpath = "//*[@id=\"shipping-name\"]")

	WebElement cartName;

	@FindBy(xpath = "//*[@id=\"shipping-street\"]")

	WebElement cartAddress;

	@FindBy(xpath = "//*[@id=\"shipping-zip\"]")

	WebElement cartPostcode;

	@FindBy(xpath = "//*[@id=\"submitButton\"]/span/span")

	WebElement cartPayment;

	@FindBy(xpath = "//input[@id='card_number']")

	WebElement cardNumber;

	@FindBy(xpath = "/input[@id='cc-exp']")
	WebElement cardExpiry;

	@FindBy(xpath = "//input[@id='cc-csc']")
	WebElement cardCvc;

	@FindBy(css = "#submitButton > span > span")

	WebElement FinalPayment;

	public void ECcartPage() throws IOException {

		productClick.click();
		addToCart.click();
		payTocard.click();

		driver.switchTo().frame(cartFrame);

		FileInputStream fis = new FileInputStream("C:\\Users\\JINTO\\eclipse-workspace\\"
				+ "EcommerceMasterFinalProject\\src" + "\\main\\java\\resources\\Paymentdata.properties");

		paymentdata.load(fis);

		System.out.println("Email is is" + ":" + paymentdata.getProperty("cartemail"));

		String email = paymentdata.getProperty("cartemail");
		String name = paymentdata.getProperty("cartname");
		String address = paymentdata.getProperty("cartaddress");
		String postalcode = paymentdata.getProperty("cartpostalcode");

		String cardnumber = paymentdata.getProperty("cardnumber");
		String month = paymentdata.getProperty("month");
		String cvc = paymentdata.getProperty("cvc");

		cartEmail.sendKeys(email);
		cartName.sendKeys(name);
		cartAddress.sendKeys(address);
		cartPostcode.sendKeys(postalcode);

		driver.findElement(By.xpath("//input[@id='shipping-city']")).sendKeys("Vezhapra");
		cartPayment.click();

		String cardNum = "4242 4242 4242 4242";
		WebElement inputField = driver.findElement(By.xpath("//input[@id='card_number']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[1].value = arguments[0]; ", cardNum, inputField);

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cc-exp']")));

		driver.findElement(By.xpath("//input[@id='cc-exp']")).sendKeys("04");
		driver.findElement(By.xpath("//input[@id='cc-exp']")).sendKeys("32");

		cardCvc.sendKeys(cvc);

		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#submitButton > span > span")));
		
		FinalPayment.click();

		driver.switchTo().defaultContent();

	}

}
