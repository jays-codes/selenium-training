package com.jay.seleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RahulSitePracticePageTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		//Firefox - using geckodriver
//		System.setProperty("webdriver.gecko.driver", "C:\\jay\\installed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

//		// C:\jay\installed\edgedriver_win64
//		// MS edge
//		System.setProperty("webdriver.edge.driver", "C:\\jay\\installed\\edgedriver_win64\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
		
		temp = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(temp);

		temp = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

		
	}

}
