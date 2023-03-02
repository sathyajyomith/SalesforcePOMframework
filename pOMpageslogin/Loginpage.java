package pOMpageslogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pOMpagesBase.Basepage;

public class Loginpage extends Basepage{
//WebDriver driver;
@FindBy(id="username")WebElement username;
@FindBy(id="password")WebElement password;
@FindBy(id="Login")WebElement loginButton;
@FindBy(id="error")WebElement error;
@FindBy(id="rememberUn")WebElement rememberme;
@FindBy(id="idcard-identity")WebElement username1;
@FindBy(id="forgot_password_link")WebElement forgot;
@FindBy(id="header")WebElement forgotbox;
@FindBy(id="error")WebElement Error;



//WebElement rememberme=driver.findElement(By.id("rememberUn"));
public Loginpage(WebDriver driver) {
super(driver);
}
public void enterUsername(String data) {
username.sendKeys(data);	
}
public void enterPassword(String data) {
password.sendKeys(data);	
}
public WebDriver clickLogin() {
loginButton.click();
return driver;
}
public String getTextfromerror() {
error.getText();
return error.getText();
}
public void checkrememberme() {
	rememberme.click();		
}
public String getusername() {
	return username1.getText();
}
public void Forgot() {
	forgot.click();		
}
public String ForgotboxText() {
	return forgotbox.getText();
}
public String ErrorText() {
return Error.getText();
}

}
