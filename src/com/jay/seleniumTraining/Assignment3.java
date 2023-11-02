package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static WebDriver driver = new ChromeDriver();
	static int impWaitSecs = 0;
	static String site = "https://rahulshettyacademy.com/loginpagePractise/";
	static String pwd = "learning";
	static String uid = "rahulshettyacademy";

	static {
		initialize(impWaitSecs);
	}

	public static void initialize(int impWaitSecs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWaitSecs));
		driver.manage().window().maximize();
	}

	public static void main(String[] args) {

		openWindow(site);

		idSelect("username").sendKeys(uid);
		idSelect("password").sendKeys(pwd);
		cssSelect("input[value='user']").click();
		
		waitUntilElementVisibleViaId(5, "okayBtn");
		idSelect("okayBtn").click();

		
//		WebElement we = cssSelect("select");
//		Select drpdwn = new Select(we);
//		drpdwn.selectByVisibleText("Consultant");
//		System.out.println(drpdwn.getFirstSelectedOption().getText());
		
		xpathSelect("//select/option[@value='consult']").click();
		xpathSelect("//span[@class='text-white termsText']/a").click();
		
		idSelect("terms").click();
		idSelect("signInBtn").click();
		
		waitUntilElementClickableViaXpath(5, "//button[@class='btn btn-info']");
		
		List<WebElement> btns = xpathSelects("//button[@class='btn btn-info']");
		btns.forEach(btn -> {
			btn.click();
		});
		
		cssSelect("a.nav-link.btn.btn-primary").click();
		
		waitUntilElementClickableViaCSS(10, "button.btn.btn-success");
	
		cssSelect("button.btn.btn-success").click();
	}


	private static void waitUntilElementClickableViaId(int i, String path) {
		explicitlyWait(i).until(ExpectedConditions.elementToBeClickable(By.id(path)));		
	}

	private static void waitUntilElementClickableViaCSS(int i, String path) {
		explicitlyWait(i).until(ExpectedConditions.elementToBeClickable(By.cssSelector(path)));		
	}

	private static void waitUntilElementClickableViaXpath(int i, String path) {
		explicitlyWait(i).until(ExpectedConditions.elementToBeClickable(By.xpath(path)));		
	}

	
	public static void waitUntilElementVisibleViaCSS(int i, String path) {
		explicitlyWait(i).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(path)));
	}

	public static void waitUntilElementVisibleViaId(int i, String path) {
		explicitlyWait(i).until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
	}
	
	private static WebDriverWait explicitlyWait(int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		return wait;
	}

	private static void openWindow(String site) {
		driver.get(site);

		String temp = driver.getTitle();
		System.out.println(temp);
		temp = driver.getCurrentUrl();
		System.out.println(temp);
	}

	static WebElement cssSelect(String str) {
		return driver.findElement(By.cssSelector(str));
	}

	static WebElement xpathSelect(String str) {
		return driver.findElement(By.xpath(str));
	}

	static WebElement idSelect(String str) {
		return driver.findElement(By.id(str));		
	}

	
	static List<WebElement> cssSelects(String str) {
		return driver.findElements(By.cssSelector(str));
	}

	static List<WebElement> xpathSelects(String str) {
		return driver.findElements(By.xpath(str));
	}
}
