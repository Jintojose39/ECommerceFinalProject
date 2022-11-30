package EcommercePageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage {


	public WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//*[@id=\"nav\"]/ul/li[4]/a")
	WebElement welcomeButton;
	
	

	@FindBy(xpath="//a[normalize-space()='Order History']")
	
	WebElement orderButton;

	
	@FindBy(xpath="//div[@class='text-center']//p[1]")
	WebElement orderMsg;

	public void EcorderHistory() {
		
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav\"]/ul/li[4]/a")));
		
		welcomeButton.click();
		
		orderButton.click();
		
		String ordermsg=orderMsg.getText();
		
		System.out.println("Order Message is"+":"+ordermsg);
		
		
	}


}

