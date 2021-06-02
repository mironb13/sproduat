package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListAndOrdersObjecs {
	
public WebDriver driver;
	
	
	By personalInfo	=By.xpath("//*[@id=\"gridMyAccount\"]/section[1]/div/nav/ul/li[3]/button");
	By personaldeatils	=By.xpath("//*[@id=\"personalInfoTab\"]/li[1]/button/span");
	By ordernumber	=By.xpath("//*[@id=\"mainContentSection\"]/div/div/div[2]/ul/li[1]/div[1]/div[1]/div[1]/div[2]");
	By updtaeorder	=By.xpath("//*[@id=\"mainContentSection\"]/div/div/div[2]/ul/li[1]/div[2]/div[2]/div[4]/a");
	By updatecart	=By.xpath("//*[@id=\"mainContentSection\"]/div/div[2]/div/div/div[3]/div/div[1]/button");
	
	
	public ListAndOrdersObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement PersonalInfo()
	{
		return driver.findElement(personalInfo);
	}

	public WebElement Personaldeatils()
	{
		return driver.findElement(personaldeatils);
	}
	
	public WebElement ordernumber()
	{
		return driver.findElement(ordernumber);
	}
	
	public WebElement updtaeorder()
	{
		return driver.findElement(updtaeorder);
	}
	
	public WebElement updatecart()
	{
		return driver.findElement(updatecart);
	}
	
}
