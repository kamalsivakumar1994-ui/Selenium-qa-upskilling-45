package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		username.sendKeys("standard_user");
		password.sendKeys("wrong_password"); // intentionally wrong, to trigger the error path
		loginButton.click();

		boolean errorDisplayed = driver.findElements(By.xpath("//div[@class='error-message-container error']")).size() > 0;

		if (errorDisplayed) {
			System.out.println("Login FAILED — error message displayed.");
		} else {
			System.out.println("Login SUCCESS — no error found.");
		}

		driver.quit();
	}
}