package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.RegisterPOM;

public class CYTC_001 {
	private WebDriver driver;
	private static Properties properties;
	private RegisterPOM RegisterPOM;
	private String baseUrl;
	//private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RegisterPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	@Test
	public void validRegisterTest()
	{
		RegisterPOM.SubmitBtn();
	RegisterPOM.sendLoginname("Dhwani34");
	RegisterPOM.sendFullname("Dhwani12345");
	RegisterPOM.sendEmail("dhwani1234567890@gmail.com");
	RegisterPOM.CalenderClick();
	RegisterPOM.sendgender();
	RegisterPOM.sendaddress("Bangalore");
	RegisterPOM.sendpostalcode("560054");
	RegisterPOM.sendcity("Bangalore");
	RegisterPOM.sendphnNo("5674980231");
	RegisterPOM.sendmphnno("7896223430");
	RegisterPOM.sendfax("9876543210");
	RegisterPOM.sendurl("www.google.com");
	RegisterPOM.sendpassword("dhwani123");
	RegisterPOM.sendcnfrmpsswd("dhwani123");
	RegisterPOM.sendcaptcha();
	RegisterPOM.clicksubmit();
	String expected="Thanksforregistering!Youraccounthasbeencreatedandneedstobeactivatedbytheadministration.";
	String result=driver.findElement(By.xpath("//td[contains(text(),'Thanks for registering!')]")).getText();
	StringTokenizer st = new StringTokenizer(result);  
	String name="";
    while (st.hasMoreTokens()) {  
        name=name+st.nextToken();
    }
    Assert.assertEquals(name,expected);
	}
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.quit();
}
}


