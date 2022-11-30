package EcommercePageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public Properties contactdata = new Properties();

	public WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='Contact']")

	WebElement contactButton;

	@FindBy(xpath = "//input[@id='id_name']")
	WebElement contactName;

	@FindBy(xpath = "//input[@id='id_from_email']")
	WebElement contactEmail;

	@FindBy(xpath = "//input[@id='id_subject']")

	WebElement contactSubject;

	@FindBy(xpath = "//textarea[@id='id_message']")
	WebElement contactMessage;

	@FindBy(xpath = "//button[normalize-space()='Submit']")

	WebElement contactSubmit;

	public void EcContactPage() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\JINTO\\eclipse-workspace\\"
				+ "EcommerceMasterFinalProject\\src" + "\\main\\java\\resources\\Contact.properties");

		contactdata.load(fis);

		System.out.println(contactdata.getProperty("cyourname"));

		String Yourname = contactdata.getProperty("cyourname");

		String YourEmail = contactdata.getProperty("cyouremail");

		String YourSubject = contactdata.getProperty("cyoursubject");

		String YourMessage = contactdata.getProperty("cmessages");

		contactButton.click();

		contactName.sendKeys(Yourname);

		contactEmail.sendKeys(YourEmail);

		contactSubject.sendKeys(YourSubject);

		contactMessage.sendKeys(YourMessage);

		contactSubmit.click();
		
	}

}
