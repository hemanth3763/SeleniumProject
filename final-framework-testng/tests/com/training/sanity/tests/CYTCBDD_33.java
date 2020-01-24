package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.pom.CYTC_33POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_33 {

	private WebDriver driver;
	private static Properties properties;
	private CYTC_33POM adminlogin;
	private String baseUrl;
	
	@Given("^run the application$")
	public void run_the_application() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminlogin = new CYTC_33POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@When("^logged in as admin opened the memberlogin$")
	public void logged_in_as_admin_opened_the_memberlogin() throws Throwable {
	  
		adminlogin.sendUserName("admin");
		adminlogin.sendPassword();
		adminlogin.clickLoginBtn(); 
		adminlogin.sendMemberlogin("hemanth123");
	}

	@Then("^grant the loan$")
	public void grant_the_loan() throws Throwable {
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
