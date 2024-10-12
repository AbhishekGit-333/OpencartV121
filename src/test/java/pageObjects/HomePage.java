package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  
	WebDriver driver;
	
//	Constructure
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
		
	//locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")           //login link added in step 5
	WebElement lnklogin;
	
	
	//Action methods
	
	public void clickmyaccount()
	{
		lnkmyaccount.click();
	}
	
	public void clickonregister()
	{
		lnkRegister.click();
	}
	
	public void clicklogin() 
	{
		lnklogin.click();
	}
		
}
