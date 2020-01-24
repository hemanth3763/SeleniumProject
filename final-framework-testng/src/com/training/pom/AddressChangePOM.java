package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressChangePOM {
private WebDriver driver; 
	
	public AddressChangePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(id="Submit")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//td[@class='tdContentTableForms innerBorder']//td[1]//a[1]")
	private WebElement clickprofile;
	
	@FindBy(xpath="//input[@id='modifyButton']")
	private WebElement changeBtn;
	
	
	@FindBy(xpath="//tr[7]//td[2]//span[1]//input[2]")
	private WebElement address;
	
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement submitBtn;
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword() {
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='1']")).click();
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='2']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='3']")).click(); 
		driver.findElement(By.xpath("//*[@class='virtualKeyboardButton virtualKeyboardContrastNormal' and @value='4']")).click();  
	}
	
	public void ClickProfile()
	{
		this.clickprofile.click();
	}
	
	public void ClickChange()
	{
		this.changeBtn.click();
	}
	
	public void ClickAddress(String enteraddress)
	{
		this.address.click();
		this.address.clear();
		this.address.sendKeys(enteraddress);
	}
	
	public void ClickSubmitBtn()
	{
		this.submitBtn.click();
	}
	
	public void clickLoginBtn() 
	{
		driver.findElement(By.xpath("//div[@id='virtualKeyboard']//div//input[@class='button']")).click();
	}
	
	public void AlertOK()
	{
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
	}
}
