package com.LoginAndSearch.Testcases;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Pages.HomePage;
import com.Pages.LoginPage;

import utilities.ConfigFileReader;

public class TC001_Login_And_Search {

	LoginPage Login;
	HomePage Home;
	WebDriver driver;
	ConfigFileReader conf;
	String title = "Contorion: Der smarte Shop fürs Handwerk";


	@BeforeMethod
	public void setUp() throws InterruptedException {

		conf = new ConfigFileReader();
		System.setProperty("webdriver.chrome.driver",conf.getDriverPath());
		driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//STEP1: Open the URL.
		driver.get(conf.getApplicationUrl());
		driver.manage().window().maximize();		
	}


	@Test()
	public void login_and_searchProduct() throws Exception {
		Login = new LoginPage(driver);	
		Home = new HomePage(driver);
		conf = new ConfigFileReader();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//STEP2: Accept the cookies.
		Login.acceptCookies();
		//STEP3: Hover on Anmelden icon that will open login form.
		Login.hoverOnAnmelden();
		//STEP4: Provide email address.
		Login.provideEmailid(conf.getEmailId());
		//STEP5: Provide password.
		Login.providePassword(conf.getPassword());
		//STEP6: Click on Jetzt anmelden button.
		Login.JetztAnmelden();
		Thread.sleep(5000);
		//STEP7: Verify the title of application.
		Assert.assertEquals(driver.getTitle(), title);
		//STEP8: Provide product name that need to be searched.
		Home.searchBox(conf.getProduct());
		//STEP9: Click on search button.
		Home.searchButton();
		Thread.sleep(5000);
		//STEP10: Printout total number of products.
		System.out.println(Home.totalProducts());

	}

	@AfterTest
	public void tear_Down() {
		//Close the browser.
		driver.close();
	}

}


