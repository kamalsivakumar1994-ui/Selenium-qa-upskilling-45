package day11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import day9.LoginPage;

public class LoginTestNG {

	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void validLoginTest() {
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeed with valid credentials");
	}
	
	@Test
	public void invalidLoginTest() {
		loginPage.login("invalid_user", "wrong_pass");
		Assert.assertFalse(loginPage.isLoginSuccessful(),"Expected login to fail with invalid credentials");
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
}
