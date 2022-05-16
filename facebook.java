package fb;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {
	WebDriver driver;
	
	@Given("The user should be in facebook login page")
	public void the_user_should_be_in_facebook_login_page() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@When("The user has to fill invaild username and password")
	public void the_user_has_to_fill_invaild_username_and_password() {
		
		WebElement txtusername=driver.findElement(By.id("email"));
		txtusername.sendKeys("bala@gmail.com");
		
		WebElement txtpassword =driver.findElement(By.id("pass"));
		txtpassword.sendKeys("1234567");
	}
	
	@When("then click login button")
	public void then_click_login_button() {
		WebElement btnlogin=driver.findElement(By.name("login"));
		btnlogin.click();
	}
	@Then("The user should navigate to login page")
	public void the_user_should_navigate_to_login_page() {
	//	WebDriverWait w=new WebDriverWait(driver,20);
		Assert.assertTrue("verify url after login", driver.getCurrentUrl().contains("privacy_mutation_token"));
		System.out.println("I AM in INvalid page");
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
