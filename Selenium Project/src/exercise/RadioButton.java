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

public class RadioButton {
	WebDriver driver;

	@BeforeTest
	public void initTest() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testRadioButton() throws InterruptedException {

		// 1. go over displayDate.html page
		driver.get("file:///C:/Examples/radioButton.html");
		System.out.println("entered to the page");

		// 2. verify the first Line string
		WebElement firstLine = driver.findElement(By.xpath("/html/body/p[1]"));
		assertEquals("For what \"text-align\" feature is used ?",firstLine.getText(), "Strings not matching");
		System.out.println("verified the first Line string");

		//3. verify answer text 1
		WebElement answerString1 = driver.findElement(By.xpath("html/body/form/[text() = 'Set the text size']"));
		String str = answerString1.getText();
		//assertEquals("Set the text size",str, "Strings not matching");
		System.out.println(answerString1);


		 
		 
	

		System.out.println("Done.");
	}

	@AfterTest
	public void closeBroswer() {
		this.driver.quit();
	}

}
