package com.jay.seleniumTraining;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TakesScreenshot;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class MultipleWindows {

	
	@Test
	public void relativeLocator() throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//open a new tab
		//driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iter = handles.iterator();
		String parent = iter.next();
		String child = iter.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");
		Thread.sleep(2000);
		
		String course = driver
				.findElements(
						By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")
				)
				.get(1).getText();
		
		driver.close();
		
		driver.switchTo().window(parent);
		WebElement nameEl = driver.findElement(By.cssSelector("input[name='name']"));
		nameEl.sendKeys(course);
		
//		screenshot 
//		File namess = driver.findElement(with(By.tagName("div")).above(nameEl)).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(namess, new File("C:\\Users\\zai_m\\selenium\\screenshot4.png"));
		
		//getHeight and Width
		nameEl.getRect().getDimension().getHeight()
		
		driver.close();
	}	
	
	
}
