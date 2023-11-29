package com.jay.seleniumTraining;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowpopup {

	static String site = "http://admin:admin@the-internet.herokuapp.com/";
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get(site);
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Basic Auth")).click();
		

	}


}
