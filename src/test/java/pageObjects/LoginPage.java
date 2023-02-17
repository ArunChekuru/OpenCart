package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemailaddress;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnclick;
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgheading;
	
	public void setemailaddress(String email)
	{
		txtemailaddress.sendKeys(email);
	}
	public void setpassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	public void setbtnclick()
	{
		btnclick.click();
	}
	public boolean ismyaccountpageexists()
	{
		try
		{
		return(msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

}
