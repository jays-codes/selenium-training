package com.jay.seleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S241UploadFiles {

	static String site = "https://www.pdf2go.com/pdf-to-jpg";
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get(site);
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("button[class*='vue-upload']")).click();
		

	}

}
