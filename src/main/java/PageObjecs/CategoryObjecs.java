package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryObjecs {

	
	public WebDriver driver;
	
	By search =By.id("js-site-search-input");	
	By searchenter	=By.xpath("//i[@class='icon icon-search']");
	By deletecart =By.linkText("מחיקת סל");
	By confirmdeletecart =By.xpath("//button[@class='btn btn-block btn-lg miglog-bold']");
	By pay =By.linkText("לתשלום");
	By personalarea	=By.xpath("//*[@id=\"cartContainer\"]/div/section/div/div[1]/div[1]/div/a/span");
	By connect =By.xpath("//*[@id=\"cartContainer\"]/div/section/div/div[1]/div[1]/div/a/span");
	By connect1 =By.linkText("שלום מירון");
	By fruitsmenu  =By.linkText("פירות וירקות");
	By coupons =By.xpath("//*[@id=\"cartContainer\"]/div/section/ul/li[3]/a/p");
	By coupons1 =By.linkText("קופונים");
	By sortopen  =By.xpath("//*[@id=\"sortForm1\"]/div/button/span[2]/span");
	By sort1  =By.cssSelector("#sortForm1 > div > div > ul > li:nth-child(2) > a > span.text");
	By sort2  =By.cssSelector("#sortForm1 > div > div > ul > li:nth-child(3) > a > span.text");
	By sort3  =By.cssSelector("#sortForm1 > div > div > ul > li:nth-child(4) > a > span.text");
	By sort4  =By.cssSelector("#sortForm1 > div > div > ul > li:nth-child(5) > a > span.text");
	By sort5  =By.cssSelector("#sortForm1 > div > div > ul > li:nth-child(6) > a > span.text");
	By editorders =By.linkText("עדכון הזמנות");
	By plusupdate =By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/section/section/div[1]/article[1]/div[2]/div[1]/form/div[2]/div[1]/span[1]/button");
	By pressupdatecart =By.xpath("//*[@id=\"mCSB_1_container\"]/div[2]/section/section/div[1]/article[1]/div[2]/div[1]/form/button[1]/span[1]");

	public CategoryObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}



	public WebElement Search()
	{
		return driver.findElement(search);
	}
	
	public WebElement SearchEnter()
	{
		return driver.findElement(searchenter);
	}
	
	public WebElement DeleteCart()
	{
		return driver.findElement(deletecart);
	}
	
	public WebElement ConfirmDeleteCart()
	{
		return driver.findElement(confirmdeletecart);
	}
	
	public WebElement PaymentToExendedCart()
	{
		return driver.findElement(pay);
	}
	
	public WebElement ToPersonalArea()
	{
		return driver.findElement(personalarea);
	}
	
	public WebElement Connect()
	{
		return driver.findElement(connect);
	}
	
	public WebElement Connect1()
	{
		return driver.findElement(connect1);
	}
	
	
	public WebElement fruitmenu()
	{
		return driver.findElement(fruitsmenu);
	}
	
	public WebElement Coupons()
	{
		return driver.findElement(coupons);
	}
	
	
	public WebElement Coupons1()
	{
		return driver.findElement(coupons1);
	}
	
	public WebElement sortopen()
	{
		return driver.findElement(sortopen);
	}
	
	
	public WebElement sort1()
	{
		return driver.findElement(sort1);
	}
	
	
	public WebElement sort2()
	{
		return driver.findElement(sort2);
	}
	
	public WebElement sort3()
	{
		return driver.findElement(sort3);
	}
	
	public WebElement sort4()
	{
		return driver.findElement(sort4);
	}

	
	public WebElement sort5()
	{
		return driver.findElement(sort5);
	}
	
	
	public WebElement editorders()
	{
		return driver.findElement(editorders);
	}
	
	public WebElement plusupdate()
	{
		return driver.findElement(plusupdate);
	}
	
	public WebElement pressupdatecart()
	{
		return driver.findElement(pressupdatecart);
	}
	
}
