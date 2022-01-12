package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestNG_Testcase.BaseClass;
import Utility.WaitUtility;

public class clientpagefactory extends BaseClass {

	WebDriver driver;



	public clientpagefactory(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver ,this);
	}

	@FindBy(xpath="//*[@id=\"sidebar-menu\"]/li[3]/a/span") 	
	public WebElement clientLink; 	

	@FindBy(xpath="//*[@id=\"client-tabs\"]/div/div/a[2]") 	
	public WebElement addClient;

	@FindBy(xpath="//*[@id=\"company_name\"]") 	
	public WebElement companyName;

	@FindBy(xpath="//div[@class='select2-container form-control']") 	
	public WebElement owner;

	@FindBy(xpath="/html/body/span]") 	
	public WebElement dropdownValue;

	/*/@FindBy(xpath="//*[@id=\"password-error\"]") 	
	public WebElement pwdFieldrequired;

	@FindBy(xpath="//*[@id=\"default-navbar\"]/div/div/div/ul/li[6]/ul/li[7]/a") 	
	public WebElement signOut;

	@FindBy(xpath="//*[@id=\"signin-form\"]/div[1]") 	
	public WebElement Authentication;
	*/

	
	public void addClient() throws Exception
	{
		Thread.sleep(2000);
		w1.waitforVisibility(this.driver,clientLink);
		clientLink.click();
		Thread.sleep(3000);
		w1.waitforVisibility(this.driver,addClient);
		addClient.click();
		Thread.sleep(2000);
	}
	
	public void addClientform() throws Exception
	{
		Thread.sleep(3000);
		companyName.sendKeys("test");
		Thread.sleep(3000);
		owner.click();
		Thread.sleep(3000);
		dropdownValue.sendKeys("Test_Fn Test_LN");
		
	}

	

}
