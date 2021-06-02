package ShufersalMiron.Sprod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.CoupunsObjecs;
import PageObjecs.LoginObj;
import resources.PropertiesFile;

public class Coupons_Select extends PropertiesFile {
	
	static String username;
	static String password;
	static String url;
	public static WebDriver driver;
	
	
	@BeforeTest
	private static void initializeDriver() 
	{
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
	

	
	
	//@SuppressWarnings("deprecation")
	@Test
	public void ValidaionCoupons() throws IOException, InterruptedException
	
	{
		url = getObject("url");
		driver.get(url);
		CategoryObjecs cp = new CategoryObjecs(driver);		
        cp.Coupons().click();
        CoupunsObjecs co = new CoupunsObjecs(driver);
        Thread.sleep(1000);
        co.Filterby().click();
        Thread.sleep(2000);
        co.Activatecoupons().click();
        Thread.sleep(2000);
        
        if (!co.NoCoupons().isDisplayed())
        {
            String AP = co.Activatecouponsproduct().getText();
            //  String replace = "הקופון הופעל. הוסף את המוצר לסל";
            //  String compare = AP.replace("נותרו 3 ימים למימוש הקופון", "");
          	assertEquals(AP, "הקופון הופעל. הוסף את המוצר לסל");
        }
          
    	Thread.sleep(2000);
    	co.Filterby().click();
    	co.Nonactivatecoupons().click();
    	String NAP = co.Nonactivatecouponsproduct().getText();
    	assertEquals(NAP, "קופון אישי");
		driver.quit();
	}

}
