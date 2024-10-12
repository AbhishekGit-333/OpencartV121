package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testbase.Baseclass;

public class TC001_AccountRegistrationTest extends Baseclass {
	
	
	
	@Test(groups={"Regression", "master"})
	public void verify_account_registration() 
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try 
		{
		HomePage hm = new HomePage(driver);
		hm.clickmyaccount();
		logger.info("Clicked on MyAccount link");
		
		hm.clickonregister();
		logger.info("Clicked on Register link");
		
		
		AccountRegisterPage regpage = new AccountRegisterPage(driver);
		
		logger.info("Providing customer details....");
		regpage.setFirstname(randomstring().toUpperCase());
		regpage.setLastname(randomstring().toUpperCase());
		regpage.setEmail(randomstring()+"@gmail.com");   //Randomly generate the email address
		regpage.setTelephone(randomnumber());
		
		
		String password=randomalphanumeric();
		regpage.setPassword(password);
		regpage.setconfirmpassword(password);
		regpage.setprivacy();
		regpage.clickcontinue();
		
		logger.info("Validating expected message..");
		String confmsg = regpage.getconfirmationmsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		
		
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!!!!!");
		}
		catch(Exception e)
		{
			Assert.fail();			
		}
		logger.info("**** finished TC001_AccountRegistrationTest ****");
		
	}
	
	

}
