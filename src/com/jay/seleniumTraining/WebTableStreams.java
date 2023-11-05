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

public class WebTableStreams {

//	public static void main(String[] args) throws InterruptedException, IOException {
//
//		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		driver.manage().window().maximize();
//		
//		//click on column
//		//capture elements into list
//		//make list of strings
//		//created sorted list out of original
//
//		
//		
//	}
	
	
	@Test
	public void streamFilter() {

		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture elements into list
		//make list of strings
		List<WebElement> orig = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> veglist = orig.stream().map(s->s.getText())
				.collect(Collectors.toList());
		
		veglist.stream().forEach(s->{
			System.out.println(s);
		});
		
		
		System.out.println("-----------------------------");		
		//created sorted list out of original
		List<String> sorted = veglist.stream().sorted()
				.collect(Collectors.toList());
		
		sorted.stream().forEach(s->{
			System.out.println(s);
		});

		
		Assert.assertTrue(veglist.equals(sorted));
	}
	
}
