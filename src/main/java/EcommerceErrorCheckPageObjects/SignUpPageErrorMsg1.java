package EcommerceErrorCheckPageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageErrorMsg1 {

	public Properties signuperrordata = new Properties();

	public WebDriver driver;

	public SignUpPageErrorMsg1(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")

	WebElement signUpEntry;

	@FindBy(xpath = "//input[@id='id_first_name']")

	WebElement signupfirstname;

	@FindBy(xpath = "//input[@id='id_last_name']")

	WebElement signuplastname;

	@FindBy(xpath = "//input[@id='id_username']")

	WebElement signupusername;

	@FindBy(xpath = "//input[@id='id_password1']")

	WebElement signuppassword;

	@FindBy(xpath = "//input[@id='id_password2']")

	WebElement signuprepassword;

	@FindBy(css = "#id_email")

	WebElement signupemail;

	@FindBy(xpath = "//button[normalize-space()='Sign Up']")

	WebElement signupButton;

	public void ECSignUpPage() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceMasterFinalProject\\src\\main\\java\\resourcesError\\signUpErrordata1.properties");

		signuperrordata.load(fis);

		System.out.println(signuperrordata.getProperty("firstname"));

		String SfirstName = signuperrordata.getProperty("firstname");

		String SlastName = signuperrordata.getProperty("lastname");

		String SuserName = signuperrordata.getProperty("username");

		String Spassword = signuperrordata.getProperty("password");

		String Srepassword = signuperrordata.getProperty("repassword");

		String SignEmail = signuperrordata.getProperty("semail");

		signUpEntry.click();
		signupfirstname.sendKeys(SfirstName);
		signuplastname.sendKeys(SlastName);
		signupusername.sendKeys(SuserName);
		signuppassword.sendKeys(Spassword);
		signuprepassword.sendKeys(Srepassword);
		
		
		signupemail.sendKeys(SignEmail);
		signupButton.click();

		
		
		/*String passwordCommon = driver
				.findElement(By.xpath("//strong[normalize-space()='This password is too common.']")).getText();
		boolean passwordcommon =driver
				.findElement(By.xpath("//strong[normalize-space()=" + "'This password is too common.']")).isDisplayed();
*/
		boolean passwordnumeric = driver
				.findElement(By.xpath("//strong[normalize-space()='This password is entirely numeric.']"))
				.isDisplayed();
		
		
		/*String passwordCommon = driver
				.findElement(By.xpath("//strong[normalize-space()='This password is too common.']")).getText();
		boolean passwordcommon =driver
				.findElement(By.xpath("//strong[normalize-space()=" + "'This password is too common.']")).isDisplayed();
		
		*/

		if (passwordnumeric == true) {

			String passwordNumeric = driver
					.findElement(By.xpath("//strong[normalize-space()='This password is entirely numeric.']")).getText();
			System.out.println("Error Message is" + ":" + passwordNumeric);
			System.out.println("Error Message is displayed"+":"+passwordnumeric);			
			
		}
	
		}
		
		
	
	
	
	

}
