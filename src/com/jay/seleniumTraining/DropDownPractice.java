package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
		
		WebElement we = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdwn = new Select(we);
		dropdwn.selectByIndex(3);

		temp = dropdwn.getFirstSelectedOption().getText();
		Assert.assertEquals(temp, "USD");

		driver.findElement(By.id("divpaxinfo")).click();
		//Thread.sleep(1000);
		WebElement addAdultBtn = driver.findElement(By.id("hrefIncAdt"));
		for (int i=0;i<5;i++) {
			addAdultBtn.click();
		}
		driver.findElement(By.id("hrefIncChd")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

}
