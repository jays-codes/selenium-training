package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IteratingThroughWebElementCollection {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);

		// get collection
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		List<String> veggies = new ArrayList();
		veggies.add("Cucumber");
		veggies.add("Brocolli");
		veggies.add("Beetroot");

		veggies.forEach(veggie -> {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().contains(veggie)) {
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					break;
				}
			}

		});
	}

}
