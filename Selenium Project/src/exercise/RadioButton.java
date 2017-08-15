package aaa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import junit.framework.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

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
	File file;
	String url = "C:/Examples/radiobutton.html";


	@BeforeTest
	public void initTest() {
		driver = new FirefoxDriver();
		file = new File(url);

	}

	@Test
	public void testRadioButton() throws InterruptedException {

		// 1. go over displayDate.html page
		try {
			checkIfFileExist();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		// 2. verify the first Line string
		//assertEquals("For what \"text-align\" feature is used ?",firstLine.getText(), "Strings not matching");
		//System.out.println("verified the first Line string");
	
		verifyFirstLine();
		
		//3. verify text page  
		verifyTextPage();
		// verify the correct answer
		List<WebElement>  oRadioButton = driver.findElements(By.name("r"));
		int iSize = oRadioButton.size(); 
		WebElement  correctAnswer = driver.findElement(By.id("answer1"));

		for(int i=0;i<iSize;i++){
			oRadioButton.get(i).click();
			if(oRadioButton.get(i).isSelected()){
				if(correctAnswer.getText().equals("Try Again"))
					System.out.println("try again");
			
			else{
				System.out.println("Correct Answer");

			}

			// String sValue = oRadioButton.get(i).toString();
		}
		//System.out.println(oRadioButton.);
	}

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
	public void verifyTextPage(){
		String text = driver.findElement(By.name("frm")).getText();
		if(text.equals("Set the text size\nSet the text font\nSet text color\nSet text alignment")){
			System.out.println("the text is correct");
			assertTrue(true);
		}
		else{
			System.out.println("the text is not correct");
			assertTrue(false);
		}
	}
	public void clickOnClear(){
		WebElement clearButton = driver.findElement(By.name("b1"));

		try {
			clearButton.click();
			System.out.println("clicked on clear");
			assertTrue(true);
		} catch (Exception e) {
			System.out.println("not clicked on clear");
			assertTrue(false);
			e.printStackTrace();
		}
		
	}
	public void verifyTextButton(){
		WebElement clearButton = driver.findElement(By.name("b1"));

		if(clearButton.getAttribute("value").equals("")){
			System.out.println("the text on button is correct");
			assertTrue(true);
		}
		else{
			System.out.println("the text on button is not correct");
			assertTrue(false);
			
		}
	}
	
	
}
