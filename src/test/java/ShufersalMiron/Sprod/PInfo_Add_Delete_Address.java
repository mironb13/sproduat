package ShufersalMiron.Sprod;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.ExtendedCart;
import PageObjecs.LoginObj;
import PageObjecs.PersonalInfoObjecs;
import resources.PropertiesFile;


public class PInfo_Add_Delete_Address extends PropertiesFile
{
	public static WebDriver driver;
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
	public void main() throws IOException, InterruptedException
	{
		AddAddress(driver);
		deleteAddress(driver);
	}

	
	public static void AddAddress(WebDriver driver) throws IOException, InterruptedException
	{
		url = getObject("url");
		driver.get(url);
		username = getObject("username");
		password = getObject("password");	
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		CategoryObjecs c = new CategoryObjecs(driver);
		c.Connect().click();
			
		PersonalInfoObjecs pi = new PersonalInfoObjecs(driver);
		pi.PersonalInfo().click();
		Thread.sleep(1500);
		pi.personalAddress().click();
		ExtendedCart ec = new ExtendedCart(driver);
		Thread.sleep(1500);
		if(pi.typepass().isDisplayed())
		{
		Thread.sleep(1500);
		ec.Password().sendKeys(password);
		Thread.sleep(1000);
		ec.ConfirmPassword().click();
		}
		Thread.sleep(1000);
		pi.AddAddress().click();
		Thread.sleep(1500);		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(pi.label());
		actions2.build().perform();	
		Thread.sleep(1000);	
		pi.firstname().sendKeys("מירון");
		pi.lastName().sendKeys("ברנד");
	    pi.addressName().sendKeys("כתובת לבדיקה");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.moveToElement(pi.city());
		actions.click();
		actions.sendKeys("ראשון לציון");
		actions.build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_DOWN);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();		
		Thread.sleep(2000);		
		Actions actions1 = new Actions(driver);		
		actions1.moveToElement(pi.street());
		actions1.click();
		actions1.sendKeys("השמורה");
		actions1.build().perform();
		Thread.sleep(1000);
	//	actions1.sendKeys(Keys.ARROW_DOWN);
		actions1.sendKeys(Keys.ENTER);
		actions1.build().perform();
		Thread.sleep(1000);
		pi.houseNumber().sendKeys("3");
		Thread.sleep(1500);
		pi.houseNumber().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		pi.phone().sendKeys("0507896754");
		pi.housetype().click();
		Thread.sleep(1000);
		pi.save().click();
		Thread.sleep(1000);

		
		}
	
	public static void deleteAddress(WebDriver driver) throws InterruptedException
	
	{
		
		PersonalInfoObjecs pd = new PersonalInfoObjecs(driver);
		String name = driver.findElement(By.xpath("//*[contains(text(), 'כתובת לבדיקה')]")).getText();
		System.out.println(name);
		if (name.contains("כתובת לבדיקה"))
		{
			pd.Deleteaddress().click();
			Thread.sleep(1000);
			pd.ConfirmDeleteaddress().click();
		}
		
		 //driver.close();
	}
	
	
	}	

	

