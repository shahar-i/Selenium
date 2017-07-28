package aaa;

import junit.framework.Assert;

import java.io.File;

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
import com.thoughtworks.selenium.webdriven.commands.Click;

public class NewTest {
	WebDriver  driver=null;
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test;			  		 		
	
	
	
  @BeforeTest
  public void startTest(){
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  extent.setSystemInfo("WIN", "10");
	  htmlReporter.config().setDocumentTitle("hschasjkchsaicaosi");
	  htmlReporter.config().setReportName("cdcsccs");
	  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	  htmlReporter.config().setTheme(Theme.DARK);
  }
	
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver= new ChromeDriver();
	  test = extent.createTest("f","cscscacascva");
	  test.log(Status.INFO, "11111111111111111111111111111");
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		//Thread.sleep(5000); 
		WebElement search= driver.findElement(By.xpath("//*[@id='From_today.27s_featured_article']"));
		Thread.sleep(5000);
		String txt= search.getText();
		if(txt.equals("From today's featured article"))
		{	
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
		
  
  }
	@AfterTest
	public void closeBroswer() {
		extent.flush();
		this.driver.quit();
	}
	  
  
}
