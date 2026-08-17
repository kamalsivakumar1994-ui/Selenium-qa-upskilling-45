package day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import day9.LoginPage;

public class SoftAssertTest {
	
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
		
	}
	
	@Test
	public void dashboardChecksWithSoftAssert() {
		loginPage.login("standard_user", "secret_sauce");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(loginPage.isLoginSuccessful(), "Login should succeed");
		softAssert.assertEquals(driver.getTitle(),"Swag Labs", "Title should be Swag Labs");
		softAssert.assertTrue(driver.getCurrentUrl().contains("inventory"), "URL should contain 'inventory'");
		
		softAssert.assertEquals(driver.getTitle(), "Wrong Title On Purpose", "This check is deliberately wrong");

		softAssert.assertAll();
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
