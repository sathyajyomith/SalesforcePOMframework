package pomTests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaUtility.PropertiesUtility;
import pOMbase.BaseTest;
import pOMpagesBase.Basepage;
import pOMpageshome.HomePage;
import pOMpageslogin.Loginpage;
@Listeners(javaUtility.MyListeners.class)
@Test
public class pomAutomation extends BaseTest{
   public void Login_Script() throws InterruptedException, IOException {
   String url=PropertiesUtility.readpropertyData("url");
   String username=PropertiesUtility.readpropertyData("login.valid.id");
   String password=PropertiesUtility.readpropertyData("login.valid.pasword");
    
	gotourl(url);	
	Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Loginpage loginpage=new Loginpage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	driver=loginpage.clickLogin();
	Thread.sleep(3000);
	HomePage homepage=new HomePage(driver);
	String expected="Content";
	String actual= homepage.getTextfromHomepage();
	Assert.assertEquals(actual, expected);
	screenshot();
	}
	@Test
	public void error_login() throws InterruptedException, IOException {
		String url=PropertiesUtility.readpropertyData("url");
		String username=PropertiesUtility.readpropertyData("login.valid.id");
		gotourl(url);
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Loginpage loginpage=new Loginpage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(" ");
		driver=loginpage.clickLogin();
		String expected="Please enter your password.";
		String actual= loginpage.getTextfromerror();
		Assert.assertEquals(actual, expected);
		screenshot();
		}
	
	@Test(priority=3,enabled=true)
	public void checkRememberMe() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String url=PropertiesUtility.readpropertyData("url");
	    String username=PropertiesUtility.readpropertyData("login.valid.id");
		String password=PropertiesUtility.readpropertyData("login.valid.pasword");
		gotourl(url);
		Loginpage loginpage=new Loginpage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.checkrememberme();
		driver=loginpage.clickLogin();
		HomePage homepage=new HomePage(driver);
		homepage.usermenu();
	    homepage.logout();
	String expected="hi@tekarch.com";
	Thread.sleep(5000);
	String actual =loginpage.getusername();
	Assert.assertEquals(actual, expected);
	screenshot();
	}
	
	@Test(priority=4,enabled=true)
	public void forgotPasswordA() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	String url=PropertiesUtility.readpropertyData("url");
    String username=PropertiesUtility.readpropertyData("login.valid.id");	   
    gotourl(url);
	Loginpage loginpage=new Loginpage(driver);
	loginpage.enterUsername(username);
	loginpage.Forgot();
	String expected="Forgot Your Password";
	String actual=loginpage.ForgotboxText();
	Assert.assertEquals(actual, expected);
	screenshot();
	}
	
	@Test(priority=4,enabled=true)
	public void forgotpasswordB() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
	String url=PropertiesUtility.readpropertyData("url");
	String username=PropertiesUtility.readpropertyData("login.invalid.id");	
    String password=PropertiesUtility.readpropertyData("login.invalid.pasword");
	gotourl(url);
    Loginpage loginpage=new Loginpage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	driver=loginpage.clickLogin();
	Thread.sleep(3000);
	String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String actual=loginpage.ErrorText();
	Assert.assertEquals(actual, expected);
    screenshot();
}
}

