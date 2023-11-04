package com.jay.seleniumTraining;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TakesScreenshot;

public class LinkChecker {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\jay\\installed\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		List<WebElement> sections = driver
				.findElements(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul"));
		
		URL urlobj = null;
		HttpURLConnection conn = null;
		String error = "";
		SoftAssert a = new SoftAssert();
		
		for (WebElement section : sections){
			List<WebElement> urls = section.findElements(By.tagName("a"));
			
			for (int i=1;i<urls.size();i++) {
				String url2chk = urls.get(i).getAttribute("href");

				urlobj = new URL(url2chk);
				conn = (HttpURLConnection) urlobj.openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int rscode = conn.getResponseCode();
				System.out.println(rscode);
				a.assertTrue(rscode<400, "url:" + url2chk + "\nresponse: " + rscode);
				conn.disconnect();
			}
		}
		a.assertAll();
	}
}
