package exercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import junit.framework.Assert;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.thoughtworks.selenium.webdriven.commands.Click;

public class DisplayDate {
	WebDriver driver;

	@BeforeTest
	public void initTest() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testDisplayDate() throws InterruptedException {

		// 1. go over displayDate.html page
		driver.get("file:///C:/Examples/displayDate.html");
		System.out.println("entered to the page");

		// 2. verify the first Line string
		WebElement firstLine = driver.findElement(By.xpath("/html/body/p[1]"));
		assertEquals("Click the button to display the date.",firstLine.getText(), "Strings not matching");
		System.out.println("verified the first Line string");

		// 3. verify the button
		WebElement button = driver.findElement(By.tagName("button"));
		if (button.getText().equals("The time is?")) {
			System.out.println("the text on button is correct");
			assertTrue(true);
		} else {
			System.out.println("the text on button isn't correct");
			assertTrue(false);
		}
		// 4. click on the button and verify date displayed
		button.click();
		// WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("dateInfo")));
		WebElement dateInfo = driver.findElement(By.id("dateInfo"));
		if (dateInfo.isDisplayed()) {
			System.out.println("the date is displayed");
			assertTrue(true);
		} else {
			System.out.println("the date isn't displayed");
			assertTrue(false);
		}

	
		 
		 
		// 5. verify the first Line string
		WebElement lastLine = driver.findElement(By.xpath("/html/body/h6"));
		assertEquals("this is the information from my computer",lastLine.getText(), "Strings not matching");
		System.out.println("verified the last Line string");

		System.out.println("Done.");
	}

	@AfterTest
	public void closeBroswer() {
		this.driver.quit();
	}

}
