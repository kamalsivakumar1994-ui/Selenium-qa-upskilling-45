package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// Locators — private, encapsulated, hidden from anything outside this class
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.xpath("//h3[@data-test='error']");

	// Constructor — runs when a LoginPage object is created
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	public boolean isLoginSuccessful() {
		boolean errorDisplayed = driver.findElements(errorMessage).size() > 0;
		return !errorDisplayed;
	}
}