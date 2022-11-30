package EcommercePageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	
	public Properties signupdata = new Properties();
	
	public WebDriver driver;

	public SignUpPage(WebDriver driver) {

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
	
	
	@FindBy(xpath="//button[normalize-space()='Sign Up']")
	
	WebElement signupButton;



	public void ECSignUpPage() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\JINTO\\eclipse-workspace\\"
				+ "EcommerceMasterFinalProject\\src" + "\\main\\java\\resources\\Signup.properties");
		
		
		signupdata.load(fis);
		
		
		System.out.println(signupdata.getProperty("firstname"));
		
		
		String SfirstName=signupdata.getProperty("firstname");
		
		String SlastName=signupdata.getProperty("lastname");
		
		
		String SuserName=signupdata.getProperty("username");
		
		
		String Spassword=signupdata.getProperty("password");
		
		String Srepassword=signupdata.getProperty("repassword");
		
		String SignEmail=signupdata.getProperty("semail");
		
		
		signUpEntry.click();
		
		signupfirstname.sendKeys(SfirstName);
		
		signuplastname.sendKeys(SlastName);
		
		
		signupusername.sendKeys(SuserName);
		
		
		signuppassword.sendKeys(Spassword);
		
		signuprepassword.sendKeys(Srepassword);
		
		signupemail.sendKeys(SignEmail);
		
		
		signupButton.click();
		
		
		
		
		
	}

}





