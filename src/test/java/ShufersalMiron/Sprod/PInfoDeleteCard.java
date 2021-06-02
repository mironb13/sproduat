package ShufersalMiron.Sprod;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.ExtendedCart;
import PageObjecs.LoginObj;
import PageObjecs.PersonalInfoObjecs;
import resources.PropertiesFile;

public class PInfoDeleteCard extends PropertiesFile
{
	public static WebDriver driver;
	static String username;
	static String password;
	static String url;
	
	
	@BeforeTest
	private static void initializeDriver() 
	{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/עמית/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
	
	
	@Test
	public void Add() throws IOException, InterruptedException
	{
		url = getObject("url");
		driver.get(url);
		username = getObject("username");
		password = getObject("password");	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		CategoryObjecs c = new CategoryObjecs(driver);
		c.Connect().click();	
		PersonalInfoObjecs pi = new PersonalInfoObjecs(driver);
		pi.PersonalInfo().click();
		Thread.sleep(1500);
		pi.paymentType().click();
		ExtendedCart ec = new ExtendedCart(driver);
		if(pi.typepass().isDisplayed())
		{
		Thread.sleep(1500);
		ec.Password().sendKeys(password);
		ec.ConfirmPassword().click();
		}		
		pi.Deletepayment().click();
		String card = pi.cardnumber().getText();		
			if (card.isEmpty())
			{
				Assert.assertFalse(true);
			}	
			System.out.println("The last card didn't deleted");
	driver.close();
		
		}
	}	

	

