package com.jay.seleniumTraining;

import java.util.Iterator;
import java.util.Set;


public class S88WindowHandles {

	static String site = "https://rahulshettyacademy.com/loginpagePractise/";

	public static void main(String[] args) throws InterruptedException {

		JST.openWindow(site);
		JST.openAndMaximizeSite();

		String path = "a[class='blinkingText']";
		JST.getWebElement(path, LocType.CSS).click();
		Set<String> windows = JST.driver.getWindowHandles();
		
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		
		JST.driver.switchTo().window(child);
	
		System.out.println(JST.getWebElement(".im-para.red", LocType.CSS).getText());
		JST.driver.switchTo().window(parent);
		JST.getWebElement("username", LocType.ID).sendKeys("email");

	}

}
