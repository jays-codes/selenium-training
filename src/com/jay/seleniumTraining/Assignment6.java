package com.jay.seleniumTraining;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//select 1 chkbox, grab text/label

		WebElement labelpick = driver
				.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]"));
		
		String labelStr = labelpick.getAttribute("for");
		System.out.println(labelStr);
		
		WebElement chkbox = labelpick.findElement(By.id("checkBoxOption3"));
		chkbox.click();
				
		//goto drop down beside and pick based on selected chkbox
		WebElement elem = driver.findElement(By.tagName("select"));
		Select slc = new Select(elem);
		slc.selectByValue(chkbox.getAttribute("value"));
	
		//enter grabbed label txt to editbox
		driver.findElement(By.id("name")).sendKeys(labelStr);
		
		//click alert, verify if grabbed text is present in popup msg
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000L);
		Alert al = driver.switchTo().alert();
		String alerttxt = al.getText();
		if (alerttxt.contains(labelStr)) {
			System.out.println(labelStr + " is found in alert");
			al.accept();
		}
		
	}	
}
