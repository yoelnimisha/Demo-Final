package PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import TestNG_Testcase.BaseClass;

public class TeamPageFactory extends BaseClass {

	WebDriver driver;



	public TeamPageFactory(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver ,this);
	}

	@FindBy(xpath="//*[@id=\"sidebar-menu\"]/li[11]/a/span") 	
	public WebElement team;

	@FindBy(xpath="//*[@id=\"sidebar-menu\"]/li[11]/ul/li[1]/a/span") 	
	public WebElement teamMember;

	@FindBy(xpath="//*[@id=\"page-content\"]/div/div[1]/div/a[2]") 	
	public WebElement addMemeber;


	@FindBy(xpath="//*[@id=\"first_name\"]") 	
	public WebElement firstName;

	@FindBy(xpath="//*[@id=\"last_name\"]") 	
	public WebElement lastName;

	@FindBy(xpath="//*[@id=\"address\"]") 	
	public WebElement mailAddress;

	@FindBy(xpath="//*[@id=\"phone\"]") 	
	public WebElement phone;

	@FindBy(xpath="//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']/div[1]/table[@class='table-condensed']//td") 	
	public List<WebElement> Date;

	@FindBy(xpath="//*[@id=\"gender_male\"]") 	
	public WebElement mRadio;

	@FindBy(xpath="//*[@id=\"gender_female\"]") 	
	public WebElement fRadio;

	@FindBy(xpath="//*[@id=\"form-next\"]") 	
	public WebElement next;

	@FindBy(xpath="//div[@class='modal-footer']/button[3][@id='form-next']") 	
	public WebElement next1;

	@FindBy(xpath="//*[@id=\"date_of_hire\"]") 	
	public WebElement DateHire;

	@FindBy(xpath="//*[@id=\"job_title\"]") 	
	public WebElement jobTitle;

	@FindBy(xpath="//*[@id=\"salary\"]") 	
	public WebElement salary;

	@FindBy(xpath="//*[@id=\"salary_term\"]") 	
	public WebElement salaryTerm;

	@FindBy(xpath="//*[@id=\"email\"]") 	
	public WebElement email;

	@FindBy(xpath="//*[@id=\"password\"]") 	
	public WebElement password;

	@FindBy(xpath="//*[@id=\"generate_password\"]") 	
	public WebElement generatePassword;

	@FindBy(xpath="//*[@id=\"show_hide_password\"]") 	
	public WebElement hidePassword;

	@FindBy(xpath="//div[@id='s2id_user-role']") 	
	public WebElement role;

	@FindBy(xpath="//div[@class='col-md-12']/input[@id='email_login_details']")
	public WebElement checkbox;

	@FindBy(xpath="//*[@id=\"form-submit\"]") 	
	public WebElement submit;

	@FindBy(xpath="//*[@id=\"team_member-form\"]/div[2]/button[1]") 	
	public WebElement closeDown;

	@FindBy(xpath="//*[@id=\"ajaxModal\"]/div/div/div[1]/button") 	
	public WebElement previousDown;

	@FindBy(xpath="//*[@id=\"select2-results-18\"]")
	public WebElement roleSelect;

	@FindBy(xpath="//*[@id=\"first_name-error\"]")
	public WebElement FNvalidation;

	@FindBy(xpath="//*[@id=\"last_name-error\"]")
	public WebElement LNvalidation;

	@FindBy(xpath="//*[@id=\"job_title-error\"]")
	public WebElement jobvalidation;

	@FindBy(xpath="//*[@id=\"email-error\"]")
	public WebElement emailvalidation;

	@FindBy(xpath="//*[@id=\"password-error\"]")
	public WebElement pwdvalidation;

	@FindBy(xpath="//div[@class='app-alert alert alert-danger alert-dismissible ']/div[1]")  
	public WebElement duplicateValidation;	
	
	
	
	@FindBy(xpath="//*[@id=\"team_member-table_wrapper\"]/div[1]/div[2]/div[2]/div/button[1]/span")
	public WebElement excelExport;
	
	
	@FindBy(xpath="//*[@id=\"ajaxModal\"]/div/div/div[1]/button")
	public WebElement close;
	
	public void teamCommon() throws Exception
	{
		w1.waitforVisibility(this.driver, team);
		team.click();
		Thread.sleep(2000);
		w1.waitforVisibility(this.driver, teamMember);
		teamMember.click();
		Thread.sleep(2000);
	}
	

	public void addMemberVerification(String fName,String lName,String mail,String pNumber,String gender,String exceldate,String job,String fsalary,String salaryterm,String femail,String fpassword,String fRole) throws Exception
	{
		
		w1.waitforVisibility(this.driver, addMemeber);
		addMemeber.click();
		Thread.sleep(2000);
		w1.waitforVisibility(driver, firstName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		mailAddress.sendKeys(mail);
		phone.sendKeys(pNumber);

		if(gender.equalsIgnoreCase("F"))
		{
			fRadio.click();
		}
		else
		{
			mRadio.click();
		}

		w1.waitforVisibility(driver, next);
		next.click();
		jobTitle.sendKeys(job);
		salary.sendKeys(fsalary);
		salaryTerm.sendKeys(salaryterm);
		DateHire.click();
		int total_nodes=Date.size();
		for(int i=0;i<total_nodes;i++)
		{
			String date=Date.get(i).getText();
			if(date.equals(exceldate))
			{
				Date.get(i).click();
				break;
			}
		}
		w1.waitforVisibility(driver, next1);
		next1.click();
		email.sendKeys(femail);
		password.sendKeys(fpassword);
		//role.click();
		//	Select role1=new Select(role);
		//	role1.selectByValue(fRole);
		checkbox.click();
		submit.click();	
	}
	public void addMemberValidationVerification(String fName,String lName,String mail,String pNumber,String gender,String exceldate,String job,String fsalary,String salaryterm,String femail,String fpassword,String fRole) throws Exception
	{

		w1.waitforVisibility(this.driver, addMemeber);
		w1.waitforClickable(this.driver, addMemeber);
		addMemeber.click();
		w1.waitforVisibility(driver, next);
		w1.waitforClickable(this.driver, next);
		next.click();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(FNvalidation.getText(), "This field is required.");
		softassert.assertEquals(LNvalidation.getText(), "This field is required.");
		softassert.assertAll();
		w1.waitforVisibility(driver, firstName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		mailAddress.sendKeys(mail);
		phone.sendKeys(pNumber);

		if(gender.equalsIgnoreCase("F"))
		{
			fRadio.click();
		}
		else
		{
			mRadio.click();
		}

		w1.waitforVisibility(driver, next);
		next.click();
		w1.waitforVisibility(driver, next1);
		next1.click();
		Assert.assertEquals(jobvalidation.getText(), "This field is required.");
		w1.waitforVisibility(driver, jobTitle);
		jobTitle.sendKeys(job);
		salary.sendKeys(fsalary);
		salaryTerm.sendKeys(salaryterm);
		DateHire.click();
		int total_nodes=Date.size();
		for(int i=0;i<total_nodes;i++)
		{
			String date=Date.get(i).getText();
			if(date.equals(exceldate))
			{
				Date.get(i).click();
				break;
			}
		}
		w1.waitforVisibility(driver, next1);
		next1.click();
		w1.waitforVisibility(driver, submit);
		submit.click();	
		Assert.assertEquals(emailvalidation.getText(), "This field is required.");
		Assert.assertEquals(pwdvalidation.getText(), "This field is required.");
		email.sendKeys(femail);
		password.sendKeys(fpassword);
		//role.click();
		//	Select role1=new Select(role);
		//	role1.selectByValue(fRole);
		//checkbox.click();
		submit.click();	
	}

	public void pwdVerificationinForm(String fName,String lName,String job)
	{

		/*w1.waitforVisibility(this.driver, team);
		team.click();
		w1.waitforVisibility(this.driver, teamMember);
		teamMember.click();
		w1.waitforVisibility(this.driver, addMemeber);
		addMemeber.click();*/
		w1.waitforVisibility(driver, firstName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		w1.waitforVisibility(driver, next);
		next.click();
		jobTitle.sendKeys(job);
		w1.waitforVisibility(driver, next1);
		next1.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void emailAddMember()
	{
	w1.waitforVisibility(this.driver, addMemeber);
	addMemeber.click();
	}
	
	public void emailVerificationinForm(String fName,String lName,String job)
	{

	/*	w1.waitforVisibility(this.driver, team);
		team.click();
		w1.waitforVisibility(this.driver, teamMember);
		teamMember.click();*/
		
		w1.waitforVisibility(driver, firstName);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		w1.waitforVisibility(driver, next);
		next.click();
		jobTitle.sendKeys(job);
		w1.waitforVisibility(driver, next1);
		next1.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void searchTable(String data)
	{
		for(int i=1;i<=10;i++)
		{
			WebElement tabledata = driver.findElement(By.xpath("//*[@id=\"team_member-table\"]/tbody/tr["+i+"]/td[2]/a"));
			String tabledata1=tabledata.getText();

			if(tabledata1.contains(data))
			{
				System.out.println("found @row"+i);
				break;
			}
			else
			{
				System.out.println("Not found");
			}

		}
	}

	public void deleteTableEntry(String data) throws InterruptedException
	{
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"team_member-table\"]/tbody/tr"));
		
		int arraysize=rows.size();

		for(int i=1;i<=arraysize;i++)
		{
			WebElement tabledata = driver.findElement(By.xpath("//*[@id=\"team_member-table\"]/tbody/tr["+i+"]/td[2]/a"));
			String tabledata1=tabledata.getText();

			if(tabledata1.contains(data))
			{
				System.out.println("matching data");
				WebElement delete = driver.findElement(By.xpath("//*[@id=\"team_member-table\"]/tbody/tr["+i+"]/td[6]/a"));
				delete.click();
				WebElement delete1=driver.findElement(By.xpath("//*[@id=\"confirmDeleteButton\"]"));
				delete1.click();
			}
			
		}
	}
	
	public void excelExport() throws Exception
	{
		excelExport.click();
Thread.sleep(5000);
		
		

		
	}
}
