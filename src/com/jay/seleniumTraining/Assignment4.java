package com.jay.seleniumTraining;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	static String site = "https://the-internet.herokuapp.com/";
	public static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.get(site);
		driver.manage().window().maximize();

		getWebElement("a[href='/windows']", LocType.CSS).click();
		getWebElement("a[href='/windows/new']", LocType.CSS).click();


		Set<String> windows = driver.getWindowHandles();

		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();

		driver.switchTo().window(child);

		getWebElement("h3", LocType.CSS).click();

		String toPrint = getWebElement("h3", LocType.CSS).getText();
		System.out.println(toPrint);

		driver.switchTo().window(parent);
		toPrint = getWebElement("h3", LocType.CSS).getText();
		System.out.println(toPrint);

	}

	public static By getBy(String path, LocType type) {
		By locator = null;
		switch (type) {
		case ID:
			locator = By.id(path);
			break;
		case CSS:
			locator = By.cssSelector(path);
			break;
		case XPATH:
			locator = By.xpath(path);
			break;
		default:
			break;
		}

		return locator;
	}

	public static WebElement getWebElement(String path, LocType loctype) {
		return driver.findElement(getBy(path, loctype));
	}

}
