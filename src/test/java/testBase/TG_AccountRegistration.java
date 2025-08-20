package testBase;



import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;

public class TG_AccountRegistration extends BaseClass {
	

	@Test
	public void verify_account_registration() throws InterruptedException {
		System.out.println("Step 1: Open HomePage");
		HomePage hp = new HomePage(driver);
		System.out.println("Step 2: Click MyAccount");
		hp.clickMyAccount();
		System.out.println("Step 2: Click register");
		hp.clickRegister();
		System.out.println("Step 4: Fill form");
		Thread.sleep(3000);
		AccountRegistrationPage apage = new AccountRegistrationPage(driver);

		apage.setfirstname(randomString());
		apage.setLastname(randomString());
		apage.setEmail(randomString()+"0@gmail.com");
		apage.setTelephone(randomNumeber());
		//setting password
		String pass=randomAlpha();
		apage.setPassword(pass);
		apage.setconPassword(pass);

		apage.policycheckbox();
		apage.btncontinue();
		System.out.println("Step 5: Get confirmation message");
		String confmsg = apage.getconfirmationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

	}

	
}
