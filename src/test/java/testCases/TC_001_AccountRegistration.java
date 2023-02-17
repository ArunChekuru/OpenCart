package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	@Test(groups={"regression","master"})
	public void acoount_registration()
	{
		logger.info(" Starting TC_001_AccountRegistration ");
		
		try
		{
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on My Account ");
		hp.clickregister();
		logger.info("Clicked on My Register ");
		AccountRegister accreg=new AccountRegister(driver);
		accreg.setfirstname("Malyadri");
		logger.info("Provided First Name");
		accreg.setlastname("Gatala");
		logger.info("Provided Last Name");
		accreg.setemail(randomstring()+"@gmail.com");
		logger.info("Provided Email");
		accreg.settelephone("7013421928");
		logger.info("Provided Phone Number");
		accreg.setpassword("Mal@143");
		logger.info("Provided Password");
		accreg.setconfrmpassord("Mal@143");
		logger.info("Provided Conform password");
		accreg.setprivacypolicy();
		logger.info("privacy policy");
		accreg.setcontinue();
		logger.info("Click On Continue");
        String confmsg=accreg.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
		}
		else
		{
			
			logger.info("Account Registration Failed ");
			captureScreen(driver,"acoount_registration");
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
