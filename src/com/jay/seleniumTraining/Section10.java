package com.jay.seleniumTraining;

import org.openqa.selenium.Keys;

public class Section10 {

	static String site = "https://www.amazon.ca/";

	public static void main(String[] args) throws InterruptedException {

		JST.openWindow(site);
		JST.openAndMaximizeSite();

		JST.fwaitUntilElementVisible(10, 2, "a[id='nav-link-accountList']", LocType.CSS);

		JST.mouseOver("a[id='nav-link-accountList']", LocType.CSS);


		JST.actionClick("twotabsearchtextbox", LocType.ID)
		.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().contextClick().build().perform();

	}

}
