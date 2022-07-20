$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/searchPage.feature");
formatter.feature({
  "name": "Feature to run ebay search result scenario\u0027s",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search and verify results",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I am a non-registered customer",
  "keyword": "Given "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_am_a_non_registered_customer()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to www.ebay.co.uk",
  "keyword": "And "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_navigate_to_www_ebay_co_uk()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for an item",
  "keyword": "When "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_search_for_an_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get a list of matching results",
  "keyword": "Then "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_get_a_list_of_matching_results()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the resulting items cards show: postage price, No of bids,price or show BuyItNow tag",
  "keyword": "And "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.the_resulting_items_cards_show_postage_price_No_of_bids_price_or_show_BuyItNow_tag()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can sort the results by Lowest Price",
  "keyword": "Then "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_can_sort_the_results_by_Lowest_Price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results are listed in the ascending in the correct order",
  "keyword": "And "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.the_results_are_listed_in_the_ascending_in_the_correct_orderr()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can sort the results by Highest Price",
  "keyword": "Then "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_can_sort_the_results_by_Highest_Price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the results are listed in the descending in the correct order",
  "keyword": "And "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.the_results_are_listed_in_the_descending_in_the_correct_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can filter the results by mBuy it nowm",
  "keyword": "Then "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.i_can_filter_the_results_by_mBuy_it_nowm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all the results shown in the page have the mBuy it nowm tag",
  "keyword": "And "
});
formatter.match({
  "location": "com.linvest.qa.stepDefinitions.searchSteps.all_the_results_shown_in_the_page_have_the_mBuy_it_nowm_tag()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat com.linvest.qa.stepDefinitions.searchSteps.all_the_results_shown_in_the_page_have_the_mBuy_it_nowm_tag(searchSteps.java:177)\r\n\tat ✽.all the results shown in the page have the mBuy it nowm tag(file:///C:/Users/luvme/OneDrive/Desktop/LendInest/LendInvest/CucumberReport/src/test/resources/features/searchPage.feature:14)\r\n",
  "status": "failed"
});
});