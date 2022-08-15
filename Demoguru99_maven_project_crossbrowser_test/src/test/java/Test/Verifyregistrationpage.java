package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility;
import browsers.Base;
import pom.Headers;
import pom.Loginpage;
import pom.Register;
import pom.Registrationpage;


public class Verifyregistrationpage extends Base{
	

WebDriver driver ;
Headers headers;
Registrationpage registration;
Register register ;
SoftAssert soft ;
String testid ;
static ExtentTest test;
static ExtentHtmlReporter reporter;
@Parameters("browsername")
@BeforeTest
public void launchbrowser(String browser)
{	
	reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	ExtentReports extend = new ExtentReports();
	extend.attachReporter(reporter);
      if (browser.equalsIgnoreCase("opera"))
      {
    	 driver =openoperabrowser();
      }
	
      if (browser.equalsIgnoreCase("edge"))
      {
    	 driver =openEdgebrowser();
      }
	
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//	driver.manage().window().maximize();

}
@BeforeClass
public void launchbrowser() throws EncryptedDocumentException, IOException
{

	 register = new Register (driver);
	 registration = new Registrationpage (driver);
	 soft = new SoftAssert();
	
}

@BeforeMethod
public void enterinregistrationpage() throws InterruptedException  
{
	driver.get("https://demo.guru99.com/insurance/v1/index.php");
	
	Thread.sleep(1000);
	register.clickOntRegister();
	
}

@Test
public void verifregistrationpage() throws EncryptedDocumentException, IOException 
{
	testid = "503" ;
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	System.out.println(url);
	System.out.println(title);
	
   
    
//soft.assertEquals(url,"ttps://demo.guru99.com/insurance/v1/register.php","test fail zali na");
//above comment line for while method fail we can write message as string at last it shows in console before error
    
    soft.assertEquals(url,"https://demo.guru99.com/insurance/v1/register.php");
	System.out.println("hello");
	soft.assertEquals(title, "Insurance Broker System - Register");
	
	soft.assertAll();    

	
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
	
	String email = Utility.fetchdatafromExcel("Velocity", 0, 0);
	registration.sendemail(email);
	String password = Utility.fetchdatafromExcel("Velocity", 1, 0);
	registration.sendpassword(password);
	String confirmpassword = Utility.fetchdatafromExcel("Velocity", 2, 0);
	registration.sendconfirmpassword(confirmpassword);
	
	
}


@AfterMethod
public void createregistrationpage(ITestResult result) throws InterruptedException, IOException 
{
	if (ITestResult.FAILURE == result.getStatus())
	{
		Utility.capturescreen(driver, testid);
	}
	registration.clickoncreate();
}	
	
@AfterClass
public void clearobject()
{
	register = null;
	registration = null;
}	
	
@AfterTest
public void closebrowser()
{
	driver.quit();	
	driver= null;
	System.gc();
}	
	
	
	
	
}
