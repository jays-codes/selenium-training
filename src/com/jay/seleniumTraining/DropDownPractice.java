package com.jay.seleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String temp = driver.getTitle();
		System.out.println(temp);

		temp = driver.getCurrentUrl();
		System.out.println(temp);
		
		WebElement we = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdwn = new Select(we);
		dropdwn.selectByIndex(3);

		temp = dropdwn.getFirstSelectedOption().getText();
		Assert.assertEquals(temp, "USD");

		driver.findElement(By.id("divpaxinfo")).click();
		//Thread.sleep(1000);
		WebElement addAdultBtn = driver.findElement(By.id("hrefIncAdt"));
		for (int i=0;i<5;i++) {
			addAdultBtn.click();
		}
		driver.findElement(By.id("hrefIncChd")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Chennai (MAA)')]")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		
//		//via dynamic, using index
//		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		
		//via parent child xpath
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		//auto suggest dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();break;
			}
		}
		
//		//click on checkboxes
//		WebElement fnf = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
//		if (fnf.isSelected()==false) {
//			fnf.click();
//		}
//		
		//iterate and click on all chkboxes
		//note: below doesn't work as there's conditions for the other chkboxes to be clickable
//		List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		for (WebElement chxbx : chkboxes) {
//			if (chxbx.isSelected()==false) {
//				chxbx.click();
//			}
//		}
		
		//iterate on all chkboxes and do assertions
		//note: below doesn't work as there's conditions for the other chkboxes to be clickable
		List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement chxbx : chkboxes) {
			Assert.assertEquals(chxbx.isSelected(), false);
		}		
	}

}
