package com.jay.seleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	
	public static void main(String[] args) throws InterruptedException {

		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.path2usa.com/travel-companion/");
		//driver.manage().window().maximize();
		
		JST.openWindow("https://www.path2usa.com/travel-companion/");
		JST.openAndMaximizeSite();
		
		String pickday = "5";
		String pickmth = "October";
		
		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor)JST.driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		//open date picker
		JST.fwaitUntilElementVisible(10, 3, "//*[@id='form-field-travel_comp_date']", LocType.XPATH);
		Thread.sleep(3000);
		WebElement date = JST.driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		date.click();
		Thread.sleep(500);
		
		//get current month
		
		WebElement elemmth = JST.driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
		//if current month isnt picked month, click on next month btn
		while (JST.driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains(pickmth)==false) {
			
			//JST.fwaitUntilElementVisible(5, 1, "//*[@id='form-field-travel_comp_date']", LocType.XPATH);	
			Thread.sleep(1000);
			JST.driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			elemmth = JST.driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
		}
		
		//get days collection and iterate through them
		List<WebElement> days = JST.driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		WebElement elemday = null;
		
		
		String elemdaystr = "";
			//for each iteration, compare it against choice day
		for (int i=0;i<days.size();i++) {
			Thread.sleep(500);
			
			elemday = JST.driver.findElements(By.xpath("//span[@class='flatpickr-day ']"))
					.get(i);
			
			elemdaystr = elemday.getText();
			if (pickday.equalsIgnoreCase(elemdaystr)) {
				JST.driver.findElements(By.xpath("//span[@class='flatpickr-day ']"))
				.get(i).click();
				System.out.println("clicked " + pickday);
				break;
			} 
		}
		
		
		
	}

}
