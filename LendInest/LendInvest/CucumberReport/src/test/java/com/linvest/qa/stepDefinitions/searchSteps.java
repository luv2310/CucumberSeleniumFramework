package com.linvest.qa.stepDefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.linvest.qa.base.TestBase;
import com.linvest.qa.config.LoggerHelper;
import com.linvest.qa.util.*;

public class searchSteps {

	public static WebDriver driver;
	public static TestBase testbase = new TestBase();
	public static AssignLocatorOBJ locator = new AssignLocatorOBJ();
	public static TestUtilDemo keyword = new TestUtilDemo();
	public static String PRODUCTNAME = "emrald ring";
	public static Logger log = LoggerHelper.getLogger(LoggerHelper.class);

	@Given("I am a non-registered customer")
	public void i_am_a_non_registered_customer() 
	{
		// step is empty because no executon is required
	}

	@Given("I navigate to www.ebay.co.uk")
	public void i_navigate_to_www_ebay_co_uk() 
	{
		//browser initialization
		log.info("starting browser and launching application");
		driver=testbase.initialization();
	}

	@When("I search for an item")
	public void i_search_for_an_item() 
	{	
		//verify search and click for an element 
		log.info("search for "+PRODUCTNAME);
		keyword.isElementPresent(locator.searchBox);
		keyword.clearAnddoSendKeys(locator.searchBox, PRODUCTNAME);
		keyword.clickElement(locator.searchIcon);
	}

	@Then("I get a list of matching results")
	public void i_get_a_list_of_matching_results() 
	{
		//check correct page is coming by comparing it with the heading
		log.info("Assert the previous search");
		Assert.assertTrue(keyword.getTex(locator.searchPageHeading).contains(PRODUCTNAME));			
	}

	@Then("the resulting items cards show: postage price, No of bids,price or show BuyItNow tag")
	public void the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag() 
	{
		//verify card details are present accuratelly
		log.info("assert postage price, No of bids,price or show BuyItNow tag ");
		keyword.isElementPresent(locator.searchPostagePrice);
		Assert.assertTrue(keyword.isElementPresent(locator.searchBuyItNow) ||
				keyword.isElementPresent(locator.searchNumBids));				
	}

	@Then("I can sort the results by Lowest Price")
	public void i_can_sort_the_results_by_Lowest_Price() {

		//sort the price in lowest price order
		log.info("sort the results by Lowest Price");
		//click on expand filter
		keyword.clickElement(locator.searchExpandFilter);

		log.info("wait for element visibillity");
		keyword.waitTillVisibility(locator.searchExpandList, 5);

		//fetching all the ul li elements becaue of there dynamic nature
		List<WebElement> ele =  keyword.getWebElements(locator.searchExpandList);
		for(WebElement e : ele)
		{
			if (e.getText().toString().equalsIgnoreCase("Lowest price"))
			{
				//find lowest price element
				log.info("elemenet succesfully clicked...");
				//click using action class because of the dynamic nature
				keyword.clickWithAction(e);
				break;
			}
		}
	}

	@Then("the results are listed in the ascending in the correct order")
	public void the_results_are_listed_in_the_ascending_in_the_correct_orderr() 
	{ 
		// get all the price web elements
		List<WebElement> ele =  keyword.getWebElements(locator.searchitempricelist);
		//temparary assign first price index for comparing the sorting later own will store the previos value
		float firstIndexPrice = (float) 0.0;
		for(WebElement e : ele)
		{
			//to check if ele.text is not empty
			if(!e.getText().toString().isEmpty()) 
			{	
				float itemprice = Float.parseFloat(e.getText().toString().substring(1).replace(",",""));

				//verify if the order is ascending
				Assert.assertTrue(firstIndexPrice<=itemprice);		
				firstIndexPrice=itemprice;
			}
		}
	}



	@Then("I can sort the results by Highest Price")
	public void i_can_sort_the_results_by_Highest_Price() {

		//sort the price in Highst price order
		log.info("sort the results by Highest Price");

		//click on expand filter
		keyword.clickElement(locator.searchExpandFilter);

		log.info("wait for element visibillity");
		keyword.waitTillVisibility(locator.searchExpandList, 5);

		//fetching all the ul li elements becaue of there dynamic nature
		List<WebElement> ele =  keyword.getWebElements(locator.searchExpandList);
		for(WebElement e : ele)
		{
			if (e.getText().toString().equalsIgnoreCase("Highest price"))
			{
				//find lowest price element
				log.info("elemenet succesfully clicked...");
				//click using action class because of the dynamic nature
				keyword.clickWithAction(e);
				break;
			}
		}
	}

	@Then("the results are listed in the descending in the correct order")
	public void the_results_are_listed_in_the_descending_in_the_correct_order() 
	{ 
		// get all the price web elements
		List<WebElement> ele =  keyword.getWebElements(locator.searchitempricelist);
		//temparary assign first price index for comparing the sorting later on and will store the previos value
		for(int i=1;i<ele.size();i++)
		{ 
			// to check ele. text is not empty
			if(!ele.get(i).getText().toString().isEmpty() && 
					!ele.get(i-1).getText().toString().isEmpty()) 
			{	
				//convert the string in float and doing string preprocessing for further comparison
				float itemprice1 = Float.parseFloat(ele.get(i).getText().toString().substring(1).replace(",",""));
				float itemprice0 = Float.parseFloat(ele.get(i-1).getText().toString().substring(1).replace(",",""));
				Assert.assertTrue(itemprice0>=itemprice1);		
			}
		}
	}

	@Then("I can filter the results by mBuy it nowm")
	public void i_can_filter_the_results_by_mBuy_it_nowm() {
		//click on buy it now tag
		keyword.clickElement(locator.searchBuyItNow);	
	}

	@Then("all the results shown in the page have the mBuy it nowm tag")
	public void all_the_results_shown_in_the_page_have_the_mBuy_it_nowm_tag()
	{
		List<WebElement> ele = keyword.getWebElements(locator.searchBuyitnowtag);

		for (WebElement e : ele) 
		{
			Assert.assertTrue(e.getText().toString().contains("Buy"));
		}
		//assert all cards have buy it now tag
	}
}
