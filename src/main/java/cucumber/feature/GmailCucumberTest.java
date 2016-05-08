package cucumber.feature;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailCucumberTest {
	WebDriver driver;

	@Given("^navigate to gmail page$")
	public void navigate() {
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
	}

	@When("^user logged in using username as \"(.*)\" and password as \"(.*)\"$")
	public void login(String email, String pwd) {
		WebElement userName = driver.findElement(By.id("Email"));
		userName.sendKeys("venkatesharelly");
		WebElement next = driver.findElement(By.id("next"));
		next.click();
		WebElement password = driver.findElement(By.id("Passwd"));
		password.sendKeys("venk!243ra");
		WebElement sigInButton = driver.findElement(By.id("signIn"));
		sigInButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^home page should be displayed$")
	public void verifySuccessful() {
		String expectedText = "Gmail";
		String actualText = driver.getTitle();
		Assert.assertTrue("Gmail Login is not successful",actualText.contains(expectedText));
	}

	@After
	public void closeBrowser(){
		driver.quit();
	}
}
