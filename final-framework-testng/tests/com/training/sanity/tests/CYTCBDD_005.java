package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.AddressChangePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_005 {

	private WebDriver driver;
	private String baseUrl;
	private AddressChangePOM addresschangePOM;
	private static Properties properties;
	//private ScreenShot screenShot;

@Given("^open the application$")
public void open_the_application() throws Throwable {
	properties = new Properties();
	FileInputStream inStream = new FileInputStream("./resources/others.properties");
	properties.load(inStream);
	driver = DriverFactory.getDriver(DriverNames.CHROME);
	addresschangePOM  = new AddressChangePOM(driver); 
	baseUrl = properties.getProperty("baseURL");
	//screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
}

@When("^user is logged in$")
public void user_is_logged_in() throws Throwable {
	addresschangePOM.sendUserName("hemanth123");
	addresschangePOM.sendPassword();
	addresschangePOM.clickLoginBtn();
}

@Then("^change the address of user$")
public void change_the_address_of_user() throws Throwable {
	addresschangePOM.ClickProfile();
	addresschangePOM.ClickChange();
	addresschangePOM.ClickAddress("guntur");
	addresschangePOM.ClickSubmitBtn();
	Thread.sleep(3000);
	
	
	String actualtitle=driver.switchTo().alert().getText();
	String expectedtitle="Profile modified";
	Assert.assertEquals(actualtitle,expectedtitle);
	
	addresschangePOM.AlertOK();
}
}
