package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.Baseclass;
import utilities.DataProviders;

/* Data is valid - login success - test pass - logout
 	Data is valid - login failed - test fail
 	
 	Data is invalid - login success - test fail - logout
 	Data is invalid - login failed - test pass
 */

public class TC003_LoginDDT extends Baseclass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups = "datadriven")  //getting data provider from different class 
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("**** starting TC003_LoginDDT****");
		
		try 
		{
		//Homepage
		HomePage hm = new HomePage(driver);
		hm.clickmyaccount();
		hm.clicklogin();
		
		//Loginpage
		Loginpage lp = new Loginpage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		//myaccountpage
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		
		/*Data is valid - login success - test pass - logout
	 						login failed - test fail
	 	
	 	Data is invalid - login success - test fail - logout
	 						login failed - test pass
	 	*/
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				macc.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				macc.clicklogout();
				Assert.assertTrue(false);
			}
		else
		{
			Assert.assertTrue(true);
	}
	}
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("**** Finished TC003_LoginDDT****");
	}
}
