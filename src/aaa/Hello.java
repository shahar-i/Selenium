package aaa;

import static org.testng.Assert.assertEquals;
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
	WebDriver  driver;
	File file; 		 		
	
	
	
  @BeforeTest
  public void startTest(){
	  driver= new ChromeDriver();
	  file = new File("C:/Examples/hello.html");
  }
  
  @Test
  public void testHello() throws InterruptedException, FileNotFoundException {
	  //1. go over hello.html page
	  	 
		  if(file.exists()){
		  driver.get("file:///C:/Examples/hello.html");
		  System.out.println("entered to the page");
		  }
		  else{
			  throw new FileNotFoundException();
		  }
	  
	  //2. click on the left button
	  WebElement leftButton = driver.findElement(By.tagName("input"));
	  leftButton.click();
	  System.out.println("clicked on left button");
	  
	  //3. verify hello students text
	  WebElement helloStudents = driver.findElement(By.xpath("/html/body"));
	  //  verifyHelloStudents(helloStudents);
	  helloStudents.isDisplayed();
	  //  if(helloStudentsLabel.equals("Hello Students")){
	  
	  //4. return back
	  
	  driver.navigate().refresh();

	  //5. click on the left button
	  WebElement rightButton = driver.findElement(By.tagName("button"));
	  rightButton.click();
	  System.out.println("clicked on right button");
	  WebElement helloStudents2 = driver.findElement(By.xpath("/html/body"));
	  //  verifyHelloStudents(helloStudents);
	  
	  //5. verify hello students text
	  helloStudents2.isDisplayed();
	 
	//  }
  }
  /*
  	public void verifyHelloStudents(WebElement helloStudents) throws InterruptedException{
  	  Thread.sleep(6000);
  	  String helloStudentsText = helloStudents.getText();  
  	  assertEquals(helloStudentsText, "Hello Students");
  	  System.out.println("verify text hello students");
  	}*/
  	
	@AfterTest
	public void closeBroswer() {
		this.driver.quit();
	}
	  
  
}