package ShufersalMiron.Sprod;

import static org.testng.Assert.assertEquals;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.CheckOutObjecs;
import PageObjecs.ExtendedCart;
import PageObjecs.LoginObj;
import PageObjecs.PersonalInfoObjecs;
import resources.PropertiesFile;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class PersonalInformationPD extends PropertiesFile
{
	public WebDriver driver;
	static int totalProductsCart = 0;
	static String totalcartamount;
	static String s;
	static double salary=0;
	static String username;
	static String password;
	
	
	@Test
	public void Add() throws IOException, InterruptedException
	{
		String phone = null;
		username = getObject("username");
		password = getObject("password");
		String url = getObject("url");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginObj lg = new LoginObj(driver);
		lg.insertusername().sendKeys(username);
		lg.insertpassword().sendKeys(password);
		lg.Submit().click();
		
		CategoryObjecs c = new CategoryObjecs(driver);
		c.Connect().click();
			
		PersonalInfoObjecs pi = new PersonalInfoObjecs(driver);
		pi.PersonalInfo().click();
		
		ExtendedCart ec = new ExtendedCart(driver);
		if(ec.ToCheckOut().isDisplayed())
		{
		ec.ToCheckOut().click();
		Thread.sleep(1500);
		ec.Password().sendKeys(password);
		Thread.sleep(1500);
		ec.ConfirmPassword().click();
		}
		
		Thread.sleep(1500);
		pi.Personaldeatils().click();
		String name = pi.personalname().getText();
		assertEquals(name, "מירון");
		Thread.sleep(1500);
			for (int i = 1 ; i <2 ; i ++)
			{
					String phonecheck = pi.personalphone().getAttribute("value");
					if(!phonecheck.isEmpty())
				{
					pi.personalphone().clear();
				}
			
		pi.personalphone().sendKeys("0508899771");
		phone = pi.personalphone().getAttribute("value");
		pi.personalsave().click();
		pi.personalAddress().click();
		Thread.sleep(1500);
		pi.Personaldeatils().click();
		assertEquals(phone, "0508899771");
       // pi.male().click();
      //  pi.personalsave().click();
		//pi.personalAddress().click();
	//	Thread.sleep(1500);
	//	pi.Personaldeatils().click();
		//String v = (pi.male().getAttribute("value"));
		//System.out.println("Entered text is: " + v);
	//	{
	//		System.out.println("success");
	//	}
		//driver.quit();			

			}
	}	
}
	

