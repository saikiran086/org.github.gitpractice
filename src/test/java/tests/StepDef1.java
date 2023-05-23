package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef1 {
	
	Shared sh;
	
	public StepDef1(Shared sh)
	{
		this.sh=sh;
	}
	
	@Given("open browser")
	public void openBrowser()
	{
		
		WebDriverManager.firefoxdriver().setup();
		sh.driver=new FirefoxDriver();
		sh.driver.manage().window().maximize();
		sh.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Then("launch site {string}")
	public void launchSite(String url)
	{
		sh.driver.get(url);
	}
	
	@Then("search a word {string}")
	public void searchBox(String word)
	{
		sh.driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(word,Keys.ENTER);
		//sh.driver.findElement(By.xpath("(//input[@aria-label='Google Search'])[1]")).click();
	}
	
	@When("page title shoud be {string}")
	public void verifyTitle(String title)
	{
		String actualTitle=sh.driver.getTitle();
		
		if(actualTitle.contentEquals(title))
		{
			System.out.println("test pass");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("terst failed");
			Assert.assertTrue(false);
		}
	}
	@Then("close site")
	public void closeSite()
	{
		sh.driver.close();
	}
}




















