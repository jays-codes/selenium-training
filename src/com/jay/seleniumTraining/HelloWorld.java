package com.jay.seleniumTraining;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class HelloWorld {

	public static void main(String[] args) {
		
	//invoke browser
	
		//ChromeDriver
//		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
//		//Firefox - using geckodriver
//		System.setProperty("webdriver.gecko.driver", "C:/jay/installed/geckodriver-v0.33.0-win64/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
//		//Firefox - using geckodriver
//		System.setProperty("webdriver.gecko.driver", "C:\\jay\\installed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//C:\jay\installed\edgedriver_win64
//		//MS edge
		System.setProperty("webdriver.edge.driver", "C:\\jay\\installed\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com");
		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);
		driver.close();
		driver.quit();
		
	}
}
