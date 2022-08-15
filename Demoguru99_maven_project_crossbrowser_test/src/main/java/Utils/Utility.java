package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

 
	
	public static void capturescreen(WebDriver driver, String testid ) throws IOException 
	{
		  DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"); 
    	  LocalDateTime Current = LocalDateTime.now();
   		  System.out.println(datetime.format(Current)); 
   		  String a =datetime.format(Current);
          File source3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
    	  File dest3 = new File ("test-output\\Screenshort\\Test-"+testid +" "+a+".jpeg");  
          FileHandler.copy(source3,dest3);
          
	}
	
	public static String fetchdatafromExcel(String sheet ,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
	    String path = "src\\main\\resources\\testdata\\insurance project.xlsx";
	    FileInputStream file = new FileInputStream(path);    
	    String data =WorkbookFactory.create(file).getSheet("Velocity").getRow(rowno).getCell(cellno).getStringCellValue();
	    return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
