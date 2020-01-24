package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_33POM {

	WebDriver driver;
	
	public CYTC_33POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="memberUsername")
	private WebElement memberlogin;
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(id="amount")
	private WebElement amount;
	
	@FindBy(id="description")
	private WebElement description;
	
	@FindBy(xpath="//body[@class='main']/div[@class='layoutMain']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/form[@name='grantLoanForm']/table[@class='defaultTableContent']/tbody/tr/td[@class='tdContentTableForms innerBorder']/table[@class='defaultTable']/tbody/tr/td[1]/input[1]")
	private WebElement submit;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement sumbit2;
	
	@FindBy(xpath="//div[@id='virtualKeyboard']//div//input[@class='button']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement viewloan;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement grantloan;
	
	public void clickviewloan()
	{
		this.viewloan.click();;
	}
	
	public void clicksubmit2()
	{
		this.sumbit2.click();
	}
	
	public void clicksubmit()
	{
		this.submit.click();
	}
	
	public void enterdescription(String description)
	{
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void enteramount(String amount)
	{
		this.amount.clear();
		this.amount.sendKeys(amount);
	}
	
	public void clickgrantloan()
	{
		this.grantloan.click();
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendMemberlogin(String memberlogin)
	{
		this.memberlogin.clear();
		this.memberlogin.sendKeys(memberlogin);
	}
	
	public void sendPassword() {
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();  
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}


