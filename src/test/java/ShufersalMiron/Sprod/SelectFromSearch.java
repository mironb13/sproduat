package ShufersalMiron.Sprod;

import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.CheckOutObjecs;
import PageObjecs.ExtendedCart;
import PageObjecs.LoginObj;
import PageObjecs.PDPObjecs;
import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class SelectFromSearch extends PropertiesFile
{
	public static WebDriver driver;
	static int totalProductsCart = 0;
	static String totalcartamount;
	static String s;
	static double salary=0;
	static String username;
	static String password;
	static String url;
	
	@BeforeTest
	private static void initializeDriver() 
	{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
	
	
	@Test
	public void AddFromSearch() throws IOException, InterruptedException
	{
		

		url = getObject("url");
		driver.get(url);
        CategoryObjecs ac = new CategoryObjecs(driver);
		
		Boolean isPresent = driver.findElements(By.linkText("מחיקת סל")).size() > 0; // Declaration of isPreasent
		
		// If the cart is not empty delete it
		if (isPresent)
			
		{
			ac.DeleteCart().click();
			ac.ConfirmDeleteCart().click();
		}
		
		driver.findElement(By.id("js-site-search-input")).sendKeys("מעדן חלב");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		Thread.sleep(2000);
		
		List <WebElement> options = driver.findElements(By.cssSelector("div[class='line'] button"));
		
		for (int i = 0 ; i < options.size() ; i ++)
			{
			String insert = driver.findElements(By.xpath("//*[@id=\"mCSB_3_container\"]/div[2]/div/div/div/div/button")).get(i).getText();
		 
				if (insert != null)		
				{
	
					Thread.sleep(1000);
					driver.findElements(By.xpath("//*[@id=\"mCSB_3_container\"]/div/div/div/form/button[2]")).get(i).click();	
				
			}
	
			
				if (i == 3)
					
				{
					break;
				}
				
			}
		driver.close();
	}
	
	}
	
		
		

	

