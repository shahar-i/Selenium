package com.shahar.pages;

import static org.junit.Assert.*;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFirstTest {

	private static FirefoxDriver driver; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	driver=new FirefoxDriver();
	}



	@Test
	public void test() throws InterruptedException {
		driver.get("http://toolsqa.com/automation-practice-form/");
		 driver.findElementByName("firstname").sendKeys("Shahar");
		 driver.findElementByName("lastname").sendKeys("Ismah-moshe");
		 driver.findElementById("sex-0").click();
		 Thread.sleep(10000);
		 
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	driver.close();
	}

}
