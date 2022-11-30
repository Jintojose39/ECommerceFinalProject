package EcommercePageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SignInPage{
	
	
	
	
	public WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Sign In']")
	
	WebElement signInEntry;
	/*
	@FindBy(xpath="//input[@id='id_username']")
	WebElement  signInusername;
	
	@FindBy(xpath="//input[@id='id_password']")
	
	
	WebElement signInpassword;
*/
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")

	WebElement signInButton;
	
	public void ECSignInPage() throws IOException {
		
		signInEntry.click();
		
		
				
		}

	}

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	


