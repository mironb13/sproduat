package ShufersalMiron.Sprod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.ListAndOrdersObjecs;
import PageObjecs.LoginObj;
import PageObjecs.PersonalObjecs;
import resources.PropertiesFile;

public class ListAndOrders extends PropertiesFile{
	
	
	static String username;
	static String password;
	static String numorder;
	static String url;
	static String numinsideorder;
	public static WebDriver driver;
	
	
	@BeforeTest
	private static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

    }
	
	
	
	@Test
	public void ListAndOrdersSecion() throws InterruptedException, IOException 
	
	{		
		url = getObject("url");
		driver.get(url);
		CategoryObjecs c = new CategoryObjecs(driver);
		c.Connect().click();
		PersonalObjecs pers = new PersonalObjecs(driver);
		Thread.sleep(2000);
		pers.MainListAndOrdersLink().click();
		pers.MyOnlineOrders().click();
	//	if(pers.activeorders().isDisplayed())
	//	{
			
	//	}
		
		
		
		driver.quit();
		
	}

}
