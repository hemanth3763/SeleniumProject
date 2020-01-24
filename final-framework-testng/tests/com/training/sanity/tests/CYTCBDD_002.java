package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.AdminLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_002 {
	
	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM loginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;
	
	@Given("^open chrome and start application$")
	public void open_chrome_and_start_application() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@When("^enter the valid admin details$")
	public void enter_the_valid_admin_details() throws Throwable {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword();
	}

	@Then("^admin should login$")
	public void admin_should_login() throws Throwable {
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		String actual=driver.findElement(By.xpath("//div[@class='topBannerText']")).getText();
		String expected="Open Source on-line banking software";
		Assert.assertEquals(actual, expected);
	}


}
