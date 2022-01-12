package TestNG_Testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import PageFactory.File;
import PageFactory.TeamPageFactory;
import PageFactory.clientpagefactory;
import PageFactory.loginpagefactory;
import Utility.Helper;
import java.io.File;


public class Clientpage extends BaseClass {

	@Test(priority=1)
	public void addClientViaForm() throws Exception {	 

		logger= report.createTest("Team Page -- Adding Client members via Form");

		loginpagefactory loginpage= new loginpagefactory(driver);

		logger.info("Starting Application");

		loginpage.login(excel.getStringNumericData("Login", 0, 0), excel.getStringNumericData("Login", 0, 1));

		logger.pass("Login Success");

		clientpagefactory client=new clientpagefactory(driver);
		
		client.addClient();
		
		client.addClientform();

		//team.addMemberVerification(excel.getStringNumericData("Team", 0, 0), excel.getStringNumericData("Team", 0, 1), excel.getStringNumericData("Team", 0, 2), excel.getStringNumericData("Team", 0, 3), excel.getStringNumericData("Team", 0, 4), excel.getStringNumericData("Team", 0, 5), excel.getStringNumericData("Team", 0, 6), excel.getStringNumericData("Team", 0, 7), excel.getStringNumericData("Team", 0, 8), excel.getStringNumericData("Team", 0, 9), excel.getStringNumericData("Team", 0, 10), excel.getStringNumericData("Team", 0, 11));

		logger.log(Status.INFO, "Testcase completed");

	}




}

