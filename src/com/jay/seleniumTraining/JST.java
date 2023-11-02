package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JST {

	public static WebDriver driver=null;
	public static Actions ac = null;	
	
	public static void openAndMaximizeSite() {
		driver.manage().window().maximize();		
	}
	
	public static void setImplicitWait(int impWaitSecs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWaitSecs));
	}

	public static void openWindow(String site) {
		if (driver==null) driver= new ChromeDriver();
		driver.get(site);
		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);
		driver.navigate().refresh();
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

	public static List<WebElement> getWebElements(String path, LocType loctype) {
		return driver.findElements(getBy(path, loctype));
	}

	public static void waitUntilElementVisible(int i, String path, LocType loctype) {
		explicitlyWait(i).until(ExpectedConditions.visibilityOfElementLocated(getBy(path, loctype)));
	}

	public static void fwaitUntilElementVisible(int total, int intv, String path, LocType loctype) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(intv)).ignoring(NoSuchElementException.class);

		WebElement elem = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement elem = getWebElement(path,loctype);
				if (elem.isDisplayed()) {
					return elem;					
				} else {
					return null;
				}
			}
		});
	}

	public static WebDriverWait explicitlyWait(int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		return wait;
	}
	
	public static Actions getAc() {
		if (ac==null) {
			ac = new Actions(driver);
		}
		return ac;
	}
	
	public static void mouseOver(String path, LocType type) {
		
		getAc().moveToElement(getWebElement(path,type)).build().perform();
	}
	
	public static Actions actionClick(String path, LocType type) {
		return getAc().moveToElement(getWebElement(path,type)).click();
	}

	public static Actions rightClick(String path, LocType type) {
		return getAc().moveToElement(getWebElement(path,type)).contextClick();
	}

}
