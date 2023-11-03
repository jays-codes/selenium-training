package com.jay.seleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

//	static String url = "https://www.path2usa.com/travel-companion";
//	static WebDriver driver;
//
//	public static void main(String[] args) throws InterruptedException {
//
//	//WebDriverManager.chromedriver().setup();
//
//		driver = new ChromeDriver();
//		driver.get(url);
//		driver.manage().window().maximize();
//		Thread.sleep(10000);
//	
//		// Scroll the Page
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(428,1357)");
//	
//		// Click on the Date field
//		Thread.sleep(3000);
//		WebElement Date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
//	
//		// js.executeScript("arguments[0].scrollIntoView(true);", Date);
//		Date.click();	
//	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		String pickday = "29";
		//String pickmth = "September";
		
		//driver.findElement(By.xpath(".//input[@id='form-field-travel_comp_date']")).click();
		JST.driver = driver;
		//Thread.sleep(10000);
		JST.waitUntilElementVisible(10, "//*[@id='form-field-travel_comp_date']", LocType.XPATH);
		
		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		//open date picker
		JST.waitUntilElementClickable(10, "//*[@id='form-field-travel_comp_date']", LocType.XPATH);
		WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		date.click();
		
//		//get current month
//		JST.waitUntilElementClickable(3, "//div[@class='flatpickr-month']", LocType.XPATH);
//		WebElement elemmth = driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
//		//if current month isnt picked month, click on next month btn
//		while (elemmth.getText().contains(pickmth)==false) {
//			JST.waitUntilElementClickable(2, "//span[@class='flatpickr-next-month']", LocType.XPATH);
//			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
//			elemmth = driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
//		}
//			//iterate through months and pick 
		
		//get days collection and iterate through them
		List<WebElement> days = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		WebElement elemday = null;
		
			//for each iteration, compare it against choice day
		for (int i=0;i<days.size();i++) {
			elemday = days.get(i);
			if (pickday.equalsIgnoreCase(elemday.getText())) {
				elemday.click();
				System.out.println("clicked " + pickday);
				break;
			} 
		}
		
		
		
	}

}
