package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.PermissionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_003 {
	
	private WebDriver driver;
	private String baseUrl;
	private PermissionPOM permissionPOM;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	@Given("^start the application$")
	public void start_the_application() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		permissionPOM  = new PermissionPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@When("^admin is loggedin$")
	public void admin_is_loggedin() throws Throwable {
		permissionPOM.sendUserName("admin");
		permissionPOM.sendPassword("password");
		permissionPOM.clickLoginBtn(); 
	}

	@Then("^give permission to user$")
	public void give_permission_to_user() throws Throwable {
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
	}
}
