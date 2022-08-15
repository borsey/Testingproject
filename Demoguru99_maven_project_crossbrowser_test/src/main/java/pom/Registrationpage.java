package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registrationpage {

	@FindBy (xpath= "//select[@id='user_title']")
	private WebElement title ;
	
	@FindBy (xpath= "//input[@id='user_firstname']")
	private WebElement firstname ;
	
	@FindBy (xpath= "//input[@id='user_surname']")
	private WebElement lastname ;
	
	@FindBy (xpath= "//input[@id='user_phone']")
	private WebElement phoneno ;
	
	@FindBy (xpath= "//select[@id='user_dateofbirth_1i']")
	private WebElement year ;
	
	@FindBy (xpath= "//select[@id='user_dateofbirth_2i']")
	private WebElement month ;
		
	@FindBy (xpath= "//select[@id='user_dateofbirth_3i']")
	private WebElement day ;
	
	@FindBy (xpath= "//input[@id='licencetype_f']")
	private WebElement provisional ;
			
	@FindBy (xpath= "//select[@id='user_licenceperiod']")
	private WebElement licenceperiod ;
	
	@FindBy (xpath= "//select[@id='user_occupation_id']")
	private WebElement occupation ;
	
	@FindBy (xpath= "//input[@id='user_address_attributes_street']")
	private WebElement address ;
	
	@FindBy (xpath= "//input[@id='user_address_attributes_city']")
	private WebElement city ;
	
	@FindBy (xpath= "//input[@id='user_address_attributes_county']")
	private WebElement country ;
	
	@FindBy (xpath= "//input[@id='user_address_attributes_postcode']")
	private WebElement code ;
	
	@FindBy (xpath= "//input[@id='user_user_detail_attributes_email']")
	private WebElement email ;
	
	@FindBy (xpath= "//input[@id='user_user_detail_attributes_password']")
	private WebElement password ;
	
	@FindBy (xpath= "//input[@id='user_user_detail_attributes_password_confirmation']")
	private WebElement confirmpassword ;
	
	@FindBy (xpath= "//input[@name='submit']")
	private WebElement create ;
	
	private	WebDriver driver ;
	
	public Registrationpage(WebDriver driver) // driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void titlelist()
	{
		Select s = new Select (title);
		s.selectByVisibleText("Mr");
	}
	
	public void sendfirstname()
	{
		firstname.sendKeys("Swaraj");
	}
	
	public void sendlastname()
	{
		lastname.sendKeys("Patel");
	}
	
	public void sendphoneno()
	{
		phoneno.sendKeys("9422556644");
	}
			
	public void DOByearlist()
	{
		Select s = new Select (year);
		s.selectByIndex(5);
	}
	
	public void DOBmonthlist()
	{
		Select s = new Select (month);
		s.selectByValue("6");
	}
	
	public void DOBdaylist()
	{
	    Select s = new Select (day);
		s.selectByVisibleText("26");
	}
	
	public void clickonprovisional()
	{
		provisional.click();
	    boolean a = provisional.isDisplayed();
	    System.out.println(a);
	}			
	
	public void licenceperiodlist()
	{
		Select year1 = new Select (licenceperiod);
	    year1.selectByVisibleText("2");
	}	
	
	public void occupationlist()
	{
		Select s2 = new Select (occupation);
	    s2.selectByVisibleText("Actor");
	}	
	
	public void sendaddress()
	{
		address.sendKeys("canera bank");
	}
	
	public void sendcityname()
	{
		city.sendKeys("pune");
	}
	
	public void sendcountryname()
	{
		country.sendKeys("India");
	}
	
	public void sendcodename()
	{
		 code.sendKeys("411058");
	}
	
	public void sendemail(String mail) throws EncryptedDocumentException, IOException
	{

		  email.sendKeys(mail);
	}
	
	public void sendpassword(String pass) throws EncryptedDocumentException, IOException
	{

	    password.sendKeys(pass);
	}
	
	public void sendconfirmpassword(String cpass) throws EncryptedDocumentException, IOException
	{

	    confirmpassword.sendKeys(cpass);
	}
	
	public void clickoncreate()
	{
		create.click(); 
	}


	
	
	
}
