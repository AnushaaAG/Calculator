package calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {
	
	WebDriver driver;
	
	public String basicOperation(WebElement a, WebElement b,WebElement operator,WebElement resultOperator,WebElement result) {
		
		a.click();
		operator.click();
		b.click();
		resultOperator.click();
		return result.getText();
	}

	

}
