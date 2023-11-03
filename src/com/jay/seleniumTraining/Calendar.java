package com.jay.seleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
				
		String pickday = "5";
		String pickmth = "March";
		
		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		//open date picker
		Thread.sleep(3000);
		WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		date.click();
		Thread.sleep(500);
		
		//get current month
		
		WebElement elemmth = driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
		//if current month isnt picked month, click on next month btn
		while (driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains(pickmth)==false) {
			
			//JST.fwaitUntilElementVisible(5, 1, "//*[@id='form-field-travel_comp_date']", LocType.XPATH);	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			elemmth = driver.findElement(By.xpath("//div[@class='flatpickr-month']"));
		}
		
		//get days collection and iterate through them
		List<WebElement> days = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		WebElement elemday = null;
		
		
		String elemdaystr = "";
			//for each iteration, compare it against choice day
		for (int i=0;i<days.size();i++) {
			Thread.sleep(500);
			
			elemday = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"))
					.get(i);
			
			elemdaystr = elemday.getText();
			if (pickday.equalsIgnoreCase(elemdaystr)) {
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']"))
				.get(i).click();
				System.out.println("clicked " + pickday);
				break;
			} 
		}
		
		
		
	}

}
