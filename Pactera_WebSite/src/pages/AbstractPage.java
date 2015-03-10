package pages;

import libraries.Global;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	protected WebDriver driver;

	public AbstractPage (WebDriver driver)
	{
		this.driver =driver;
	}
	
	public HomePage navigatePactera()
	{
		driver.navigate().to(Global.BaseURL);
		return new HomePage(driver);
	}
}