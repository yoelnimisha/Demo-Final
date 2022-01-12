package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestNG_Testcase.BaseClass;
import Utility.WaitUtility;

public class loginpagefactory extends BaseClass {

	WebDriver driver;



	public loginpagefactory(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver ,this);
	}

	@FindBy(xpath="//*[@id=\"email\"]") 	
	public WebElement email; 	

	@FindBy(xpath="//*[@id=\"password\"]") 	
	public WebElement password;

	@FindBy(xpath="//*[@id=\"signin-form\"]/button") 	
	public WebElement signin;

	@FindBy(xpath="//*[@id=\"user-dropdown\"]/span[2]") 	
	public WebElement signinusername;

	@FindBy(xpath="//*[@id=\"email-error\"]") 	
	public WebElement emailFieldrequired;

	@FindBy(xpath="//*[@id=\"password-error\"]") 	
	public WebElement pwdFieldrequired;

	@FindBy(xpath="//*[@id=\"default-navbar\"]/div/div/div/ul/li[6]/ul/li[7]/a") 	
	public WebElement signOut;

	@FindBy(xpath="//*[@id=\"signin-form\"]/div[1]") 	
	public WebElement Authentication;

	public void login(String username,String passwordappln)
	{
		email.sendKeys(username);
		password.sendKeys(passwordappln);
		signin.click();
	}

	public void signInButtonOnly()
	{
		w1.waitforVisibility(this.driver,signin);
		signin.click();
		Assert.assertEquals(emailFieldrequired.getText(), "This field is required.");
		Assert.assertEquals(pwdFieldrequired.getText(), "This field is required.");
	}

	public void signVerification()
	{
		w1.waitforVisibility(this.driver,signinusername);
		Assert.assertEquals(signinusername.getText(), "Ajith KS");
		signinusername.click();
		w1.waitforVisibility(this.driver,signOut);
		signOut.click();
	}

	public void signInvalidEmail()
	{
		w1.waitforVisibility(this.driver,signin);
		signin.click();
		Assert.assertEquals(emailFieldrequired.getText(), "This field is required.");
		Assert.assertEquals(pwdFieldrequired.getText(), "This field is required.");
	}

	public void signWrongEmail()
	{
		w1.waitforVisibility(this.driver,signin);
		signin.click();
		Assert.assertEquals(emailFieldrequired.getText(), "Please enter a valid email address.");
	}

	public void invalidPwd()
	{
		w1.waitforVisibility(this.driver,signin);
		signin.click();
		Assert.assertEquals(Authentication.getText(), "Authentication failed!");
	}

}
