package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import day9.LoginPage;

public class DataProviderLoginTest {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
			{"standard_user", "secret_sauce", true},
			{"invalid_user", "wrong_pass", false},
			{"", "", false}
		};
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password, boolean expectedResult) {
		loginPage.login(username, password);
		boolean actualResult = loginPage.isLoginSuccessful();

		Assert.assertEquals(actualResult, expectedResult,
				"Login result mismatch for username: '" + username + "'");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}