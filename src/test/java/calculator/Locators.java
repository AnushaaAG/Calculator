package calculator;


import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locators {
	WebDriver driver;

	@FindBy(xpath = "//input[@value='1']")
	WebElement One;

	@FindBy(xpath = "//input[@value='2']")
	WebElement Two;

	@FindBy(xpath = "//input[@value='3']")
	WebElement Three;
	
	@FindBy(xpath = "//input[@value='4']")
	WebElement Four;

	@FindBy(xpath = "//input[@value='5']")
	WebElement Five;

	@FindBy(xpath = "//input[@value='6']")
	WebElement Six;
	
	@FindBy(xpath = "//input[@value='7']")
	WebElement Seven;

	@FindBy(xpath = "//input[@value='8']")
	WebElement Eight;

	@FindBy(xpath = "//input[@value='9']")
	WebElement Nine;
	
	@FindBy(xpath = "//input[@value='0']")
	WebElement Zero;
	
	@FindBy(id = "add")
	WebElement Add;

	@FindBy(id = "subtract")
	WebElement Subtract;

	@FindBy(id = "multiply")
	WebElement Multiply;
	
	@FindBy(id = "divide")
	WebElement Division;
	
	@FindBy(xpath = "//input[@value='=']")
	WebElement equalsTo;
	
	@FindBy(id = "display")
	WebElement result;
	
	@FindBy(xpath = "//input[@value='C']")
	WebElement reset;
	
	@FindBy(xpath = "//input[@value='.']")
	WebElement dot;
	
	
	
	public Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitle() {
		String getheadertext = driver.getTitle();
		assertEquals("Calculator", getheadertext);
	}
	public void clearResult() {
		reset.click();
	}
	public int getResult() {
		return Integer.parseInt(result.getText());
	}
	
	public Double getDoubleResult() {
		return Double.parseDouble(result.getText());
	}

}
