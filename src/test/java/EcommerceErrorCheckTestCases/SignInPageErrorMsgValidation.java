package EcommerceErrorCheckTestCases;

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

import EcommerceErrorCheckPageObjects.SignInPageErrorMsg;
import EcommercePageobjects.SignInPage;

import resources.ECBase;

public class SignInPageErrorMsgValidation extends ECBase {


	@BeforeTest
	public void Intialize() throws IOException {
		driver = IntilializeDriver();
		String URL = OR.getProperty("url");
		driver.get(URL);

	}

	@Test()
	public void signInCheck() throws IOException {

		SignInPageErrorMsg signEr = new SignInPageErrorMsg(driver);

		signEr.ECSignInPage();

		String checkExp="Please enter a correct username and password."
				+ " Note that both fields may be case-sensitive.";
		String checkAct=driver.findElement(By.xpath("//ul[@class='m-0']")).getText();
		
		System.out.println("Validated Error Message is"+":"+checkAct);
		
		Assert.assertEquals(checkAct, checkExp);
	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
