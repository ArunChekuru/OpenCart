package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	
	@Test(groups={"regression","master"})
	public void test_accout_Registration()
	{
		logger.info(" Starting TC_001_AccountRegistration ");
		
		try
		{
			driver.get(rb.getString("appurl"));
			logger.info("Home Page Displayed ");
			driver.manage().window().maximize();
			HomePage hp = new HomePage(driver);
			hp.clickmyaccount();
			logger.info("Clicked on My Account ");
			hp.clickregister();
			logger.info("Clicked on Register ");
			
			AccountRegister regpag =new AccountRegister(driver);
			regpag.setfirstname("Gatala");
			logger.info("Provided First Name ");
			
			regpag.setlastname("Malyadri");
			logger.info("Provided Last Name ");
			
			regpag.setemail(randomstring()+"@gmail.com");
			logger.info("Provided Email ");
			
			regpag.settelephone("7013421928");
			logger.info("Provided Telephone ");
			
			regpag.setpassword("Mal@134");
			logger.info("Provided Password ");
			
			regpag.setconfrmpassord("Mal@134");
			logger.info("Provided Confirmed Password ");
			
			regpag.setprivacypolicy();
			logger.info("Set Privacy Policy ");
			
			regpag.setcontinue();
			logger.info("Clicked on Continue ");
			
			String conmsg=regpag.getConfirmationMsg();
			
			if(conmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Account Registration Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Account Registration Failed ");
				captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_001_AccountRegistration ");
		
	}
	
	
}