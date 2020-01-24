package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.training.pom.CYTC_33POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoCheck {
	private WebDriver driver;
	private static Properties properties;
	private CYTC_33POM adminlogin;
	private String baseUrl;

	@Given("^enter the url in the browser and open the application$")
	public void enter_the_url_in_the_browser_and_open_the_application() throws Throwable {
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

	@When("^we are logged in as admin and open the member login$")
	public void we_are_logged_in_as_admin_and_open_the_member_login() throws Throwable {
		adminlogin.sendUserName("admin");
		adminlogin.sendPassword();
		adminlogin.clickLoginBtn(); 
		adminlogin.sendMemberlogin("hemanth123");
	}

	@Then("^grant the loans to the user$")
	public void grant_the_loans_to_the_user() throws Throwable {
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
