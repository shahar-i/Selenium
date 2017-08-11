package exercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import junit.framework.Assert;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Hello {
	WebDriver driver;
	File file;
	String url = "C:/Examples/hello.html";

	@BeforeTest
	public void startTest() {
		
		driver = new ChromeDriver();
		file = new File(url);
	}

	@Test
	public void testHello() throws InterruptedException {

		// 1. go over hello.html page
		try {
			checkIfFileExist();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		// 2. verify left button text
		verifyLeftButtonText();

		// 3. click on the left button
		clickLeftButton();

		// 4. verify hello students text
		verifyHelloStudent();

		// 5. refresh the page
		refreshThePage();
		// verify right button text
		verifyRightButtonText();

		// 6. click on the left button
		clickRightButton();
		
		// 7. verify hello students text
		verifyHelloStudent();
		
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

	public void verifyLeftButtonText() {
		String leftButtonText = driver.findElement(By.xpath("html/body/input")).getAttribute("value");
		if (leftButtonText.equals("click here")) {
			System.out.println("verified left button text");
			assertTrue(true);
		} else {
			System.out.println("not verified left button text");
			assertTrue(false);
		}
	}

	public void clickLeftButton() {
		WebElement leftButton = driver.findElement(By.tagName("input"));
		try {
			leftButton.click();
			System.out.println("clicked on left button");
			assertTrue(true);
		} catch (Exception e) {
			System.out.println("not clicked on left button");
			assertTrue(false);
			e.printStackTrace();
		}
	}

	public void verifyHelloStudent() {
		WebElement helloStudents = driver.findElement(By.xpath("/html/body"));
		if (helloStudents.isDisplayed()) {
			System.out.println("the string " + helloStudents.getText() + " is display");
			assertTrue(true);
		} else {
			System.out.println("the string " + helloStudents.getText() + " is not display");
			assertTrue(false);
		}
	}

	public void verifyRightButtonText() {
		String rightButtonText = driver.findElement(By.tagName("button")).getText();
		if (rightButtonText.equals("Click Here")) {
			System.out.println("verified right button text");
			assertTrue(true);
		} else {
			System.out.println("not verified right button text");
			assertTrue(false);
		}
	}

	public void clickRightButton() {
		WebElement rightButton = driver.findElement(By.tagName("button"));
		try {
			rightButton.click();
			System.out.println("clicked on left button");
			assertTrue(true);
		} catch (Exception e) {
			System.out.println("not clicked on left button");
			assertTrue(false);
			e.printStackTrace();
		}
	}
	public void refreshThePage(){
		driver.navigate().refresh();
		System.out.println("the page refreshed");
	}
}
