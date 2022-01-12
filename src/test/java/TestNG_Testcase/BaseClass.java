package TestNG_Testcase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageFactory.loginpagefactory;
import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataProvider;
import Utility.Helper;
import Utility.WaitUtility;

public class BaseClass {

	public  WebDriver driver;
	BrowserFactory factory = new BrowserFactory();
	public WaitUtility w1 = new WaitUtility();
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	

	@BeforeSuite
	public void setUpSuite()
	{
		excel =new ExcelDataProvider();
		config=new ConfigDataProvider();

		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/report_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);		
	}

	@BeforeClass

	public void setup() throws Exception
	{
		driver=factory.launchbrowser(this.driver, config.getBrowser(), config.getUrl());
	}

	@AfterClass

	public void tearup()
	{
		factory.quitbrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception
	{
	if(result.getStatus()==ITestResult.FAILURE)
		{

			logger.fail("Test Failed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		else if (result.getStatus()==ITestResult.SUCCESS)
		{

			logger.pass("Test Passed Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();
	}



}
