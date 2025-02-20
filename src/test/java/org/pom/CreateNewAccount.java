package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.BaseClass;

public class CreateNewAccount extends BaseClass {
	public CreateNewAccount() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Create new account']")
	private WebElement createBtn;
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(id="day")
	private WebElement day;
	@FindBy(id="month")
	private WebElement month;
	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement female;
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement male;
	
	@FindBy(name="reg_email__")
	private WebElement mobileOrEmail;
	
	@FindBy(name="reg_passwd__")
	private WebElement newPassword;
	
	@FindBy(name="websubmit")
	private WebElement submitBtn;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}
	

	public WebElement getFemale() {
		return female;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getMobileOrEmail() {
		return mobileOrEmail;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	
	
}
