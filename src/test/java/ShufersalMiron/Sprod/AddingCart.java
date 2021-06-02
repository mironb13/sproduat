package ShufersalMiron.Sprod;

import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjecs.LoginObj;
import junit.framework.Assert;
import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class AddingCart extends PropertiesFile
{
	public static WebDriver driver;
	static int total1 = 0;
	static String totalcartamount;
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
		url = getObject("url");
		driver.get(url);
		String[] itemsNeeded= {"חלב הרים טהור 3% שומן"};

		Thread.sleep(2000);
		driver.findElement(By.id("js-site-search-input")).sendKeys("חלב 3 אחוז");
		Thread.sleep(1000);
		driver.findElement(By.id("js-site-search-input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		
		addItems(driver,itemsNeeded);
		driver.quit();
					
					
	}

	public static  void addItems(WebDriver driver,String[] itemsNeeded) throws InterruptedException

	{
		Boolean isPresent = driver.findElements(By.linkText("מחיקת סל")).size() > 0;
	if (isPresent)
			
		{
			driver.findElement(By.linkText("מחיקת סל")).click();
			driver.findElement(By.xpath("//button[@class='btn btn-block btn-lg miglog-bold']")).click();
		}

		int j=0;
		float totalcart = 30; 
		float totalcart1 = 0; 

		List<WebElement> products=driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li//strong")); //*[@id="mainProductGrid"]/li

		
		for(int i=0;i<products.size();i++)	
		
		{
			
			
			String[] name=products.get(i).getText().split("-");
					
			String formattedName=name[0].trim();	
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			String price = driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li/div/div/div/div/span/span[1]")).get(i).getText();
			
		//	String sum = driver.findElements(By.xpath("//*[@id=\"cartContainer\"]/div/div/footer/div[2]/div/div/div[1]/span/text()")).get(i).getText();
			
		//	System.out.println(sum);
			
			if(itemsNeededList.contains(formattedName))

			{
			Thread.sleep(1500);
			j++;
			
			// float totalsum =Float.parseFloat(sum);
		//    totalcart1 = totalcart1 + totalsum;
		//    System.out.println(totalcart1);	
			float total =Float.parseFloat(price); 
			totalcart = totalcart + total;
			
			
				
			driver.findElements(By.xpath("//*[@id=\"mainProductGrid\"]/li/div/div/button[@class='btn js-add-to-cart js-enable-btn miglog-btn-add']")).get(i).click();
			
			Thread.sleep(1500);
			
			
			totalcartamount = driver.findElement(By.xpath("(//div[@class='price']//span)[1]")).getText();
			System.out.println(totalcartamount);
			// The sum of the products in the cart
			String totalproducts = driver.findElement(By.xpath("//i[@class='icon icon-cart']//span[@id='cartTotalItems']")).getText();
			System.out.println(totalproducts);
			total1 = Integer.parseInt(totalproducts);
			Thread.sleep(1500);
			System.out.println("Total products in the cart  " + total1);
			
			if(j==itemsNeeded.length)

			{

			break;

			}
			
			}
			
		
			
		}
		
		System.out.println(totalcartamount);
		 double salary = Math.round(totalcart * 100.0) / 100.0;
		System.out.println("The amount of the cart :" + salary);
	

	}
	
		
		
}
	

