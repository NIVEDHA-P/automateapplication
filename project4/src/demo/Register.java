package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Register {

	public static void main(String[] args) throws InterruptedException {
		Register registerTest = new Register();
		registerTest.registrationTest();
	}
	@Test
	public void registrationTest() throws InterruptedException {
		
		ExtentReports extent;
		ExtentTest test;
		
		extent = new ExtentReports("C:\\Users\\SATHISH\\eclipse-workspace\\project4\\test_reports\\RegistrationTest.html",true);
		test = extent.startTest("New UserAccount Registration Test");		
		
		System.setProperty("webdriver.gecko.driver","F:\\firefoxDriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		
		test.log(LogStatus.INFO, "Browser is been opened");
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.name("email_create")).sendKeys("nivi2231@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click(); 
		
		test.log(LogStatus.PASS, "Enter the valid information in the registration form");
		WebElement radio = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("uniform-id_gender2")));
		radio.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("nivedh");
		driver.findElement(By.id("customer_lastname")).sendKeys("praba");
		driver.findElement(By.id("passwd")).sendKeys("23456");
		
		test.log(LogStatus.PASS, "User's Password is confirmed");
		
		Select dropdown = new Select(driver.findElement(By.id("days")));
		dropdown.selectByIndex(7);
		Select dropdown1 = new Select(driver.findElement(By.id("months")));
		dropdown1.selectByIndex(7);
		Select dropdown2 = new Select(driver.findElement(By.id("years")));
		dropdown2.selectByIndex(40);
		driver.findElement(By.id("company")).sendKeys(" abc Company");
		driver.findElement(By.id("address1")).sendKeys("323,xyz street");
		driver.findElement(By.id("city")).sendKeys("los angeles");
		Select dropdown4 = new Select(driver.findElement(By.id("id_state")));
		dropdown4.selectByVisibleText("California");
		driver.findElement(By.id("postcode")).sendKeys("90002");
		Select dropdown3 = new Select(driver.findElement(By.id("id_country")));
		dropdown3.selectByVisibleText("United States");
		driver.findElement(By.id("phone_mobile")).sendKeys("7784839390");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("ghf street");
		
		test.log(LogStatus.PASS, "Before hitting register button,check your details that have been entered");
		Thread.sleep(10000);
		driver.findElement(By.id("submitAccount")).click();
		
        test.log(LogStatus.PASS, "UserAccount has been successfully created");
		
		extent.endTest(test);
		extent.flush();
	
		
	}
}