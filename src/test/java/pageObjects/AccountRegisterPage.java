package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
  
	WebDriver driver;
	
  //Constructor
	public AccountRegisterPage(WebDriver driver) 
  {
	  super(driver);
  }
	
//	Locators

	@FindBy(xpath="//input[@id='input-firstname']")  WebElement txt_Firstname;
	@FindBy(xpath="//input[@id='input-lastname']")   WebElement txt_Lastname;
	@FindBy(xpath="//input[@id='input-email']")      WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']")  WebElement txt_Telephone;
	@FindBy(xpath="//input[@id='input-password']")	 WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']")    WebElement txt_ConfirmPassword;
//	@FindBy(xpath="//input[@value='0']")             WebElement txt_radiobutton;
	@FindBy(xpath="//input[@name='agree']")          WebElement txt_privacy;
	@FindBy(xpath="//input[@value='Continue']")      WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	
	
//	Action methods
	public void setFirstname(String fname)
	{
		txt_Firstname.sendKeys(fname);
	}
  
	
	public void setLastname(String lname) 
	{
		txt_Lastname.sendKeys(lname);
	}
	
	public void setEmail(String Email)
	{
		txt_Email.sendKeys(Email);
	}
	
	public void setTelephone(String Telephone)
	{
		txt_Telephone.sendKeys(Telephone);
	}
	
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String pwd)
	{
		txt_ConfirmPassword.sendKeys(pwd);
	}
	
	public void setprivacy()
	{
		txt_privacy.click();
	}
	
	public void clickcontinue()
	{
		btn_continue.click();
	}
	
	public String getconfirmationmsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
			
		}
	}
  
  
}
