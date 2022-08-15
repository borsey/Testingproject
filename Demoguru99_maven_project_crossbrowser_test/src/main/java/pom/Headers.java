package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Headers {

	
	@FindBy (xpath= "(//a[@class='ui-tabs-anchor'])[2]")
	private WebElement requestquotation;
	
	@FindBy (xpath= "(//a[@class='ui-tabs-anchor'])[3]")
	private WebElement retrivequotation;
	
	@FindBy (xpath="//input[@value='Log out']")
	private WebElement logout;
	
  
	private Actions act ;
	private WebDriver driver ;
	
	public Headers (WebDriver driver) // driver = new chromeDriver()
	{
		PageFactory.initElements(driver, this);
	    this.driver = driver ;
		act = new Actions (driver);
		
	}
	
	public void clickOnrequestquotation()
	{
		requestquotation.click();
	}
	
	public void clickOnretrivequotation()
	{
		retrivequotation.click();
		boolean result =retrivequotation.isSelected();
		System.out.println(result);
	}
	
	public void clickOnlogout() throws InterruptedException
	{
		Thread.sleep(1000);
		logout.click();
	}
	
	
	
	
	
	
	
	
}
