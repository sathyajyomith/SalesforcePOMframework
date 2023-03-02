package pOMpageshome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pOMpagesBase.Basepage;

public class HomePage extends Basepage {
	
	@FindBy(id="tsidLabel")WebElement title;
	@FindBy(id="userNavLabel")WebElement usermenu;
	@FindBy(xpath="/html/body/div/div[1]/table/tbody/tr/td[3]/div/div[3]/div/div/div[2]/div[3]/a[5]")WebElement logout;
	//WebElement usermenu=driver.findElement(By.id("userNavLabel"));
	public HomePage(WebDriver driver) {
		super(driver);
		}
public String getTextfromHomepage() {
return title.getText();	
}
public void usermenu() {
	usermenu.click();
}
public WebDriver logout() {
	logout.click();
	return driver;
}
}
