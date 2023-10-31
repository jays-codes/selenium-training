package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);

		String nameStr = "Jay";

		WebElement txtNm = driver.findElement(By.id("name"));
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));

		for (int i = 0; i < 10; i++) {
			txtNm.sendKeys(nameStr + i);
			alertBtn.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		// Thread.sleep(1000);
		// driver.switchTo().alert().accept();
	}

}
