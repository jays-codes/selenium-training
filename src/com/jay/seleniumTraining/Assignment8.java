package com.jay.seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// enter 3 letters, pick a country
		WebElement txtfield = driver.findElement(By.id("autocomplete"));
		
		txtfield.sendKeys("tur");
		Thread.sleep(500);
		
		txtfield.sendKeys(Keys.DOWN);
		txtfield.sendKeys(Keys.DOWN);
		
		String pick = driver.findElement(By.id("autocomplete")).getAttribute("value");
		System.out.println("pick: " + pick);
	}
}
