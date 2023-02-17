package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData",groups= {"DDT"})
	public void test_loginDDT(String email,String pwd,String exp) 
	{
		try
		{
		logger.info(" Starting TC_003_LoginDDT ");
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		logger.info("Clicked on My Account ");
		hp.clicklogin();
		logger.info("Clicked on Login ");
		LoginPage lp=new LoginPage(driver);
		lp.setemailaddress(email);
		logger.info("Entered vaild email adress ");
		lp.setpassword(pwd);
		logger.info("Entered vaild password ");
		lp.setbtnclick();
		logger.info("Clicked on Login");
		boolean targetpage =lp.ismyaccountpageexists();
			if(exp.equals("Valid"))
			{
			if(targetpage==true)
			{
				logger.info("Login Sucess");
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.setbtnlogout();
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed");
				Assert.assertTrue(false);
			}
		  }
			if(exp.equals("Invalid"))

			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.setbtnlogout();
					Assert.assertTrue(false);
				}
				else
				{		
					logger.error("Login Failed ");
					Assert.assertTrue(true);
				}
			}
	}
		catch(Exception e)
	{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	
	logger.info(" Finished TC_003_LoginDDT ");
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
	}
}


