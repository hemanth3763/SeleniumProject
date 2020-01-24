package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AdminLoginPOM;
import com.training.pom.CYTC_33POM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_33 {

	private WebDriver driver;
	private static Properties properties;
	private CYTC_33POM adminlogin;
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
		adminlogin = new CYTC_33POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test
	public void validLoginTest() {
		adminlogin.sendUserName("admin");
		adminlogin.sendPassword();
		adminlogin.clickLoginBtn(); 
		adminlogin.sendMemberlogin("hemanth123");
		adminlogin.clickgrantloan();
		adminlogin.enteramount("100000");
		adminlogin.enterdescription("housing loan");
		adminlogin.clicksubmit();
		adminlogin.clicksubmit2();
		driver.switchTo().alert().accept();
		adminlogin.clickviewloan();
		String expected="Search results";
		String actual=driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
		Assert.assertEquals(expected, actual);
		
}
}
