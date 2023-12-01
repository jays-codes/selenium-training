package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
			
		//check 1st checkbox
		WebElement el = driver.findElement(By.id("checkBoxOption1"));
		el.click();
		//verify if checked
		System.out.println("selected: " + el.isSelected());
		
		//uncheck
		el.click();
		//verify if unchecked
		System.out.println("selected: " + el.isSelected());

		//count no of chkbox
		int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("num of chk box: " + count);
		
		//------------------------
		
		driver.close();
	}

}
