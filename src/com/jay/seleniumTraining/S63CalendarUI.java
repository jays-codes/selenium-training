package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class S63CalendarUI {

	/*
	 * S63
	 * S64: validating UI elements if enabled or disabled with attibutes
	 * */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
		
		//select roundtrip
		WebElement btn = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		if (btn.isSelected()==false) {
			System.out.println("rountrip is not selected.");
			btn.click();
		}
		
		//choose departure
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		//choose arrival
		//open depart date
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		Thread.sleep(1500);

		//choose current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		/*
		 * Comparing attributes
		 * */
		temp = driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(temp);
		//click one-way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		temp = driver.findElement(By.id("Div1")).getAttribute("style");
		System.out.println(temp);
		
		
		//open return date
		//choose return date

	}

}
