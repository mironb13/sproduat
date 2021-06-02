package ShufersalMiron.Sprod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjecs.CategoryObjecs;
import PageObjecs.LoginObj;
import resources.PropertiesFile;

public class Validation extends PropertiesFile {
	
	static String username;
	static String password;
	static String url;
	public static WebDriver driver;
	
	@BeforeTest
	private static void initializeDriver() {
		
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/meironb/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

	
	@SuppressWarnings("deprecation")
	@Test
	public void ValidaionCategory() throws IOException, InterruptedException
	
	{
		
		
		
		/*
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
		*/
		url = getObject("url");
		driver.get(url);
		LoginObj lg = new LoginObj(driver);
		String name = lg.LoginName().getText();
		assertEquals(name, "שלום מירון");
		
		Actions actions = new Actions(driver);
		CategoryObjecs co = new CategoryObjecs(driver);		
		WebElement subMenu = co.fruitmenu();
		String fruit = co.fruitmenu().getText();
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		assertEquals(fruit, "פירות וירקות");
		driver.quit();
	}

}
