package EcommercePageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

	public Properties ReviewData = new Properties();
	public WebDriver driver;

	public ReviewPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@alt='Galaxy A30']")

	WebElement productImage;

	@FindBy(xpath = "//textarea[@name='content']")

	WebElement reviewtab;

	@FindBy(xpath = "//button[normalize-space()='Post']")

	WebElement postreview;

	public void ECReviewPage() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("C:\\Users\\JINTO\\eclipse-workspace\\"
				+ "EcommerceMasterFinalProject\\src" + "\\main\\java\\resources\\reviewdata.properties");

		ReviewData.load(fis);
		System.out.println(ReviewData.getProperty("review"));

		productImage.click();

		String Review = ReviewData.getProperty("review");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(3000);

		reviewtab.sendKeys(Review);

		postreview.click();

	}

}
