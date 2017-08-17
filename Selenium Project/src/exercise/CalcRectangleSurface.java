package aaa;

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
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
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

public class CalcRectangleSurface {
	WebDriver driver;
	File file;
	String url = "C:/Examples/calaRectangleSurface.html";



	@BeforeTest
	public void initTest() {

		driver = new FirefoxDriver();
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

		// 2. verify the text page

		//verifyTextPage();
		
		WebElement num1 = driver.findElement(By.id("width"));
		WebElement num2 = driver.findElement(By.id("height"));

		WebElement mult = driver.findElement(By.id("surface"));
	
		// clear all text box
		clearAllFields(num1, num2);
		//enter numbers to text box
		enterNumbers(num1,"6",num2,"3");
		//click on calculation and calculate
		clickOnCalculation();
		calc(num1,num2,mult);
		
		clearAllFields(num1, num2);
		enterNumbers(num1,"8",num2,"4");
		clickOnCalculation();
		calc(num1,num2,mult);

		System.out.println("Done.");
	}



	@AfterTest
	public void closeBroswer() {

		this.driver.quit();
	}

	public void checkIfFileExist() throws FileNotFoundException {
		if (file.exists()) {
			driver.get("file:///" + url);
			System.out.println("The file is exist and entered to the page");
		} else {
			throw new FileNotFoundException("The file not found");
		}
	};

	public void verifyFirstLine(){
		WebElement firstLine = driver.findElement(By.xpath("/html/body/p[1]"));
		if (firstLine.isDisplayed()){
			System.out.println("Verified the first Line string");	
			assertTrue(true);
		}
		else{
			System.out.println("Not verified the first Line string");	
			assertTrue(false);
		}
		//assertEquals("Click the button to display the date.",firstLine.getText(), "Strings not matching");
	}
	
	public void clickOnCalculation() throws InterruptedException{
		WebElement click = driver.findElement(By.xpath("html/body/form/input[3]"));
		click.click();
		System.out.println("Clicked on calc");
		Thread.sleep(4000);

	}

	public void enterNumbers(WebElement num1,String b1,WebElement num2,String b2) throws InterruptedException{

		//WebElement a1 = driver.findElement(By.id("num1"));
		//WebElement b1 = driver.findElement(By.id("num2"));
		num1.sendKeys(b1);
		num2.sendKeys(b2);
		System.out.println("Numbers entered");
		Thread.sleep(3000);


	}
	
	public void clearAllFields(WebElement num1,WebElement num2){
		num1.clear();
		num2.clear();
		System.out.println("All fields cleared");
	}

	public void calc(WebElement num1,WebElement num2,WebElement mult1){
		int a,b,mult,multCalc; 
		
		//String sum1 = driver.findElement(By.id("sum")).getText();
		a = Integer.parseInt(num1.getAttribute("value"));
		b = Integer.parseInt(num2.getAttribute("value"));
		
		multCalc = Integer.parseInt(mult1.getAttribute("value"));
		
		mult=a*b;

		if(multCalc == mult){
			System.out.println("The mult is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The mult is not correct");
			assertTrue(false);
		}

	
	} 

	public void verifyTextPage(){
		String text = driver.findElement(By.name("frm1")).getText();
		if(text.equals("first number second number\n\nsum\nsub\nmultiply\ndivision")){
			System.out.println("The text is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The text is not correct");
			assertTrue(false);
		}
		
		
	}
	
}
