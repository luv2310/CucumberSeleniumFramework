package com.linvest.qa.util;
import org.openqa.selenium.By;

public class AssignLocatorOBJ {

	

	// search page elements 
	public static By searchBox = By.id("gh-ac");
	public static By searchIcon = By.id("gh-btn");
	public static By searchPageHeading = By.xpath("//h1[@class=\"srp-controls__count-heading\"]");
	public static By searchPostagePrice = By.xpath("//span[@class=\"s-item__shipping s-item__logisticsCost\"]");
	public static By searchBids = By.xpath("//span[contains(text(),\"bids\")]");
	public static By searchNumBids = By.xpath("//span[@class=\"s-item__bids s-item__bidCount\"]");
	public static By searchExpandFilter = By.xpath("(//div[@class=\"srp-sort srp-sort--filter-evolution\"]//span[@class=\"expand-btn__cell\"])");
	public static By searchExpandList = By.xpath("//div[@class=\"srp-sort srp-sort--filter-evolution\"]//ul[@class=\"fake-menu__items\"]//li");
	public static By searchLowestPrice = By.xpath("//span[contains(text(),\"Lowest price\")]");
	public static By searchitempricelist = By.xpath("(//span[@class=\"s-item__price\"])");
	public static By searchBuyItNow = By.xpath("//span[@class=\"srp-format-tabs-h2\"][contains(text(),\"Buy\")]");
	public static By searchBuyitnowtag = By.xpath("//span[@class=\"s-item__purchase-options-with-icon\"]");
//	public static By searchPageHeadin = By.xpath("");

}
