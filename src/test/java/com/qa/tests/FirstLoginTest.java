package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstLoginTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();   // create the "car" — a Chrome browser object

        driver.get("https://www.saucedemo.com"); // tell it: go to this URL

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit(); // close the browser cleanly
    }
}