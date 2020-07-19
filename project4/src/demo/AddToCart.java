package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCart {
	public static void main(String[] args) {
		
		ExtentReports extent;
		ExtentTest test;
		
		extent = new ExtentReports("C:\\Users\\SATHISH\\eclipse-workspace\\project4\\test_reports\\AddToCartTest.html",true);
		test = extent.startTest("Add To Cart Test");
		
		System.setProperty("webdriver.gecko.driver","F:\\firefoxDriver\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		test.log(LogStatus.INFO, "Browser is been opened");
		
		
	    driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		test.log(LogStatus.PASS, "Select the required product to add in your cart");
		WebElement img = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[src='http://automationpractice.com/img/p/1/1-home_default.jpg']")));
		img.click();
		test.log(LogStatus.PASS, "Select the AddToCart option");
		
		
		WebElement add = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		add.click();
        test.log(LogStatus.PASS, "Your cart is been updated");
		
		extent.endTest(test);
		extent.flush();

	
	}

}
