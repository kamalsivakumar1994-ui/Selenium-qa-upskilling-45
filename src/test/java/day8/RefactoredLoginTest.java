package day8;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefactoredLoginTest {

	public static void main(String[] args) {

		List<String[]> credentials = new ArrayList<>();
		credentials.add(new String[]{"standard_user", "secret_sauce"});
		credentials.add(new String[]{"invalid_user", "wrong_pass"});
		credentials.add(new String[]{"", ""});

		for (int i = 0; i < credentials.size(); i++) {

			String username = credentials.get(i)[0];
			String password = credentials.get(i)[1];

			WebDriver driver = new ChromeDriver();

			try {
				driver.get("https://www.saucedemo.com/");
				
				
				login(driver, username, password);
			

				boolean success = verifyDashboard(driver);
				if (success) {
					System.out.println("Scenario " + (i + 1) + " (" + username + " / " + password + "): Login SUCCESS");
				} else {
					System.out.println("Scenario " + (i + 1) + " (" + username + " / " + password + "): Login FAILED");
				}

			} catch (NoSuchElementException e) {
				System.out.println("Scenario " + (i + 1) + ": ERROR - required element not found. " + e.getMessage());
			} finally {
				driver.quit();
			}
		}

		System.out.println("All scenarios completed — script finished without crashing.");
	}
		
		public static void login(WebDriver driver, String username, String password) {
			WebElement usernameField = driver.findElement(By.id("user-name"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));

			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			loginButton.click();
		}
		public static boolean verifyDashboard(WebDriver driver) {
			boolean errorDisplayed = driver.findElements(By.xpath("//h3[@data-test='error']")).size() > 0;
			return !errorDisplayed;
		}
		
}