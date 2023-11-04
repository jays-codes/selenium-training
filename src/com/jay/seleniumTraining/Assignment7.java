package com.jay.seleniumTraining;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment7 {

//	public static void main(String[] args) throws InterruptedException {
//		
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,500)");
//		
//		//Thread.sleep(2000);
//		//print #rows in table
//		List<WebElement> rows = driver
//				.findElements(By.cssSelector("table[name='courses'] tr"));
//		System.out.println("rows: " + rows.size());
//		
//		List<WebElement> cols = rows.get(0).findElements(By.tagName("th"));
//		
//		//#columns
//		System.out.println("cols: " +cols.size());
//		
//		//print 2nd row of data
//		List<WebElement> row2 = rows.get(2).findElements(By.tagName("td"));
//		
//		for(int i=0;i<row2.size();i++) {
//			System.out.println(row2.get(i).getText());
//		}
//	}	

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		WebElement table = driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());

		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());

	}

}
