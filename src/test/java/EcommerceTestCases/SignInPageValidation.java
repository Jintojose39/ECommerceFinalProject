package EcommerceTestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommercePageobjects.SignInPage;

import resources.ECBase;

public class SignInPageValidation extends ECBase {

	DataFormatter formatter = new DataFormatter();

	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test(dataProvider = "driveTest")
	public void signInCheck(String username, String password) throws IOException {

		SignInPage signP = new SignInPage(driver);

		signP.ECSignInPage();

		System.out.println(username + password);

		System.out.println("Username" + ":" + username);
		System.out.println("Password" + ":" + password);

		driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

		boolean usercheck = driver.findElement(By.xpath("//i[@class='fas fa-user circle']")).isDisplayed();

		Assert.assertTrue(usercheck);

		System.out.println(usercheck);
	}

	@DataProvider(name = "driveTest")

	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\JINTO\\eclipse-workspace\\EcommerceMasterFinalProject"
				+ "\\src\\main\\java\\resources\\signindata.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();

		XSSFRow row = sheet.getRow(0);

		int coloumnCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][coloumnCount];

		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < coloumnCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;

	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
