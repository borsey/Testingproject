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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.Utility;
import browsers.Base;
import pom.Headers;
import pom.Loginpage;
import pom.Register;
import pom.Registrationpage;


public class VerifyCarInsurance extends Base{
	

WebDriver driver ;
Headers headers;
Loginpage loginpage ;
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
	driver.manage().window().maximize();

}

@BeforeClass
public void createObject() throws EncryptedDocumentException, IOException
{
	loginpage = new Loginpage (driver);
	headers = new Headers (driver);
}

@BeforeMethod
public void logintheapplicatin() throws EncryptedDocumentException, IOException, InterruptedException 
{
	
	driver.get("https://demo.guru99.com/insurance/v1/index.php");
	
	String loginmail = Utility.fetchdatafromExcel("Velocity", 3, 0);
	loginpage.sendloginmail(loginmail);
	
	String loginpassword = Utility.fetchdatafromExcel("Velocity", 4, 0);
	loginpage.sendloginpassword(loginpassword);
	
	Thread.sleep(1000);
	loginpage.clickOntlogin();
	
}

@Test (priority =1)
public void verifyrequestQotation() 
{
	testid = "501";
	String url1 = driver.getCurrentUrl();
	String title1 = driver.getTitle();
	System.out.println(url1);
	System.out.println(title1);
	
	
	Assert.assertEquals(url1,"https://demo.guru99.com/insurance/v1/header.php");
	System.out.println("hello");
	Assert.assertEquals(title1,"Insurance Broker System");
	
	
}

@Test (priority =2)
public void verifyreriveQotation() 
{	
	testid = "502";
	headers.clickOnretrivequotation();
	
}


@AfterMethod
public void logoutapplication(ITestResult result) throws InterruptedException, IOException 
{
	if (ITestResult.FAILURE == result.getStatus())
	{
		Utility.capturescreen(driver, testid);
	}
	Thread.sleep(2000);
	headers.clickOnlogout();
	Thread.sleep(2000);
}	
	
@AfterClass
public void clearobject()
{
	 loginpage = null;
	 headers = null;
}	

@AfterTest
public void closebrowser()
{
	driver.quit();	
	driver= null;
	System.gc();	
}	
	
	
	
	
}
