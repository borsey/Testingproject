package Test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.Headers;
import pom.Loginpage;
import pom.QuotationPage;
import pom.Register;
import pom.Registrationpage;

public class Verification_class {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
				
System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\Selenium files\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		// 1 page object created	
		Register register = new Register (driver); 
		
		register.clickOntRegister();
		
		// 2 page object created	
		Registrationpage registration = new Registrationpage (driver); 
		
		registration.titlelist();
		registration.sendfirstname();
		registration.sendlastname();
		registration.sendphoneno();
		registration.DOByearlist();
		registration.DOBmonthlist();
		registration.DOBdaylist();
		registration.clickonprovisional();
		registration.licenceperiodlist();
		registration.occupationlist();
		registration.sendaddress();
		registration.sendcityname();
		registration.sendcountryname();
		registration.sendcodename();
//		registration.sendemail();
//		registration.sendpassword();
//		registration.sendconfirmpassword();
		registration.clickoncreate();
			
		
		// 3 page object created	
		Loginpage loginpage = new Loginpage (driver); 
		
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		
		if (url.equals("https://demo.guru99.com/insurance/v1/index.php")&& title.equals("Insurance Broker System - Login"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
//		loginpage.sendloginmail();
//		loginpage.sendloginpassword();
		loginpage.clickOntlogin();
		
		
		//4 page object created	
		Headers headers = new Headers (driver); 
		
		String url1 = driver.getCurrentUrl();
		String title1 = driver.getTitle();
		System.out.println(url1);
		System.out.println(title1);
		
		if (url1.equals("https://demo.guru99.com/insurance/v1/header.php")&& title1.equals("Insurance Broker System"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		headers.clickOnrequestquotation();
		headers.clickOnretrivequotation();
//		headers.clickOnlogout();
		
		//5 page object created	
		QuotationPage Quotation = new QuotationPage (driver); 	
		
		Quotation.clickonbreakdowncover();
		Quotation.checkwindscreenrepair();
		Quotation.sendincidents();
		Quotation.sendregistration();
		Quotation.sendvehiclemilege();
		Quotation.sendvehiclevalue();
		Quotation.clickonparkinglocationlist();
		Quotation.clickonppolicylist();
		Quotation.clickonsavequotatation();
//		Quotation.takescreenshort(driver);
		
		
		
		
		
		
		
		
	}
}
