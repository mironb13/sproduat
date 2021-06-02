package ShufersalMiron.Sprod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import resources.PropertiesFile;



public class BrokenLinksTest  extends PropertiesFile{

	public WebDriver driver;
	
	@Test
	public void BrokenLinkCheck() throws MalformedURLException, IOException, InterruptedException
	
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.get("https://uat.shufersal.co.il/online/he/");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            //div[@class='footerMenu collapse']/ul/li/a
		
		  List<WebElement> links1= driver.findElements(By.cssSelector("#tab1 > ul a"));	
			  
		  for(WebElement link : links1)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("1" + link.getText() + respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }
	        	  
			  
		}
		
		  List<WebElement> links2= driver.findElements(By.cssSelector("#tab2 > ul a"));	
		  
		  for(WebElement link : links2)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("2" + link.getText() +respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }
	        	  
			  
		}
		  
		  Thread.sleep(1500);
		  
		  List<WebElement> links3= driver.findElements(By.cssSelector("#tab3 > ul a"));	
		  
		  for(WebElement link : links3)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("3" + link.getText() + respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }
	        	  
			  
		}
		  
		  
      List<WebElement> links4= driver.findElements(By.cssSelector("#tab4 > ul a"));	
		  
		  for(WebElement link : links4)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("4" + link.getText() + respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }

			}
		  
		  
		  Thread.sleep(1500);
		  
		 
		  
 List<WebElement> links5= driver.findElements(By.cssSelector("#tab5 > ul a"));	
		  
		  for(WebElement link : links5)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("5" + link.getText() + respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }
	        	  
			  
		}
		  
		  
 List<WebElement> links6= driver.findElements(By.cssSelector("#tab6 > ul a"));	
		  
		  for(WebElement link : links6)

	      {
     

	          String url= link.getAttribute("href");

	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

	          conn.setRequestMethod("HEAD");

	          conn.connect();

	          int respCode = conn.getResponseCode();

	          System.out.println("6" + link.getText() + respCode);
	          
	          if (respCode>400)
	        	 
	          {
	        	  System.out.println("The link with text " + link.getText());
	        	  Assert.assertFalse(true);
	          }
	        	  	  
		}
		  
	}
	
}



