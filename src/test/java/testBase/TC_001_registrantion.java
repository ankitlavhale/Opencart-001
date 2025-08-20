package testBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;

public class TC_001_registrantion extends BaseClass{
	
	@Test
	public void loginManual() {
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
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		driver.findElement(By.xpath("//input[@value='1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Newsletter']")).isDisplayed());
		
	}

}
