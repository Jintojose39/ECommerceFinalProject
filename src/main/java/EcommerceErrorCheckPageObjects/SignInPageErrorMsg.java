package EcommerceErrorCheckPageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SignInPageErrorMsg {

	public Properties signuperrordata = new Properties();

	public WebDriver driver;

	public SignInPageErrorMsg(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Sign In']")

	WebElement signInEntry;

	@FindBy(xpath = "//input[@id='id_username']")

	WebElement signInUsername;

	@FindBy(xpath = "//input[@id='id_password']")

	WebElement signInPassword;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")

	WebElement signInButton;

	public void ECSignInPage() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceMasterFinalProject\\src\\main\\java\\resourcesError\\signInErrordata.properties");

		signuperrordata.load(fis);

		String invalidusername = signuperrordata.getProperty("username");
		String invalidpassword = signuperrordata.getProperty("password");

		System.out.println(signuperrordata.getProperty("username"));
		System.out.println(signuperrordata.getProperty("password"));

		signInEntry.click();
		signInUsername.sendKeys(invalidusername);
		signInPassword.sendKeys(invalidpassword);
		signInButton.click();

	}

}
