package calculator;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class CalculatorTests {
	WebDriver driver;
	ChromeOptions options;
	Locators locators ;
	Utilities utilities;
	
	@BeforeClass
	public void initialize() {
		utilities= new Utilities();
		locators = new Locators(driver);
		
	}
	
	@BeforeTest
	public void initDriver() {
		
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		
		options = new ChromeOptions();
		
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable notifications");
		
		driver = new ChromeDriver(options);
		driver.get("https://nuix.github.io/SDET/senior-sdet/stagingCalc/index.html");

	}

	@Test
	public void testcalculator_Load() {
		
		
		locators.verifyTitle();
	}
	@Test
	public void testcalculator_AdditionBasic() {

		
		int value = Integer.parseInt(utilities.operation(locators.Two, locators.Four,locators.Add,locators.equalsTo,locators.result));
		
		assertEquals(6, value);
	}
	
	
	

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
