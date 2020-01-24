package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddressChangePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_005 {
	private WebDriver driver;
	private String baseUrl;
	private AddressChangePOM addresschangePOM;
	private static Properties properties;
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
		addresschangePOM  = new AddressChangePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000); 
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		addresschangePOM.sendUserName("hemanth123");
		addresschangePOM.sendPassword();
		addresschangePOM.clickLoginBtn(); 
		addresschangePOM.ClickProfile();
		addresschangePOM.ClickChange();
		addresschangePOM.ClickAddress("guntur");
		addresschangePOM.ClickSubmitBtn();
		Thread.sleep(3000);
		
		
		String actualtitle=driver.switchTo().alert().getText();
		String expectedtitle="Profile modified";
		Assert.assertEquals(actualtitle,expectedtitle);
		
		addresschangePOM.AlertOK();
		//screenShot.captureScreenShot("First");
	}
}
