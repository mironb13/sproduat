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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.CheckOutObjecs;
import PageObjecs.ExtendedCart;
import PageObjecs.LoginObj;
import PageObjecs.PDPObjecs;

import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class SortingFromCaegory extends PropertiesFile
{
	public WebDriver driver;

	static String username;
	static String password;
	static String url;
	
	
	@Test
	public void AddFromSearch() throws IOException, InterruptedException
	{
		
		username = getObject("username");
		password = getObject("password");
		url = getObject("url");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginObj lg = new LoginObj(driver);
		driver.findElement(By.linkText("התחברות")).click();
	//	driver.findElement(By.xpath("//*[@id=\"j_username\"]")).sendKeys(username);
	//	driver.findElement(By.xpath("//*[@id=\"j_password\"]")).sendKeys(password);
		lg.insertusername().sendKeys(username);
		lg.insertpassword().sendKeys(password);
		lg.Submit().click();
		
        CategoryObjecs ac = new CategoryObjecs(driver);
		
		Boolean isPresent = driver.findElements(By.linkText("מחיקת סל")).size() > 0; // Declaration of isPreasent
		
		// If the cart is not empty delete it
		if (isPresent)
			
		{
			ac.DeleteCart().click();
			ac.ConfirmDeleteCart().click();
		}
		
		driver.findElement(By.id("js-site-search-input")).sendKeys("מעדן חלב");
		ac.SearchEnter().click();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Thread.sleep(1000);
		
	
		
		ac.sortopen().click();
		Thread.sleep(1000);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ac.sort1());
		actions.click();
		actions.build().perform();
		
			
		String price = driver.findElement(By.cssSelector("#mainProductGrid > li:nth-child(1) > div.tile.miglog-prod-inStock.notOverlay.ui-draggable.ui-draggable-handle > div.textContainer > div > div.line > span > span.number")).getText(); // the amount of each product was check
		System.out.println("firt product price is : " + price);	
		String min = driver.findElement(By.xpath("//*[@id=\"product-facet\"]/ul[2]/li[5]/div[2]/div[1]/div[3]")).getText();
		
		System.out.println(min);

		Thread.sleep(1000);
		
		if (min.contains(price))
			
		{			
			System.out.println("Cool");			
		}		
		else 			
		{
			Assert.assertFalse(true);
		}
		
		

		Thread.sleep(1000);
		
		ac.sortopen().click();
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(ac.sort3());
		actions2.click();
		actions2.build().perform();
		
		
		
	Thread.sleep(1000);
		
		
		Thread.sleep(2000);
		
		ac.sortopen().click();
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(ac.sort2());
		actions1.click();
		actions1.build().perform();
		
		
		
		String price1 = driver.findElement(By.xpath("//*[@id=\"mainProductGrid\"]/li[1]/div[1]/div[3]/div/div[1]/span/span[1]")).getText(); // the amount of each product was check
		System.out.println(price1);	
		String max = driver.findElement(By.xpath("//*[@id=\"product-facet\"]/ul[2]/li[5]/div[2]/div[1]/div[4]/div[2]")).getText();
		
		System.out.println(max);

		
		if (max.contains(price1))
			
		{			
			System.out.println("Cool");			
		}		
		else 			
		{
			Assert.assertFalse(true);
		}
		
		

		
		ac.sortopen().click();
		Actions actions3 = new Actions(driver);
		actions3.moveToElement(ac.sort4());
		actions3.click();
		actions3.build().perform();
		
		
	Thread.sleep(1000);
		
		ac.sortopen().click();
		Actions actions4 = new Actions(driver);
		actions4.moveToElement(ac.sort5());
		actions4.click();
		actions4.build().perform();
		
	
	}
	
	}
	
		
		

	

