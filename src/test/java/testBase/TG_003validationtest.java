package testBase;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;

public class TG_003validationtest extends BaseClass  {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickRegister();
	AccountRegistrationPage ap=new AccountRegistrationPage(driver);
	ap.setfirstname(randomString());
	ap.setLastname(randomString());
	ap.setEmail(randomString()+"@gmail.com");
	ap.setTelephone(randomNumeber());
	ap.setPassword("ankit12345");
	ap.setconPassword("ankit12345");
	ap.policycheckbox();
	ap.btncontinue();

}
