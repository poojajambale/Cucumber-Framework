package com.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginTest {

	WebDriver driver;
	WebElement email, password, login;
	
	@Given("open any browser")
	public void open_any_browser() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	}
	@Given("enter the application url")
	public void enter_the_application_url() {
	    driver.get("https://www.facebook.com/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("locate email textbox and enter email {string}")
	public void locate_email_textbox_and_enter_email(String emailId) {
	    email = driver.findElement(By.id("email"));
	    email.sendKeys(emailId);
	}
	@Given("locate password textbos and enter password {string}")
	public void locate_password_textbos_and_enter_password(String pass) {
	    password = driver.findElement(By.id("pass"));
	    password.sendKeys(pass);
	}
	@When("locate login button and click on it")
	public void locate_login_button_and_click_on_it() {
	   login = driver.findElement(By.name("login"));
	   login.click();
	}
	@Then("validate user should be on {string}")
	public void validate_user_should_be_on(String expTitle) {
	   String actTitle = driver.getTitle();
	   Assert.assertEquals(actTitle, expTitle);
	}
	@Then("close the browser")
	public void close_the_browser() {
	   driver.close();
	}



}
