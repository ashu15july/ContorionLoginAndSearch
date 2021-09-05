package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search_box = By.xpath("//*[@id='search-input']");
	By search_button = By.xpath("//*[@id='search-button']");
	By product_details = By.cssSelector("p._my2.lg_my0");
	
	
	public void searchBox(String product) {

		driver.findElement(search_box).sendKeys(product);
	}

	public void searchButton() {

		driver.findElement(search_button).click();
	}
	
	public String totalProducts() {
		
		String text = driver.findElement(product_details).getText();
		
		return text;
	}
	

}
