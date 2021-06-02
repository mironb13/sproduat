package ShufersalMiron.Sprod;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjecs.LoginObj;
import resources.PropertiesFile;


public class LoginTest extends PropertiesFile
{
	public WebDriver driver;
	@Test(priority=1)
	public void LoginTest1() throws IOException
		{
		
		String username = getObject("username");
		String password = getObject("password");
		String browser = getObject("browser");
		String url = getObject("url");
		
					if (browser.equals("chrome") )
						{
								if (username.equals("mironbr@gmail.com"))
								{
							System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
							 driver = new ChromeDriver();
							driver.get(url);
							LoginObj lg = new LoginObj(driver);
							lg.insertusername().sendKeys(username);
							lg.insertpassword().sendKeys(password);
							lg.Submit().click();
								}
								else if (username!="mironbr@gmail.com")
								{						
									System.out.println("The username is not equal tto mironbr@gmail.com");
									System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
									 driver = new ChromeDriver();
									driver.get(url);
									LoginObj lg = new LoginObj(driver);
									lg.insertusername().sendKeys(username);
									lg.insertpassword().sendKeys(password);
									lg.Submit().click();					
								}
						}

							else if (browser.equals("firefox") )
							{
								System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Selenium\\geckodriver.exe");
								 driver = new FirefoxDriver();
								driver.get(url);
								LoginObj lg = new LoginObj(driver);
								lg.insertusername().sendKeys(username);
								lg.insertpassword().sendKeys(password);
								lg.Submit().click();
						    }
							else if (username!="mironbr@gmail.com")
							{						
								System.out.println("The username is not equal tto mironbr@gmail.com");
								System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
								 driver = new ChromeDriver();
								driver.get(url);
								LoginObj lg = new LoginObj(driver);
								lg.insertusername().sendKeys(username);
								lg.insertpassword().sendKeys(password);
								lg.Submit().click();							
							}
		
			driver.quit();		
		}


}
