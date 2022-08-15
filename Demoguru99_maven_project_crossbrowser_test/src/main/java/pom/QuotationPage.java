package pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class QuotationPage {

	
	
	@FindBy (xpath= "//select[@id='quotation_breakdowncover']")
	private WebElement breakdowncover;
	
	@FindBy (xpath= "//input[@id='quotation_windscreenrepair_f']")
	private WebElement windscreenrepair;
	
	@FindBy (xpath= "//input[@id='quotation_incidents']")
	private WebElement incidents;
	
	@FindBy (xpath= "//input[@id='quotation_vehicle_attributes_registration']")
	private WebElement registration;
	
	@FindBy (xpath= "//input[@id='quotation_vehicle_attributes_mileage']")
	private WebElement vehiclemilege;
	
	@FindBy (xpath= "//input[@id='quotation_vehicle_attributes_value']")
	private WebElement vehiclevalue;
	
	@FindBy (xpath= "//select[@id='quotation_vehicle_attributes_parkinglocation']")
	private WebElement parkinglocation;
		
	@FindBy (xpath= "//select[@id='quotation_vehicle_attributes_policystart_1i']")
	private WebElement pyear;
	
	@FindBy (xpath= "//select[@id='quotation_vehicle_attributes_policystart_2i']")
	private WebElement pmonth;
	
	@FindBy (xpath= "//select[@id='quotation_vehicle_attributes_policystart_3i']")
	private WebElement pday;
	
	@FindBy (xpath= "//input[@name='submit']")
	private WebElement savequotatation;
	
	@FindBy (xpath= "//select[@id='quotation_vehicle_attributes_policystart_3i']")
	private WebElement ss;
	
  
	
	public QuotationPage (WebDriver driver) // driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickonbreakdowncover()
	{
		 Select s= new Select(breakdowncover);
		 s.selectByVisibleText("European");
	}
	
	public void checkwindscreenrepair()
	{
		boolean p= windscreenrepair.isSelected();   
	    System.out.println(p);
	}
	
	public void sendincidents() 
	{
        incidents.sendKeys("Road accident happen");
	}
	
	public void sendregistration() 
	{
		registration.sendKeys("MH18AH6558");
	}
	
	public void sendvehiclemilege() 
	{
		vehiclemilege.sendKeys("12000KM");
	}
	
	public void sendvehiclevalue() 
	{
		vehiclevalue.sendKeys("RS65000");
	}
	
	public void clickonparkinglocationlist()
	{
		Select s = new Select(parkinglocation);
	    s.selectByVisibleText("Public Place");
	}	
	
	public void clickonppolicylist()
	{
	    Select s = new Select(pyear);
	    s.selectByVisibleText("2022");
		Select s1 = new Select(pmonth);
		s1.selectByVisibleText("January");
		Select s2 = new Select(pday);
		s2.selectByVisibleText("10");     
	}
	
	public void clickonsavequotatation()
	{
		savequotatation.click();
	}
	
//	public void takescreenshort(WebDriver driver) throws IOException
//	{
//
//  	  DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"); 
//  	  LocalDateTime Current = LocalDateTime.now();
// 	  System.out.println(datetime.format(Current)); 
// 	  String a =datetime.format(Current);
//      File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
//  	  File dest = new File ("D:\\Automation Testing\\project screenshort\\insurance\\Screenshort"+a+".jpeg") ;  
//      FileHandler.copy(source,dest); 
//	      
//	}

	
	

	
}
