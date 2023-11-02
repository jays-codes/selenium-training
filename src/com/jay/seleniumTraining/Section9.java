package com.jay.seleniumTraining;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Section9 {

	static String site = "https://rahulshettyacademy.com/seleniumPractise/#/";
	static String promoCd = "rahulshettyacademy";

	public static void main(String[] args) throws InterruptedException {

		List<String> veggies = new ArrayList<String>();
		veggies.add("Cucumber");
		veggies.add("Brocolli");
		veggies.add("Beetroot");

		JaysSeleniumTools.openWindow(site);

		pickAndAddToCart(veggies);

		// click shopping cart window
		JaysSeleniumTools.getWebElement("a[class='cart-icon']", LocType.CSS).click();

		// click proceed to checkout
		JaysSeleniumTools.getWebElement("//div[@class='cart-preview active']/div/button", LocType.XPATH).click();

		// enter promo code and click apply
		JaysSeleniumTools.waitUntilElementVisible(5, "input[class='promoCode']", LocType.CSS);
		JaysSeleniumTools.getWebElement("input[class='promoCode']", LocType.CSS).sendKeys(promoCd);
		JaysSeleniumTools.getWebElement("button[class='promoBtn']", LocType.CSS).click();

		JaysSeleniumTools.fwaitUntilElementVisible(30, 3, "span.promoInfo", LocType.CSS);
	}


	public static void pickAndAddToCart(List<String> veggies) {
		// get collection
		List<WebElement> products = JaysSeleniumTools.getWebElements("h4[class='product-name']", LocType.CSS);

		veggies.forEach(veggie -> {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getText().contains(veggie)) {
					JaysSeleniumTools.getWebElements("//div[@class='product-action']/button", LocType.XPATH).get(i).click();
					break;
				}
			}
		});
	}

}
