package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
			
		String name = "Jay";
		String email = "zaimenorca@gmail.com";
		String pwd = "hellorahul123";
		String myGender = "Male";
		String dob = "19800101";
		
		
		//fill name
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(name);
		
		//fill email
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		
		//fill pwd
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(pwd);

		//tick chkbox
		driver.findElement(By.id("exampleCheck1")).click();
		
		//select gender
		WebElement elem = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genders = new Select(elem);
		genders.selectByVisibleText(myGender);
		
		//select emp status
		driver.findElement(By.cssSelector("input[value='option2']")).click();

		//dob
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys(dob);

		//click submit
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		temp = driver.findElement(By.cssSelector("div.alert.alert.alert-success.alert-dismissible")).getText();
		System.out.println(temp);
		
		driver.close();
	}

}
