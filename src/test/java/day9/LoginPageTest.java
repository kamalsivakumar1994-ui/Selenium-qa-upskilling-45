package day9;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

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

				LoginPage loginPage = new LoginPage(driver);
				loginPage.login(username, password);

				boolean success = loginPage.isLoginSuccessful();

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
}