package cucumber.test;

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

public class GoogleTest {

	WebDriver driver;
	
	@Given("^Open Google page in firefox$")
	public void openBrowsr(){
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	}
	
	@When("^I type java in search field$")
	public void searchText(){
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("java");
	}
	
	@When("^I click on search button$")
	public void clickSearchButton(){
		WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));
		searchButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^I see results for java$")
	public void verifySearchResults(){
		String expectedTitle = "java - Google Search";
		String actualTitle = driver.getTitle();
		Assert.assertTrue("Title is not matched with expected",actualTitle.equals(expectedTitle));
	}
	
	@After
	public void closeBrowser(){
		driver.quit();
	}
}
