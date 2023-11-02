package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IteratingThroughWebElementCollection {

	public static WebDriver driver = new ChromeDriver();

	public static void intitialize(int impWaitSecs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWaitSecs));
		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws InterruptedException {

		int impWaitSecs = 5;
		String site = "https://rahulshettyacademy.com/seleniumPractise/#/";
		String promoCd = "rahulshettyacademy";

		List<String> veggies = new ArrayList<String>();
		veggies.add("Cucumber");
		veggies.add("Brocolli");
		veggies.add("Beetroot");

		intitialize(impWaitSecs);
		openWindow(site);

		pickAndAddToCart(veggies);
		checkout(promoCd);
	}

	private static void checkout(String promoCd) {
		
		//click shopping cart window
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		
		//click proceed to checkout
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		
		//enter promo code
		driver.findElement(By.cssSelector("")).sendKeys(promoCd);
	}

	private static void pickAndAddToCart(List<String> veggies) {
		// get collection
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		veggies.forEach(veggie -> {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().contains(veggie)) {
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					break;
				}
			}

		});
	}

	private static void openWindow(String site) {
		driver.get(site);

		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);
	}

}
