package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoupunsObjecs {
	
	
public WebDriver driver;
	
	
	By filterby	=By.xpath("//*[@id=\"sortCouponForm\"]/div/button/span[2]/span");
	By allcoupons	=By.xpath("//*[@id=\"sortCouponForm\"]/div/div/ul/li[1]");
	By expired =By.xpath("//*[@id=\"sortCouponForm\"]/div/div/ul/li[2]");
	By activatecoupons =By.xpath("//*[@id=\"sortCouponForm\"]/div/div/ul/li[3]");
	By nonactivatecoupons =By.xpath("//*[@id=\"sortCouponForm\"]/div/div/ul/li[4]/a/span[1]");
	By activatecouponsproduct=By.xpath("//*[@id=\"couponsPane1\"]/section[2]/div[3]/section/ul/li[1]/div/div[1]/a[1]/div[2]/span");                       
	By nonactivatecouponsproduct =By.xpath("//*[@id=\"couponsPane1\"]/section[2]/div[3]/section/ul/li[1]/div/div[1]/a[1]/div[1]/span");
	By NoCoupons=By.xpath("//*[@id=\"couponsPane1\"]/section[2]/div[3]/section/ul/li/div/h2");
	
	
	
	public CoupunsObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement Filterby()
	{
		return driver.findElement(filterby);
	}

	public WebElement Allcoupons()
	{
		return driver.findElement(allcoupons);
	}
	
	public WebElement Expired()
	{
		return driver.findElement(expired);
	}

	public WebElement Activatecoupons()
	{
		return driver.findElement(activatecoupons);
	}

	
	public WebElement Nonactivatecoupons()
	{
		return driver.findElement(nonactivatecoupons);
	}

	public WebElement Activatecouponsproduct()
	{
		return driver.findElement(activatecouponsproduct);
	}
	
	public WebElement Nonactivatecouponsproduct()
	{
		return driver.findElement(nonactivatecouponsproduct);
	}
	
	
	public WebElement NoCoupons()
	{
		return driver.findElement(NoCoupons);
	}
	
}
