package day13;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LifecycleDemo {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("1. @BeforeSuite - runs once,before everything");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("2. @BeforeClass- runs once, before any test in this class");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("3. @BeforeMethod- runs once, before each test");
	}


	@Test(priority = 1)
	public void testOne() {
		System.out.println("   -> @Test priority 1: testOne running");
	}

	@Test(priority = 2)
	public void testTwo() {
		System.out.println("   -> @Test priority 2: testTwo running");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("4. @AfterMethod - runs after EACH test");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("5. @AfterClass - runs once, after all tests in this class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("6. @AfterSuite - runs once, after everything");
	}
}