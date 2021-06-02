package ShufersalMiron.Sprod;

import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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



public class PDP_Test extends PropertiesFile
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
	
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver\\ChromeDriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);	
    }
	

	@Test
	public void Add() throws IOException, InterruptedException
	{
		
		username = getObject("username");
		password = getObject("password");
		url = getObject("url");
		driver.get(url);
		String[] itemsNeeded= {"חלב הרים טהור 3% שומן"};

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	
		
		CategoryObjecs ac = new CategoryObjecs(driver);
		Thread.sleep(2000);
		ac.Search().sendKeys("חלב 3");
		Thread.sleep(1000);
		ac.SearchEnter().click();
		Thread.sleep(2000);

		
		PDP(driver,itemsNeeded);
					
					
	}

	public static  void PDP(WebDriver driver,String[] itemsNeeded) throws InterruptedException

	{
		
		CategoryObjecs ac = new CategoryObjecs(driver);
		
		Boolean isPresent = driver.findElements(By.linkText("מחיקת סל")).size() > 0; // Declaration of isPreasent
		
		// If the cart is not empty delete it
		if (isPresent)
			
		{
			ac.DeleteCart().click();
			ac.ConfirmDeleteCart().click();
		}

		int j=0;
		float totalcart = 30; 

		List<WebElement> products=driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li//strong")); // All the products that checked regarding the search

		
		for(int i=0;i<products.size();i++)	
		
		{
			
			
			String[] name=products.get(i).getText().split("-");
					
			String formattedName=name[0].trim();	
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			String price = driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li/div/div/div/div/span/span[1]")).get(i).getText(); // the amount of each product was check
			
			if(itemsNeededList.contains(formattedName))

			{
				
			Thread.sleep(1500);
			j++;

			PDPObjecs pd = new PDPObjecs(driver);
			
			// Adding product to cart
			if (i==0)
			{
			pd.OpenPDP1().click();
			for (int z =0 ; z<5 ;z++)
			{
			pd.Plus().click();
			}
			for (int e =0 ; e<5 ;e++)
			{			
			pd.Minus().click();
			}
			pd.AddToCartFromPDP().click();
			pd.closePDP().click();
			}
			
			if (i==1)
			{
			pd.OpenPDP2().click();
			for (int z =0 ; z<2 ;z++)
			{
			pd.Plus().click();
			}
			for (int e =0 ; e<2 ;e++)
			{			
			pd.Minus().click();
			}
			pd.AddToCartFromPDP().click();
			Thread.sleep(1000);
			pd.closePDP().click();
			}
			
			
			
					if(j==itemsNeeded.length)

						{		
						break;
						}
					
			}
			
			
		}
		
		driver.quit();
		
		}
	
	}
	
		
		

	

