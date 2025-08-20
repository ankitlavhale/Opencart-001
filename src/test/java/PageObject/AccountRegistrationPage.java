package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage  {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement Txtfirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement Txtlastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement TxtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement numTelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Txtpassword;	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement Txtconpassword;	
	
	
	@FindBy(xpath = "//input[@value='0']")
	WebElement newslettler;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement Privecypolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirm;

	
	

	public void setfirstname(String fname) {
		Txtfirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		Txtlastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		TxtEmail.sendKeys(email);
	}
	public void setTelephone(String number) {
		numTelephone.sendKeys(number);
	}

	public void setPassword(String password) {
		Txtpassword.sendKeys(password);
	}
	public void setconPassword(String conpassword) {
		Txtconpassword.sendKeys(conpassword);
	}
	//public void newslettertick() {
	//	newslettler.click();
	//}
	
	public void policycheckbox() {
		Privecypolicy.click();
	}
	public void btncontinue() {
		continueBtn.click();
	}

	

	public String getconfirmationmsg() {
		try {
			return (msgconfirm.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
