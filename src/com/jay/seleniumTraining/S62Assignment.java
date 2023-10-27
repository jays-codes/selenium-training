package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class S62Assignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);

		//check 1st chkbox
		WebElement chkbx1 = driver.findElement(By.id("checkBoxOption1"));
		if (chkbx1.isSelected()==false) chkbx1.click();
		Assert.assertTrue(chkbx1.isSelected());
		
		chkbx1.click();
		Assert.assertFalse(chkbx1.isSelected());
		
		List<WebElement> chkbxs = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		
		int chkbxCount = chkbxs.size();
		System.out.println("No. of checkboxes: " + chkbxCount);
		
	}

}
