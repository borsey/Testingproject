package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

	
	@FindBy (xpath= "//a[@class='btn btn-default']")
	private WebElement register ;
	
	private WebDriver driver ;
	
	public Register (WebDriver driver)  // driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void clickOntRegister()
	{
		register.click();
	}
	
	
	
}
