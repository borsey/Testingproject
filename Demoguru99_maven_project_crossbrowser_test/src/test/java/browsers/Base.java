package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	public static WebDriver openchromebrowser() 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Automation Testing\\Selenium files\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver();
		return driver ;
	}

	public static WebDriver openoperabrowser() 
	{
		System.setProperty("webdriver.opera.driver","src\\test\\resources\\Browsers\\operadriver.exe");	
		
		WebDriver driver = new OperaDriver();
		return driver ;
	}
	
	public static WebDriver openEdgebrowser() 
	{
		System.setProperty("webdriver.edge.driver","src\\test\\resources\\Browsers\\msedgedriver.exe");	
		
		WebDriver driver = new EdgeDriver();
		return driver ;
	}
	

	
	
	
	
	
	
	
	
	
	
}
