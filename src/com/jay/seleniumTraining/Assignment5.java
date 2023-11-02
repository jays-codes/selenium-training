package com.jay.seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	static String site = "https://the-internet.herokuapp.com/";
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get(site);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//go to top frame
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		String text = driver.findElement(By.id("content")).getText();
		System.out.println(text);
		
	}
}
