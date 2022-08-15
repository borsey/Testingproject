package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy (xpath= "//input[@name='email']")
	private WebElement loginmail ;
	
	@FindBy (xpath= "//input[@name='password']")
	private WebElement loginpassword ;
	
	@FindBy (xpath= "//input[@name='submit']")
	private WebElement login ;
  
	public Loginpage (WebDriver driver)  // driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendloginmail(String user) 
	{

	    loginmail.sendKeys(user);	
	}
	
	public void sendloginpassword(String pass)
	{

        loginpassword.sendKeys(pass);	
	}
	
	public void clickOntlogin()
	{
		login.click();
	}
	
	
	
	
	
	
	
}
