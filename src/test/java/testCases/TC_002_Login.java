package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
	@Test(groups={"sanity","master"})
	public void test_login() throws IOException
	{
		try
		{
		logger.info("Starting TC_002_Login");
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on My Account ");
		hp.clicklogin();
		logger.info("Clicked on Login ");
		LoginPage lp=new LoginPage(driver);
		lp.setemailaddress(rb.getString("email"));
		logger.info("Entered vaild email adress ");
		lp.setpassword(rb.getString("password"));
		logger.info("Entered vaild password ");
		lp.setbtnclick();
		logger.info("Clicked on Login");
		boolean targetpage =lp.ismyaccountpageexists();
		{
			if(targetpage)
			{
				logger.info("Login Sucess");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed");
				captureScreen(driver,"test_login");
				Assert.assertTrue(false);
			}
		}
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed");
			Assert.fail();
		}
		logger.info("Finished TC_002_Login");
	}
	

}
