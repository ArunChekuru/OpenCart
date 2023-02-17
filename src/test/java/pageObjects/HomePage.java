package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//span[@class='hidden-xs hidden-sm hidden-md'] [text()='My Account']")
	WebElement inkmyaccount;
	@FindBy (xpath="//a[text()='Register']")
	WebElement inkregister;
	@FindBy (xpath="//a[text()='Login']")
	WebElement inklogin;
	
	public void clickmyaccount()
	{
	inkmyaccount.click();
	}
	public void clickregister()
	{
		inkregister.click();
	}
	public void clicklogin()
	{
		inklogin.click();
	}

}
