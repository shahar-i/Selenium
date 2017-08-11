package exercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import junit.framework.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
	File file;
	String url = "C:/Examples/displaydate.html";

	@BeforeTest
	public void initTest() {
		
		driver = new ChromeDriver();
		file = new File(url);
	}

	@Test
	public void testDisplayDate() throws InterruptedException {
		
		// 1. go over displayDate.html page
		try {
			checkIfFileExist();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		// 2. verify the first Line string
		verifyFirstLine();
		
		// 3. verify the button text
		verifyButtonText();
		
		// 4. click on the button and verify date displayed
		clickTheButton();
		
		// WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("dateInfo")));
		
		// 5. check if date is displayed 
		 checkDateIsDislayed();
		 
		// 6. verify the last Line string
		 verifyLastLine();

		System.out.println("Done.");
	}

	@AfterTest
	public void closeBroswer() {
		
		this.driver.quit();
	}

	
	public void checkIfFileExist() throws FileNotFoundException {
		if (file.exists()) {
			driver.get("file:///" + url);
			System.out.println("file is exist and entered to the page");
		} else {
			throw new FileNotFoundException("the file not found");
		}
	};
	
	public void verifyFirstLine(){
		WebElement firstLine = driver.findElement(By.xpath("/html/body/p[1]"));
		if (firstLine.isDisplayed()){
			System.out.println("verified the first Line string");	
			assertTrue(true);
		}
		else{
			System.out.println("not verified the first Line string");	
			assertTrue(false);
		}
		//assertEquals("Click the button to display the date.",firstLine.getText(), "Strings not matching");
	}
	public void verifyButtonText(){
		WebElement button = driver.findElement(By.tagName("button"));
		if (button.getText().equals("The time is?")) {
			System.out.println("the text on button is correct");
			assertTrue(true);
		} else {
			System.out.println("the text on button isn't correct");
			assertTrue(false);
		}
	}
	
		public void clickTheButton() {
			WebElement button = driver.findElement(By.tagName("button"));
			try {
				button.click();
				System.out.println("clicked on the " + "\"" + button.getText() + "\"" + " button");
				assertTrue(true);
			} catch (Exception e) {
				System.out.println("not clicked on the " + "\"" + button.getText() + "\"" + " button");
				assertTrue(false);
				e.printStackTrace();
			}	
	}
		public void checkDateIsDislayed(){
			WebElement dateInfo = driver.findElement(By.id("dateInfo"));
			if (dateInfo.isDisplayed()) {
				System.out.println("the date is displayed");
				assertTrue(true);
			} else {
				System.out.println("the date isn't displayed");
				assertTrue(false);
			}

		}
		public void verifyLastLine(){
			WebElement lastLine = driver.findElement(By.xpath("/html/body/h6"));
			if (lastLine.isDisplayed()){
				System.out.println("verified the last Line string");	
				assertTrue(true);
			}
			else{
				System.out.println("not verified the last Line string");	
				assertTrue(false);
			}
			//assertEquals("Click the button to display the date.",firstLine.getText(), "Strings not matching");
		}
}
