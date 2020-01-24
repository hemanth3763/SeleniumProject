package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CYTCBDD_001 {
	private WebDriver driver;
	private static Properties properties;
	private RegisterPOM RegisterPOM;
	private String baseUrl;
	
	@Given("^open browser and start application$")
	public void open_browser_and_start_application() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RegisterPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL"); 
		driver.get(baseUrl);
	}

	@When("^enter the required details$")
	public void enter_the_required_details() throws Throwable {
		RegisterPOM.SubmitBtn();
		RegisterPOM.sendLoginname("Dhwani45");
		RegisterPOM.sendFullname("Dhwani456");
		RegisterPOM.sendEmail("dhwani456@gmail.com");
		RegisterPOM.CalenderClick();
		RegisterPOM.sendgender();
		RegisterPOM.sendaddress("Bangalore");
		RegisterPOM.sendpostalcode("560054");
		RegisterPOM.sendcity("Bangalore");
		RegisterPOM.sendphnNo("4567890123");
		RegisterPOM.sendmphnno("7890456321");
		RegisterPOM.sendfax("786549231");
		RegisterPOM.sendurl("www.google.com");
		RegisterPOM.sendpassword("dhwani1234");
		RegisterPOM.sendcnfrmpsswd("dhwani1234");
		RegisterPOM.sendcaptcha();
		
	}

	@Then("^Registration is successful$")
	public void registration_is_successful() throws Throwable {
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

}
