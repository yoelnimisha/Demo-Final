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
import PageFactory.loginpagefactory;
import Utility.Helper;
import java.io.File;


public class Teampage extends BaseClass {

	@Test(priority=1)
	public void addMemberViaForm() throws Exception {	 

		logger= report.createTest("Team Page -- Adding Team members via Form");

		loginpagefactory loginpage= new loginpagefactory(driver);

		logger.info("Starting Application");

		loginpage.login(excel.getStringNumericData("Login", 0, 0), excel.getStringNumericData("Login", 0, 1));

		logger.pass("Login Success");

		TeamPageFactory team=new TeamPageFactory(driver);
		
		team.teamCommon();

		team.addMemberVerification(excel.getStringNumericData("Team", 0, 0), excel.getStringNumericData("Team", 0, 1), excel.getStringNumericData("Team", 0, 2), excel.getStringNumericData("Team", 0, 3), excel.getStringNumericData("Team", 0, 4), excel.getStringNumericData("Team", 0, 5), excel.getStringNumericData("Team", 0, 6), excel.getStringNumericData("Team", 0, 7), excel.getStringNumericData("Team", 0, 8), excel.getStringNumericData("Team", 0, 9), excel.getStringNumericData("Team", 0, 10), excel.getStringNumericData("Team", 0, 11));

		logger.log(Status.INFO, "Testcase completed");

	}
/*

	@Test(priority=2)
	public void addMemberViaFormValidation() throws Exception {	 

		logger= report.createTest("Team Page -- Form Validation checking");

		TeamPageFactory team=new TeamPageFactory(driver);

		team.addMemberValidationVerification(excel.getStringNumericData("Team", 1, 0), excel.getStringNumericData("Team", 1, 1), excel.getStringNumericData("Team", 1, 2), excel.getStringNumericData("Team", 1, 3), excel.getStringNumericData("Team", 1, 4), excel.getStringNumericData("Team", 1, 5), excel.getStringNumericData("Team", 1, 6), excel.getStringNumericData("Team", 1, 7), excel.getStringNumericData("Team", 1, 8), excel.getStringNumericData("Team", 1, 9), excel.getStringNumericData("Team", 1, 10), excel.getStringNumericData("Team", 1, 11));

		logger.log(Status.INFO, "Testcase completed");

	}
	*/

	@Test(priority=2,dataProvider="pwdverification")
	public void PwdVerification(String pwd) throws Exception {	 

		logger= report.createTest("Team Page -- password Validation checking");

		TeamPageFactory team=new TeamPageFactory(driver);
		
		team.emailAddMember();

		team.pwdVerificationinForm(excel.getStringNumericData("Team", 0, 0), excel.getStringNumericData("Team", 0, 1), excel.getStringNumericData("Team", 0, 6));

		Thread.sleep(3000);
		
		Actions objactions=new Actions(driver);
		
		objactions.click(team.email).sendKeys(excel.getStringNumericData("Team", 0, 9)).click().build().perform();
		
		objactions.click(team.password).sendKeys(pwd).click().build().perform(); 

		Thread.sleep(3000);	
		
		team.submit.click();
		
		Assert.assertEquals(team.pwdvalidation.getText(), "Please enter at least 6 characters.");

		Thread.sleep(3000);
		
		team.close.click();

		logger.log(Status.INFO, "Testcase completed");


		System.out.println(pwd);
	}

	@DataProvider (name="pwdverification")
	public Object[][] email()
	{
		Object data[][]=excel.getDataprovider("Pwd");
		return data;
	}
	
	/*

	@Test(priority=2,dataProvider="emailverification")
	public void emailVerification(String email) throws Exception {	 

		logger= report.createTest("Team Page -- Email Validation checking");

		TeamPageFactory team=new TeamPageFactory(driver);
		
		team.emailAddMember();

		team.emailVerificationinForm(excel.getStringNumericData("Team", 0, 0), excel.getStringNumericData("Team", 0, 1), excel.getStringNumericData("Team", 0, 6));

		Thread.sleep(3000);
		
		Actions objactions=new Actions(driver);
		
		objactions.click(team.email).sendKeys(email).click().build().perform(); 

		Thread.sleep(3000);	
		
		objactions.click(team.password).sendKeys(excel.getStringNumericData("Team", 0, 10)).click().build().perform();

		team.submit.click();
		
		Assert.assertEquals(team.emailvalidation.getText(), "Please enter a valid email address.");

		Thread.sleep(3000);

		logger.log(Status.INFO, "Testcase completed");
		
		team.email.clear();
		
		team.password.clear();

		team.close.click();

		System.out.println(email);
	}

	@DataProvider (name="emailverification")
	public Object[][] emailVerification()
	{
		Object data[][]=excel.getDataprovider("email");
		return data;
	} 
	
	@Test(priority=2)
	public void duplicateCheck() throws Exception {	 

		logger= report.createTest("Team Page -- Form Duplicate entry checking");

		TeamPageFactory team=new TeamPageFactory(driver);

		Thread.sleep(3000);

		team.addMemberVerification(excel.getStringNumericData("Team", 0, 0), excel.getStringNumericData("Team", 0, 1), excel.getStringNumericData("Team", 0, 2), excel.getStringNumericData("Team", 0, 3), excel.getStringNumericData("Team", 0, 4), excel.getStringNumericData("Team", 0, 5), excel.getStringNumericData("Team", 0, 6), excel.getStringNumericData("Team", 0, 7), excel.getStringNumericData("Team", 0, 8), excel.getStringNumericData("Team", 0, 9), excel.getStringNumericData("Team", 0, 10), excel.getStringNumericData("Team", 0, 11));

		Thread.sleep(2000);
		
		Assert.assertEquals(team.duplicateValidation.getText(), "The email address you have entered is already registered.");

		System.out.println(team.duplicateValidation.getText());

		logger.log(Status.INFO, "Testcase completed");

	}
	

	@Test(priority=6)
	public void searchTable() throws Exception {	 

		logger= report.createTest("Team Page -- search");

		TeamPageFactory team=new TeamPageFactory(driver);

		team.searchTable(excel.getStringNumericData("Team", 0, 0));

		logger.log(Status.INFO, "Testcase completed");

	}

	@Test(priority=3)
	public void deleteEntry() throws Exception {	 

		logger= report.createTest("Team Page -- Delete");

		TeamPageFactory team=new TeamPageFactory(driver);

		team.deleteTableEntry(excel.getStringNumericData("Team", 0, 0));

		logger.log(Status.INFO, "Testcase completed");

	}

	@Test(priority=8)
	public void ExcelDownload() throws Exception {

		logger= report.createTest("Team Page -- Excel Download");

		TeamPageFactory team=new TeamPageFactory(driver);

		team.excelExport();

		String downloadPath = System.getProperty("user.dir");

		File file = new File(downloadPath);


	}*/




}

