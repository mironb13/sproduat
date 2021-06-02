package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalObjecs {

public WebDriver driver;
	
	By numberoforders =By.xpath("//*[@id=\"mainContentSection\"]/div/div/div[2]/ul/li/div[2]/div[1]/h3");
	By mainlistandorders	=By.xpath("//*[@id=\"gridMyAccount\"]/section[1]/div/nav/ul/li[2]/button/i");
	By showorder	=By.cssSelector("#mainContentSection > div > div > div.newOrders > ul > li > div.mainContainer > div.btnContainer > div:nth-child(1) > a");
	By myonlineorders =By.xpath("//*[@id=\"shoppingListsTab\"]/li[1]/button/span");
	By numberofordersinsideshoworder =By.xpath("//*[@id=\"mainContentSection\"]/div/div[1]/div[3]/div/div[1]/strong");
	By previousorders =By.xpath("//*[@id=\"mainContentSection\"]/div/div/div[3]/div/h3");
	By activeorders =By.xpath("//*[@id=\"mainContentSection\"]/div/div/div[1]/div/h2");
	
	public PersonalObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement MainListAndOrdersLink()
	{
		return driver.findElement(mainlistandorders);
	}
	
	public WebElement MyOnlineOrders()
	{
		return driver.findElement(myonlineorders);
	}
	
	public WebElement ShowOrder()
	{
		return driver.findElement(showorder);
	}
	
	public WebElement NumberOfOrders()
	{
		return driver.findElement(numberoforders);
	}
	
	public WebElement NumberOfOrdersInsideShowOrder()
	{
		return driver.findElement(numberofordersinsideshoworder);
	}
	
	public WebElement previousorders()
	{
		return driver.findElement(previousorders);
	}

	public WebElement activeorders()
	{
		return driver.findElement(activeorders);
	}
}
