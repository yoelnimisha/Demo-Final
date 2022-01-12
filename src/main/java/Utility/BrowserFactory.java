package Utility;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public WebDriver launchbrowser(WebDriver driver,String browser,String url) throws InterruptedException
	{
		switch(browser)
		{
		case "Chrome" :
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;

		case "Firefox" :
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			break;

		case "Edge" :
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
			break;

		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void quitbrowser(WebDriver driver)
	{
		driver.quit();
	}


}
