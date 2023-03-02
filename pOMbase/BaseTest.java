package pOMbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import javaUtility.ExtentReportsUtility;

public class BaseTest {
protected WebDriver driver=null;
protected Logger logger=null;
protected ExtentReportsUtility Exreport=null;
	public void getDriverInstance(String BrowserName) {
		switch(BrowserName) {
		case "chrome":  WebDriverManager.chromedriver().setup();
		                driver=new ChromeDriver();
		                driver.manage().window().maximize();
		                break;
		case "firefox":   WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    break;              
		  default: System.out.println("please enter the correct Browser");              }
	}
		public  void close() {
		//driver=new ChromeDriver();
		driver.close();
	}
	public void gotourl(String url) {
		driver.get(url);
	}
public void screenshot() throws IOException {
//String date= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
String curdir=System.getProperty("user.dir");
	TakesScreenshot obj=(TakesScreenshot)driver;
	File image=obj.getScreenshotAs(OutputType.FILE);
	File file=new File(curdir+"/Screenshots/image2.png");
	FileHandler.copy(image, file);
}
@BeforeTest
public void logger() {
	logger=LogManager.getLogger(BaseTest.class.getName());
	
	Exreport=new ExtentReportsUtility();
	Exreport.startExtentReport();
	//Exreport.logtestinfo("Testscript started");
}
@AfterTest
public void endtest() {
	Exreport.endreport();
}
@BeforeMethod
public void startup(Method method) 
{
	logger.info("Started testscript:" +method.getName());
	//System.out.println("Started testscript:" +method.getName());
	getDriverInstance("chrome");
	Exreport.startsingletestReport("testcase");
}
@AfterMethod 
public void endup() {
endtest();	
close();	}

	}
		



		




