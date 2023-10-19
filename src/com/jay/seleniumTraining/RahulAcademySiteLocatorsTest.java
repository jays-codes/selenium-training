package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class RahulAcademySiteLocatorsTest {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
// Optional 
		WebDriver driver = new ChromeDriver();

//		//Firefox - using geckodriver
//		System.setProperty("webdriver.gecko.driver", "C:\\jay\\installed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

		// C:\jay\installed\edgedriver_win64
		// MS edge
//		System.setProperty("webdriver.edge.driver", "C:\\jay\\installed\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);

		// login error
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

		String errorTxt = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorTxt);

		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@yahoo.com");

//		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Rahul@yahoo.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("18008888888");
		// driver.findElement(By.xpath("//form/div/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		temp = driver.findElement(By.cssSelector("form p.infoMsg")).getText();
		System.out.println(temp);

		String pwd = getPwd(temp);

		// back to login page to submit correct login
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pwd);

		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();

		// driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

		Thread.sleep(1000);
		temp = driver.findElement(By.tagName("p")).getText();
		System.out.println(temp);
		Assert.assertEquals(temp, "You are successfully logged in.");

		String name = "rahul";
		temp = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(temp, "Hello " + name + ",");

		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
//		driver.close();
//		driver.quit();
	}

	private static String getPwd(String temp) {
		String[] pwdArr = temp.split("'");
		String[] pwd = pwdArr[1].split("'");
		return pwd[0];
	}

}
