package com.jay.seleniumTraining;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class Section14_Streams {

	public static void main(String[] args) throws InterruptedException, IOException {

//		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();


		
		
	}
	
//	@Test
//	public void regular() {
//		List<String> fruits = new ArrayList<String>();
//		fruits.add("apple0");
//		fruits.add("banana0");
//		fruits.add("grape0");
//		fruits.add("mango0");
//		fruits.add("apple1");
//		fruits.add("banana1");
//		fruits.add("grape1");
//		fruits.add("mango1");
//		fruits.add("apple2");
//		fruits.add("banana2");
//		fruits.add("grape2");
//		fruits.add("mango2");
//		fruits.add("apple3");
//		fruits.add("banana3");
//		fruits.add("grape3");
//		fruits.add("mango3");
//		
//		
//		int count = 0;
//		for (int i=0;i<fruits.size();i++) {
//			if (fruits.get(i).startsWith("a")) {
//				count++;
//			}
//		}
//		
//		System.out.println(count);
//	}
	
	@Test
	public void streamFilter() {
		List<String> fruits = new ArrayList<String>();
		fruits.add("apple0");
		fruits.add("banana0");
		fruits.add("grape0");
		fruits.add("mango0");
		fruits.add("apple1");
		fruits.add("banana1");
		fruits.add("grape1");
		fruits.add("mango1");
		fruits.add("apple2");
		fruits.add("banana2");
		fruits.add("grape2");
		fruits.add("mango2");
		fruits.add("apple3");
		fruits.add("banana3");
		fruits.add("grape3");
		fruits.add("mango3");

		//int count=0;
		//int count = (int) 
		fruits.stream()
		.filter(s->s.startsWith("a"))
		.sorted()
		.map(s->s.toUpperCase())
		.forEach(s->{
			System.out.println(s);
		});
	
		//System.out.println("count: " + count);
	}
	
	public void anOperation(String str) {
		
	}
	
}
