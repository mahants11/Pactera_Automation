package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends AbstractPage {

	public SearchPage (WebDriver driver)
	{
		super(driver);
	}

	/* Method Name 	: searchedText
	 Description	:  Compare the searched text with actual value
	 */

	public SearchPage searchedText(String text)
	{
		String message =driver.findElement(By.xpath("//*[@id='content']/p[1]/em/strong")).getText();

		if(message.equals(text))
		{
			//Following can be written in log/result file,used for command line  display
			System.out.println("tc_002:PASSED:Searched String is present in the page");
		}
		else 
		{
			{
				//Following can be written in log/result file,used for command line  display
				System.out.println("tc_002:FAILED:Searched String is not present in the page");
			}
		}

		return new SearchPage (driver);
	}


}
