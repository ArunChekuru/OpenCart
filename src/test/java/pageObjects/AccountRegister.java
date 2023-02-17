package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegister 
{
	WebDriver driver;
	public AccountRegister(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfrmpassword;
	@FindBy(xpath="//input[@name='agree']")
	WebElement txtagree;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btncontinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confrmmsg;
	
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	public void settelephone(String tele)
	{
		txttelephone.sendKeys(tele);
	}
	public void setpassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void setconfrmpassord(String cnfpass)
	{
		cnfrmpassword.sendKeys(cnfpass);
	}
	public void setprivacypolicy()
	{
		txtagree.click();
	}
	public void setcontinue()
	{
		btncontinue.click();
	}
	public String getConfirmationMsg()
	{
		try
		{
		return (confrmmsg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	

}
