package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	By cookies = By.xpath("//*[@id='popin_tc_privacy_button']");
	By anmelden = By.xpath("(//a[@href='https://www.contorion.de/login?vct=ho_cus-nav_lr'])[1]");
	By email = By.xpath("//*[@id='login_email']");
	By password = By.xpath("//*[@id='login_password']");
	By Jetzt_anmelden = By.xpath("//span[contains(text(),'Jetzt anmelden')]");


	public void acceptCookies() {

		driver.findElement(cookies).click();
	}


	public void hoverOnAnmelden() {

		WebElement ele = driver.findElement(anmelden);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	public void provideEmailid(String EmailID) {

		driver.findElement(email).sendKeys(EmailID);
	}

	public void providePassword(String pwd) {

		driver.findElement(password).sendKeys(pwd);
	}

	
	public void JetztAnmelden() {

		driver.findElement(Jetzt_anmelden).click();
	}



}
