package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jars_Drivers\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		  driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password ) {
		lp.setPassword(password);
		lp.setUserName(email);
	
		System.out.print("email:::"+email+":::pwd:::"+password);		
	}

	@When("Click on login")
	public void click_on_login() {
	   lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	 if(driver.getPageSource().contains("Login was unsuccessful.")) {
		 driver.close();
		 Assert.assertTrue(false);
	 }else {
		 Assert.assertEquals(title, driver.getTitle());
	 }
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("Close the browser")
	public void close_the_browser() {
	   driver.close();
	}

}
