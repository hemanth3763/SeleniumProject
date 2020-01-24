package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.UserLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_004 {

	private WebDriver driver;
	private String baseUrl;
	private UserLoginPOM userloginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;	

@Given("^start application$")
public void start_application() throws Throwable {
	properties = new Properties();
	FileInputStream inStream = new FileInputStream("./resources/others.properties");
	properties.load(inStream);
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	userloginPOM  = new UserLoginPOM(driver); 
	baseUrl = properties.getProperty("baseURL");
	//screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
}

@When("^enter the valid user credentials$")
public void enter_the_valid_user_credentials() throws Throwable {
	userloginPOM.sendUserName("hemanth123");
	userloginPOM.sendPassword();
}

@Then("^user should login$")
public void user_should_login() throws Throwable {
	userloginPOM.clickLoginBtn(); 
	
	String actual=driver.findElement(By.xpath("//div[@class='topBannerText']")).getText();
	String expected="Open Source on-line banking software";
	Assert.assertEquals(actual, expected);
}
}
