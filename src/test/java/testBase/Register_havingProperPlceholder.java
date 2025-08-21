package testBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;

public class Register_havingProperPlceholder extends BaseClass {
	@Test
	public void Plceholder() {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		String ExpeFnamePlaceHolder="First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), ExpeFnamePlaceHolder);
		String expLastName="Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expLastName);
		String expEmailID="E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expEmailID);
		String expTelephone="Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expTelephone);
		String expPassword="Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expPassword);
		String expConPassword="Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expConPassword);
	}
	

}
