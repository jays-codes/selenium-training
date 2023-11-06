package com.jay.seleniumTraining;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TakesScreenshot;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	
	@Test
	public void relativeLocator() {

		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement namebox = driver.findElement(By.cssSelector("input[name='name']"));
		String txt = driver.findElement(with(By.tagName("label")).above(namebox)).getText();
		
		//driver.findElement(By.xpath("//tr/th[1]")).click();
		

	}	
	
	
}
