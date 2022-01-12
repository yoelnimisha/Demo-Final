package TestNG_Testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageFactory.loginpagefactory;
import Utility.Helper;



public class Loginpage extends BaseClass {



	@Test(priority=1)
	public void validUserPwd() throws Exception {	 

		logger= report.createTest("Login Page -- Valid Username and Password");

		loginpagefactory loginpage= new loginpagefactory(driver);

		logger.info("Starting Application");

		loginpage.login(excel.getStringNumericData("Login", 0, 0), excel.getStringNumericData("Login", 0, 1));

		logger.pass("Login Success");

		loginpage.signVerification();

		logger.pass("Login user is - !!Ajith KS!!");

		logger.log(Status.INFO, "Testcase completed");

	}
	
	@Test(priority=2)
	public void nonMandatory() throws Exception {	 

		logger= report.createTest("Login Page -- No Username and Password Entered");

		loginpagefactory loginpage= new loginpagefactory(driver);
		
		logger.info("Starting Application");

		loginpage.signInvalidEmail();

		logger.pass("Login - Email Field validation shown");

		logger.log(Status.INFO, "Testcase completed");

	}
	
	@Test(priority=3)
	public void inValidEmailVerification() throws Exception {	 

		logger= report.createTest("Login Page -- Invalid Email Verification");

		loginpagefactory loginpage= new loginpagefactory(driver);
		
		logger.info("Starting Application");

		loginpage.login(excel.getStringNumericData("Login", 1, 0), excel.getStringNumericData("Login", 1, 1));

		loginpage.signWrongEmail();		

		logger.log(Status.INFO, "Testcase completed");

	}
	
	@Test(priority=4)
	public void inValidPwdlVerification() throws Exception {	 

		logger= report.createTest("Login Page -- Invalid Password Verification");

		loginpagefactory loginpage= new loginpagefactory(driver);
		
		logger.info("Starting Application");

		loginpage.login(excel.getStringNumericData("Login", 2, 0), excel.getStringNumericData("Login", 2, 1));

		loginpage.invalidPwd();		

		logger.log(Status.INFO, "Testcase completed");

	}
	
	/*
	@BeforeTest
	public void beforeTestObjCreation()
	{
		loginpage = new loginpagefactory(this.driver);
	}
	*/
	
}

