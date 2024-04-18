package calculator;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
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
	public void testNumberButtonsDisplay() {
		locators.clearResult();
		locators.One.click();
		assertEquals(locators.getResult(), 1);
		locators.clearResult();
		locators.Two.click();
		assertEquals(locators.getResult(), 2);
		locators.clearResult();
		locators.Three.click();
		assertEquals(locators.getResult(), 3);
		locators.clearResult();
		locators.Four.click();
		assertEquals(locators.getResult(), 4);
		locators.clearResult();
		locators.Five.click();
		assertEquals(locators.getResult(), 5);
		locators.clearResult();
		locators.Six.click();
		assertEquals(locators.getResult(), 6);
		locators.clearResult();
		locators.Seven.click();
		assertEquals(locators.getResult(), 7);
		locators.clearResult();
		locators.Eight.click();
		assertEquals(locators.getResult(), 8);
		locators.clearResult();
		locators.Nine.click();
		assertEquals(locators.getResult(), 9);
		locators.clearResult();
		
	}
	
	
	@Test
	public void testcalculator_Add() {
		locators.clearResult();
		//perform operation
		int value = Integer.parseInt(utilities.basicOperation(locators.Two, locators.Four,locators.Add,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		//Assert the result
		assertEquals(value,6);
		
	}
	
	public void testcalculator_AddFloat() {
		locators.clearResult();
		locators.Eight.click();
		locators.Eight.click();
		locators.dot.click();
		locators.Eight.click();
		locators.Add.click();
		locators.One.click();
		locators.One.click();
		
		locators.equalsTo.click();
		
		Double value = locators.getDoubleResult();
		//Clear result for fresh operation
		locators.clearResult();
		//Assert the result
		assertEquals(value,99.8);
		
	}
	
	@Test
	public void testcalculator_subtract() {

		locators.clearResult();
		int value = Integer.parseInt(utilities.basicOperation(locators.Six, locators.Four,locators.Subtract,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		assertEquals(value,2);
		
	}
	@Test
	public void testcalculator_multiply() {

		locators.clearResult();
		int value = Integer.parseInt(utilities.basicOperation(locators.Six, locators.Four,locators.Multiply,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		assertEquals(value, 24);
	}
	@Test
	public void testcalculator_divide() {

		locators.clearResult();
		Double value = Double.parseDouble(utilities.basicOperation(locators.Six, locators.Three,locators.Division,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		assertEquals(value,2.0);
	}
	
	@Test
	public void testcalculator_FloatDivide() {

		locators.clearResult();
		Double value = Double.parseDouble(utilities.basicOperation(locators.Nine, locators.Two,locators.Division,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		assertEquals(value,4.5);
	}
	
	@Test
	public void testcalculator_addMultiplyIntegration() {
		locators.clearResult();
		//perform operation
		int value = Integer.parseInt(utilities.basicOperation(locators.Two, locators.Four,locators.Add,locators.equalsTo,locators.result));
		//Clear result for fresh operation
		locators.clearResult();
		int value1 = Integer.parseInt(utilities.basicOperation(locators.Six, locators.Four,locators.Multiply,locators.equalsTo,locators.result));
		locators.clearResult();
		//Assert the result
		assertEquals(value1-value,18);
		
	}
	@Test
	public void testcalculator_Integration1() {
		
		locators.clearResult();
		//perform SERIES OF operation
		
		locators.Six.click();
		locators.Multiply.click();
		locators.Four.click();
		locators.equalsTo.click();
		locators.Add.click();
		locators.Five.click();
		locators.equalsTo.click();
		
		
		assertEquals(locators.getResult(),29);
		locators.clearResult();
	}
	
	@Test
	public void testcalculator_Integration2Series() {

		//perform SERIES OF operation
		locators.clearResult();
		
		locators.Nine.click();
		locators.Nine.click();
		locators.Nine.click();
		locators.Subtract.click();
		locators.Seven.click();
		locators.Seven.click();
		locators.Seven.click();
		locators.equalsTo.click();
		locators.Division.click();
		locators.Two.click();
		locators.equalsTo.click();
		
		
		assertEquals(locators.getResult(),111);
		
		locators.Multiply.click();
		locators.Eight.click();
		locators.Eight.click();
		locators.Eight.click();
		
		locators.equalsTo.click();
		

		assertEquals(locators.getResult(),98568);
		
		
		
	}
	@Test
	public void testcalculator_BigNumberTest() {

		//perform SERIES OF operation
		locators.clearResult();
		
		locators.One.click();
		locators.Two.click();
		locators.Three.click();
		locators.Four.click();
		locators.Six.click();
		locators.Seven.click();
		locators.Eight.click();
		locators.Nine.click();
		locators.Multiply.click();
		locators.One.click();
		locators.Two.click();
		locators.Three.click();
		locators.Four.click();
		locators.Six.click();
		locators.Seven.click();
		locators.Eight.click();
		locators.Nine.click();
		locators.equalsTo.click();
		
		
		
		BigInteger a = new BigDecimal(locators.result.getText()).toBigInteger();
		BigInteger b = new BigDecimal("1.52443199e+14").toBigInteger();
		
		
		assertEquals(a.compareTo(b) == 0, true);
	
	}
	
	

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
