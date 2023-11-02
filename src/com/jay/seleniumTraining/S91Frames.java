package com.jay.seleniumTraining;

import org.openqa.selenium.WebElement;

public class S91Frames {

	static String site = "https://jqueryui.com/droppable/";

	public static void main(String[] args) throws InterruptedException {

		JST.openWindow(site);
		JST.openAndMaximizeSite();
		
		
		JST.driver.switchTo().frame(JST.getWebElement("iframe[class='demo-frame']", LocType.CSS));
		WebElement elem = JST.getWebElement("draggable", LocType.ID);
		WebElement target = JST.getWebElement("droppable", LocType.ID);
		elem.click();
		
		JST.getAc().clickAndHold().dragAndDrop(elem, target).build().perform();
	}

}
