package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage{

	public Myaccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")            //My account page heading 
	WebElement msgHeading;

	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")  //added in step6
	WebElement lnklogout;
	
	
	public boolean isMyAccountPageExists() 
	
	{
		try 
		{
		return (msgHeading.isDisplayed());
		}
		catch (Exception e)
		{
		return false;
		}
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
	
}
