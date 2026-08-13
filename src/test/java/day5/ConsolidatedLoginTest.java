package day5;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsolidatedLoginTest {

	public static void main(String[] args) {

		List<String[]> credentials = new ArrayList<>();
		credentials.add(new String[]{"standard_user", "secret_sauce"});
		credentials.add(new String[]{"invalid_user", "wrong_pass"});
		credentials.add(new String[]{"", ""});

		for (int i = 0; i < credentials.size(); i++) {

			String username = credentials.get(i)[0];
			String password = credentials.get(i)[1];

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");

			WebElement usernameField = driver.findElement(By.id("user-name"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));

			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			loginButton.click();

			boolean errorDisplayed = driver.findElements(By.xpath("//h3[@data-test='error']")).size() > 0;

			if (errorDisplayed) {
				System.out.println("Scenario " + (i + 1) + " (" + username + " / " + password + "): Login FAILED");
			} else {
				System.out.println("Scenario " + (i + 1) + " (" + username + " / " + password + "): Login SUCCESS");
			}

			driver.quit();
		}
	}
}