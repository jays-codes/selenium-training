package com.jay.seleniumTraining;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Section11 {

	static String site = "https://www.qaclickacademy.com/practice.php";

	public static void main(String[] args) throws InterruptedException {

		JST.openWindow(site);
		JST.openAndMaximizeSite();

		int count = JST.driver.findElements(By.xpath("//a")).size();

		System.out.println("link count:" + count);
		// give links count of the page

		int count2 = JST.driver.findElements(By.tagName("a")).size();

		System.out.println("link count2:" + count2);
		// give links count of the page

		WebElement footerDiv = JST.driver.findElement(By.id("gf-BIG"));
		int count3 = footerDiv.findElements(By.tagName("a")).size();
		System.out.println("link count3:" + count3);

		WebElement footersecDiv = footerDiv.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int count4 = footersecDiv.findElements(By.tagName("a")).size();
		System.out.println("link count4:" + count4);

		// check all link for particular section is working
		List<WebElement> links = footersecDiv.findElements(By.tagName("a"));
		System.out.println("link count:" + count4);

		// Actions ac = new Actions(JST.driver);

		for (int i = 0; i < count4; i++) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			// ac.moveToElement(links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
			footersecDiv.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
		}

		// get title of open tabs
		Set<String> windowStrs = JST.driver.getWindowHandles();
		System.out.println("tabs open: " + windowStrs.size());
		
		Iterator<String> iter = windowStrs.iterator();
		
		
		while (iter.hasNext()) {
			JST.driver.switchTo().window(iter.next());
			System.out.println("title: " + JST.driver.getTitle());
			
		}
		
//		WebElement ele = JST.driver..findElement(null);
//		ele.
	}

}
