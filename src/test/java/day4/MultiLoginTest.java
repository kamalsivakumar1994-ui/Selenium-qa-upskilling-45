package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiLoginTest {

	public static void main(String[] args) {
		String[] usernames = {"standard_user","invalid_user",""};
		String[] passwords = {"secret_sauce", "wrong_pass", ""};
		
		for (int i = 0; i < usernames.length; i++) {

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");

			WebElement username = driver.findElement(By.id("user-name"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));
			
			username.sendKeys(usernames[i]);
			password.sendKeys(passwords[i]);
			loginButton.click();
			
			boolean errorDisplayed = driver.findElements(By.xpath("//div[@class='error-message-container error']")).size() > 0;
			
			if (errorDisplayed) {
				System.out.println("Scenario " + (i + 1) + " (" + usernames[i] + " / " + passwords[i] + "): Login FAILED");
			} else {
				System.out.println("Scenario " + (i + 1) + " (" + usernames[i] + " / " + passwords[i] + "): Login SUCCESS");
			}

			driver.quit();
		}
	}
}