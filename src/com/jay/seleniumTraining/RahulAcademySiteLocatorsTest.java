package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RahulAcademySiteLocatorsTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		
		String errorTxt = driver.findElement(By.cssSelector("p.error")).getText();
		
		
		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);
		System.out.println(errorTxt);
		
//		driver.close();
//		driver.quit();
	}

}
