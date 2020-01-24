package com.training.pom;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="member(user).username")
	private WebElement loginname; 
	
	@FindBy(name="member(name)")
	private WebElement fullname;
	
	@FindBy(name="member(email)")
	private WebElement email; 
	
	@FindBy(xpath="//div[@id='loginRegistrationDiv']//input[@class='button']")
	private WebElement submitbtn; 
	
	@FindBy(id="calendarTrigger0")
	private WebElement calenderclick;
	
	@FindBy(id="_id1578903011070_726")
	private WebElement birthday;
	
	@FindBy(id="_radio_2_1")
	private WebElement gender;
	
	@FindBy(xpath="//tr[6]//td[2]//input[3]")
	private WebElement address;
	
	@FindBy(xpath="//tr[7]//td[2]//input[3]")
	private WebElement postalcode;
	
	@FindBy(xpath="//tr[8]//td[2]//input[3]")
	private WebElement city;
	
	@FindBy(xpath="//tr[10]//td[2]//input[3]")
	private WebElement phonenumber;
	
	@FindBy(xpath="//tr[11]//td[2]//input[3]")
	private WebElement mobilephonenumber;
	

	@FindBy(xpath="//tr[12]//td[2]//input[3]")
	private WebElement fax;
	

	@FindBy(xpath="//tr[13]//td[2]//input[3]")
	private WebElement url;
	

	@FindBy(xpath="//input[@name='member(user).password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//input[@name='captcha']")
	private WebElement captcha;
	
	@FindBy(id="saveButton")
	private WebElement submit;
	
	public void clicksubmit()
	{
		this.submit.click();
	}
	
	public void sendcnfrmpsswd(String confirmpassword)
	{
		this.confirmpassword.clear();
		this.confirmpassword.sendKeys(confirmpassword);
	}
	
	public void sendcaptcha()
	{
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		this.captcha.sendKeys(captchaVal);
	}
	
	public void sendfax(String fax)
	{
		this.fax.clear();
		this.fax.sendKeys(fax);
	}
	
	public void sendurl(String url)
	{
		this.url.clear();
		this.url.sendKeys(url);
	}
	
	public void sendpassword(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	
	public void sendmphnno(String mobilephonenumber)
	{
		this.mobilephonenumber.clear();
		this.mobilephonenumber.sendKeys(mobilephonenumber);
	}
	
	public void sendphnNo(String phonenumber)
	{
		this.phonenumber.clear();
		this.phonenumber.sendKeys(phonenumber);
	}
	public void sendcity(String city)
	{
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void sendpostalcode(String postalcode)
	{
		this.postalcode.clear();
		this.postalcode.sendKeys(postalcode);
	}
	
	public void sendaddress(String address)
	{
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void sendgender()
	{
		this.gender.click();
	}
	
	public void sendBirthday(String birthday)
	{
		this.birthday.clear();
		this.birthday.sendKeys(birthday);
	}
	
	public void sendLoginname(String loginname)
	{
		this.loginname.clear();
		this.loginname.sendKeys(loginname);
	}
	
	public void sendFullname(String fullname)
	{
		this.fullname.clear();
		this.fullname.sendKeys(fullname);
	}
	
	public void sendEmail(String email)
	{
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void SubmitBtn()
	{
		this.submitbtn.click();
	}
	
	public void CalenderClick()
	{
		this.calenderclick.click();
	}
}
