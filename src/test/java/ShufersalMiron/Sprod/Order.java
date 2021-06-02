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
import PageObjecs.ListAndOrdersObjecs;
import PageObjecs.LoginObj;
import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class Order extends PropertiesFile
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
	public void Add() throws IOException, InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		username = getObject("username");
		password = getObject("password");
		url = getObject("url");
		driver.get(url);
		String[] itemsNeeded= {"חלב הרים נטול לקטוז 3%","חלב הרים טהור 1% שומן"};

		CategoryObjecs ac = new CategoryObjecs(driver);
		Thread.sleep(2000);
		ac.Search().sendKeys("חלב 3 אחוז");
		Thread.sleep(1000);
		ac.SearchEnter().click();
		Thread.sleep(2000);

		
		addItems(driver,itemsNeeded);
		update(driver);
	//	driver.quit();			
					
	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded) throws InterruptedException

	{
		
		CategoryObjecs ac = new CategoryObjecs(driver);
		
		Boolean isPresent = driver.findElements(By.linkText("מחיקת סל")).size() > 0; // Declaration of isPreasent
		
		// If the cart is not empty delete it
		if (isPresent)
			
		{
			ac.DeleteCart().click();
			ac.ConfirmDeleteCart().click();
		}
		Thread.sleep(1500);
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

			// Calculate each product amount and make it to sum - also convert to string for compare
			float total =Float.parseFloat(price); 
			totalcart = totalcart + total;
			salary = Math.round(totalcart * 100.0) / 100.0;
			s=String.valueOf(salary);  // converting float to String to compare between totalcartamount and totalcart (calculate adding each product)
			System.out.println(s);  
			
			// Adding product to cart
			driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li/div/div/button[@class='btn js-add-to-cart js-enable-btn miglog-btn-add']")).get(i).click();
			
			Thread.sleep(1500);
			
			// The total cart amount after each product that added
			totalcartamount = driver.findElement(By.xpath("(//div[@class='price']//span)[1]")).getText();
		
			// The sum of the products in the cart
			String totalproducts = driver.findElement(By.xpath("//*[@id=\"cartTotalItems\"]")).getText();
			Thread.sleep(1500);
			System.out.println(totalproducts);
			totalProductsCart = Integer.parseInt(totalproducts);
			Thread.sleep(3000);
			System.out.println(totalProductsCart);
					// if the total products should insert the cart right the loop ended
					if(j==itemsNeeded.length)

						{		
						break;
						}
					
			}
			
			
		}
		
		// if the amount in the cart equal to the sum of all the products amount was added to the cart continue with assert
		if (totalcartamount.contains(s))
			
		{
			Assert.assertTrue(true);
		}
			
		System.out.println("The amount of the cart :" + salary);
		System.out.println("Total products in the cart :" + totalProductsCart);
		//driver.quit();
		
		Thread.sleep(1500);
		ac.PaymentToExendedCart().click();
		ExtendedCart ec = new ExtendedCart(driver);
		
		if(ec.ToCheckOut().isDisplayed())
		{
		ec.ToCheckOut().click();
		Thread.sleep(1500);
		ec.Password().sendKeys(password);
		Thread.sleep(1500);
		ec.ConfirmPassword().click();
		}
		
		else
		{
			Assert.assertFalse(true);
		}
		
		CheckOutObjecs co = new CheckOutObjecs(driver);
		Thread.sleep(1500);	
		co.pickdeliverytimearrow().click();
		Thread.sleep(1000);	
		co.deliverytime().click();
		Thread.sleep(2000);		
		co.PayOrder().click();		
		String ordernumber = co.ordernumber().getText();
		String [] parts = ordernumber.split(" ");
		String get = parts[2];

		co.Tocategortpage().click();
		Thread.sleep(1000);	
		ac.editorders().click();
		Thread.sleep(5000);	
		ListAndOrdersObjecs lo = new ListAndOrdersObjecs(driver);
		String ordernumberLO = lo.ordernumber().getText();
		Thread.sleep(2000);	
		
			if (ordernumberLO.equals(get))
				
			{
				System.out.println("The order number is equal to the order numnber in My online orders");
			}
			
			else {
				System.out.println("The order number is different");
				Assert.assertFalse(true);
			}
			
		
	}
	
			@Test (enabled=true)
			public static void update(WebDriver driver) throws InterruptedException
			
					{
					Thread.sleep(1000);	
					ListAndOrdersObjecs lo = new ListAndOrdersObjecs(driver);
					lo.updtaeorder().click();
					Thread.sleep(4000);	
					lo.updatecart().click();
					CategoryObjecs ca = new CategoryObjecs(driver);
					Thread.sleep(1000);	
						for (int i = 1 ; i < 4 ; i++)
						{
					ca.plusupdate().click();
						}
						
						ca.pressupdatecart().click();
						
						Thread.sleep(1500);
						ca.PaymentToExendedCart().click();
						ExtendedCart ec = new ExtendedCart(driver);
						
						if(ec.ToCheckOut().isDisplayed())
						{
						ec.ToCheckOut().click();
						Thread.sleep(1500);
						ec.Password().sendKeys(password);
						Thread.sleep(1500);
						ec.ConfirmPassword().click();
						}
						
						else
						{
							Assert.assertFalse(true);
						}
						
						CheckOutObjecs co = new CheckOutObjecs(driver);
						Thread.sleep(1500);	
						co.pickdeliverytimearrow().click();
						Thread.sleep(1000);	
						co.deliverytime().click();
						Thread.sleep(2000);		
						co.PayOrder().click();		
						String ordernumber = co.ordernumber().getText();
						String [] parts = ordernumber.split(" ");
						String get = parts[2];

						co.Tocategortpage().click();
						Thread.sleep(1000);	
						ca.editorders().click();
						Thread.sleep(5000);	
						
						String ordernumberLO = lo.ordernumber().getText();
						Thread.sleep(2000);	
						
							if (ordernumberLO.equals(get))
								
							{
								System.out.println("The order number is equal to the order numnber in My online orders");
							}
							
							else {
								System.out.println("The order number is different");
								Assert.assertFalse(true);
							}
						
					}
						
}
	

