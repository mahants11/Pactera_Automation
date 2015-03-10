package test;


import libraries.Global;

import org.junit.Test;

import pages.HomePage;
import pages.SearchPage;

public class WebAppPactera extends AbstractTestDriver {

	@Test
	public void tc001_should_open_pactera_homepage_verify_page() 
	{
		HomePage homePage =new HomePage(driver);
		homePage		  =homePage.navigatePactera();
		homePage		  =homePage.verifyPageTitle();
	}
	
	@Test
	public void tc002_should_open_pactera_homepage_and_search_a_string() 
	{
		HomePage homePage 		=new HomePage(driver);
		homePage				=homePage.navigatePactera();
		SearchPage searchPage	=homePage.search(Global.SEARCH_STRING);
		searchPage 				=searchPage.searchedText(Global.SEARCH_STRING);
	}

}
