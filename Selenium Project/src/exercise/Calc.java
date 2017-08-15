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

public class Calc {
	WebDriver driver;
	File file;
	String url = "C:/Examples/calc.html";

	@FindBy(id="num1")
	private WebElement BillingRateTextBox;

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

		verifyTextPage();
		
		WebElement num1 = driver.findElement(By.id("num1"));
		WebElement num2 = driver.findElement(By.id("num2"));
		WebElement sum = driver.findElement(By.id("sum"));
		WebElement sub = driver.findElement(By.id("sub"));
		WebElement mult = driver.findElement(By.id("mult"));
		WebElement div = driver.findElement(By.id("div"));
		// clear all text box
		clearAllFields(num1, num2);
		//enter numbers to text box
		enterNumbers(num1,"6",num2,"3");
		//click on calculation and calculate
		clickOnCalculation();
		calc(num1,num2, sum,sub,mult,div);
		
		clearAllFields(num1, num2);
		enterNumbers(num1,"8",num2,"4");
		clickOnCalculation();
		calc(num1,num2, sum,sub,mult,div);

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
	public void clickOnCalculation() throws InterruptedException{
		WebElement click = driver.findElement(By.id("b1"));
		click.click();
		System.out.println("clicked on calc");
		Thread.sleep(4000);

	}

	public void enterNumbers(WebElement num1,String b1,WebElement num2,String b2) throws InterruptedException{

		//WebElement a1 = driver.findElement(By.id("num1"));
		//WebElement b1 = driver.findElement(By.id("num2"));
		num1.sendKeys(b1);
		num2.sendKeys(b2);
		System.out.println("numbers entered");
		Thread.sleep(3000);


	}
	public void clearAllFields(WebElement num1,WebElement num2){
		num1.clear();
		num2.clear();
		System.out.println("all fields cleared");
	}

	public void calc(WebElement num1,WebElement num2,WebElement sum1,WebElement sub1,WebElement mult1,WebElement div1){
		int temp,a,b,sum,sumCalc, sub, subCalc,mult,multCalc; 
		float div = 0, divCalc;
		//String sum1 = driver.findElement(By.id("sum")).getText();
		a = Integer.parseInt(num1.getAttribute("value"));
		b = Integer.parseInt(num2.getAttribute("value"));
		sumCalc = Integer.parseInt(sum1.getAttribute("value"));
		subCalc = Integer.parseInt(sub1.getAttribute("value"));
		multCalc = Integer.parseInt(mult1.getAttribute("value"));
		divCalc = Float.parseFloat(div1.getAttribute("value"));
		sum=a+b;
		sub=a-b;
		mult=a*b;

		try {
			div=a/b;
			
		} catch (ArithmeticException e1) {
			System.out.println("You tried to divied by zero");
			e1.printStackTrace();
		}
		if(sumCalc == sum){
			System.out.println("The sum is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The sum is not correct");
			assertTrue(false);
		}
		if(subCalc == sub){
			System.out.println("The sub is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The sub is not correct");
			assertTrue(false);
		}
		if(multCalc == mult){
			System.out.println("The mult is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The mult is not correct");
			assertTrue(false);
		}

		if(divCalc == div ){
			System.out.println("The div is correct");
			assertTrue(true);
		}
		else{
			System.out.println("The div is not correct");
			System.out.println(div);
			assertTrue(false);
		}
	} 


	public void verifyTextPage(){
		String text = driver.findElement(By.name("frm1")).getText();
		if(text.equals("first number second number\n\nsum\nsub\nmultiply\ndivision")){
			System.out.println("the text is correct");
			assertTrue(true);
		}
		else{
			System.out.println("the text is not correct");
			assertTrue(false);
		}
		
		
	}
	
}
