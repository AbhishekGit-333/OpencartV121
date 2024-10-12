package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Baseclass;

public class TC002_LoginTest extends Baseclass{
	
	
	@Test(groups={"Sanity", "master"})
	public void verifylogin()
	{
		logger.info("****Starting TC_002_LoginTest ****");
		
		try
		{
		//Homepage
		HomePage hm = new HomePage(driver);
		hm.clickmyaccount();
		hm.clicklogin();
		
		//Loginpage
		Loginpage lp = new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();
		
		//myaccountpage
		Myaccountpage macc = new Myaccountpage(driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
			
		Assert.assertTrue(targetpage);  //Assert.assertEquals(targetpage, true, "login failed");
		
		}
		catch (Exception e)
		{
			Assert.fail();
		}
			logger.info("**** Finished TC_002_LoginTest ****");
			
		}
		
	}
	


