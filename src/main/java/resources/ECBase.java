package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECBase {

	public static WebDriver driver;

	public Properties Config = new Properties();

	public Properties OR = new Properties();

	public WebDriver IntilializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceMasterFinalProject\\src\\main\\java\\resources\\Config.properties");

		Config.load(fis);
		// String BrowserName = prop.getProperty("browser");

		String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: Config.getProperty("browser");

		fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceMasterFinalProject\\src\\main\\java\\resources\\OR.properties");

		OR.load(fis);

		String URL = OR.getProperty("url");

		if (BrowserName.contains("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			WebDriverManager.firefoxdriver().setup();
			WebDriverManager.edgedriver().setup();

			if (BrowserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxOptions foptions = new FirefoxOptions();
			driver = new FirefoxDriver(foptions);
			driver.manage().window().maximize();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			EdgeOptions eoptions = new EdgeOptions();
			driver = new EdgeDriver(eoptions);
			driver.manage().window().maximize();
		}

		else {
			System.out.println("Browser not Found ,Make sure that browser is added");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	public void getScreenShotPath() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		Date currentdate = new Date();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotfileName = currentdate.toString().replace(" ", "-").replace(":", "-");

		FileUtils.copyFile(source, new File(".//Screenshots//" + screenShotfileName + ".png"));

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

	}
}
