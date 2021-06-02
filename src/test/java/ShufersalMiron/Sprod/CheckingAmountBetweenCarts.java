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
import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckingAmountBetweenCarts extends PropertiesFile
{
	public static WebDriver driver;
	static int totalProductsCart = 0;
	static String totalcartamount;
	static String minicartamount;
	static String s;
	static String sex;
	static double sumonepoint=0;
	static float sumonepoint1=0;
	static float sumonepoint2=0;
	static double sumonepointex=0;
	static float productsSum = 0;
	static float productsSumTotal = 0;
	static String username;
	static String password;
	static String url;
	static float totalcartex = 0;
	static float total;
	static float cartsumDiscount= 0;
	static float cartsumDiscount1= 0;
	
	
	
	@BeforeTest
	private static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver\\ChromeDriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

    }
	
	
	
	@Test
	public void Add() throws IOException, InterruptedException
	{
		
		String[] itemsNeeded= {"חלב הרים נטול לקטוז 3%","חלב הרים טהור 3% שומן"};
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		url = getObject("url");
		driver.get(url);
		CategoryObjecs ac = new CategoryObjecs(driver);
		Thread.sleep(2000);
		ac.Search().sendKeys("חלב 3 אחוז");
		Thread.sleep(1000);
		ac.SearchEnter().click();
		Thread.sleep(2000);

		
		addItems(driver,itemsNeeded);
		driver.quit();			
					
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
			total =Float.parseFloat(price); // Convert to float each product price
			productsSum = Float.parseFloat(price);
			productsSumTotal = productsSum + productsSumTotal;
			totalcart = totalcart + total; // Calculate the total sum in the cart
			sumonepoint = Math.round(totalcart * 100.0) / 100.0; // convert to one number after point
			s=String.valueOf(sumonepoint);  // converting float to String to compare between totalcartamount and totalcart (calculate adding each product)

			
			cartsumDiscount = cartsumDiscount+  (float) (productsSum*0.94);

			
							
			// Adding product to cart
			driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li/div/div/button[@class='btn js-add-to-cart js-enable-btn miglog-btn-add']")).get(i).click();
			
			Thread.sleep(1500);
			
			// The total cart amount after each product that added
			totalcartamount = driver.findElement(By.xpath("//div[@class='sideBlock']//div[@class='price']//span[@class='currency']")).getText();
			// The sum of the products in the cart
			Thread.sleep(1000);
			String totalproducts = driver.findElement(By.xpath("//i[@class='icon icon-cart']//span[@id='cartTotalItems']")).getText();
			Thread.sleep(1500);
			totalProductsCart = Integer.parseInt(totalproducts);
			Thread.sleep(1000);
			
					// if the total products should insert the cart right the loop ended
					if(j==itemsNeeded.length)

						{		
						break;
						}
					
			}
			
			
		}

		cartsumDiscount1 = 30 + cartsumDiscount;
		sumonepoint1 = (float) (Math.round(cartsumDiscount1 * 100.0) / 100.0);
		sumonepoint2 = sumonepoint1 + sumonepoint2;

		ExtendedCart ec = new ExtendedCart(driver);
		
		for (int m = 1;m<4;m++)
		{
		ac.PaymentToExendedCart().click();
		Thread.sleep(1000);
		String sectoatal = driver.findElement(By.xpath("//*[@id=\"cartContainer\"]/div/div/footer/div[3]/div/div/div/div[1]/span[2]")).getText();
		//float secminicartsum = Float.parseFloat(sectoatal);
		String[] exam1 = sectoatal.split("\n");
		float comp1 =Float.parseFloat(exam1[0]); 
		System.out.println("בכניסה  " + m + "הערך בסל מורחב הוא :" + comp1);
		
		ec.back().click(); 
		Thread.sleep(1000);
		minicartamount = driver.findElement(By.xpath("(//div[@class='price']//span)[1]")).getText();
		String[] exam = minicartamount.split("\n");
		float comp =Float.parseFloat(exam[2]); 
		System.out.println("בכניסה  " + m + "הערך בסל מצומצם הוא :" + comp);

		if (sumonepoint2 != comp)
		{
			System.out.println("The 2 amounts between the carts are differents");
			Assert.assertFalse(true);
		}

		
		
		}
		
		}
	
	}
	
		
		

	

