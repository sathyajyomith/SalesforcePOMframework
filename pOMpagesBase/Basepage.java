package pOMpagesBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




public class Basepage {
protected  WebDriver driver=null;

public Basepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

}

