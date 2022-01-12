package Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		String Screenshot = System.getProperty("user.dir")+"/Screenshots/screen_"+getCurrentDateTime()+".png";

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(SrcFile, new File(Screenshot));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture"+e.getMessage());
		}
		
		return Screenshot;
		
		
		
	}
	public static String getCurrentDateTime()
	{
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		java.util.Date currentDate=new java.util.Date();
		
		return customformat.format(currentDate);
	}
}
