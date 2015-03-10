package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/* Method Name 	: search
	 Description	:  Enter Search keyword and hit submit
	 */
	public SearchPage search(String text)
	{
		//Enter keyword
		driver.findElement(By.id("s")).sendKeys(text);

		//Submit button
		driver.findElement(By.id("searchsubmit")).click();
		return new SearchPage(driver);
	}

	/* Method Name 	: getHomePageText
	 Description	: get the text in home
	 */
	public String getHomePageText()

	{
		String message= driver.getTitle();
		return message;
	}

	/* Method Name 	: verifyPageTitle
	 Description	: Compare the page title with expected title.
	 */

	public HomePage verifyPageTitle()
	{
		if((getHomePageText()
				.contains("Global IT Consulting, Solution, and Outsourcing Services from Pactera")))
		{
			//Following can be written in log/result file,used for command line  display
			System.out.println("tc_001:PASSED:Pactera Home page is opened and title is correct");

			}
		else 
		{
			{	
				//Following can be written in log/result file,used for command line  display
				System.out.println("tc_001:FAILED:Unable to open pactera Home page or title is correct");

				}
		}
		return new HomePage(driver);
	}

}

