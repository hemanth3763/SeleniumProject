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

import com.training.pom.PermissionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_003 {
	private WebDriver driver;
	private String baseUrl;
	private PermissionPOM permissionPOM;
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
		permissionPOM  = new PermissionPOM(driver); 
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
		permissionPOM.sendUserName("admin");
		permissionPOM.sendPassword("password");
		permissionPOM.clickLoginBtn(); 
		permissionPOM.memberLogin("hemanth123");
		permissionPOM.clickSubmit();
		permissionPOM.clickNewGroup();
		permissionPOM.selectFullMembers();
		permissionPOM.Comment("You are authorized user");
		permissionPOM.ClickSubmitBtn();
		
		
		String actualtitle=driver.switchTo().alert().getText();
		String expectedtitle="The member's group was changed, however, the activation mail could not be sent";
		Assert.assertEquals(actualtitle,expectedtitle);
		permissionPOM.AlertOK();
		Thread.sleep(3000);
		//screenShot.captureScreenShot("First");
	}
}
