package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutObjecs {
	
	
public WebDriver driver;
	
	
	By payorder	=By.xpath("/html/body/main/div/div/section[2]/div[2]/a[2]/span[1]");
	By textverify	=By.xpath("//*[@id=\"consgiment_a22396553\"]/div[2]/div[2]/div[3]");
	By confirmpassword =By.xpath("//*[@id=\"checkoutPwd\"]/div[1]/button");
	By deliverytime =By.xpath("//*[@id=\"mCSB_4_container\"]/label[2]/span");
	By pickdeliverytimearrow =By.xpath("//div[@class='name col-xs-9 colorText']");
	By ordernumber =By.xpath("/html/body/main/section[2]/div[1]/div/h3/span[3]");
	By Tocategortpage =By.linkText("חזרה לעמוד הבית");	
	By amountnumber =By.xpath("/html/body/main/section[2]/div[1]/div/h3/span[2]");
	
	
	
	public CheckOutObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement TextVerify()
	{
		return driver.findElement(textverify);
	}

	public WebElement PayOrder()
	{
		return driver.findElement(payorder);
	}
	
	public WebElement deliverytime()
	{
		return driver.findElement(deliverytime);
	}
	
	public WebElement pickdeliverytimearrow()
	{
		return driver.findElement(pickdeliverytimearrow);
	}
	
	public WebElement ordernumber()
	{
		return driver.findElement(ordernumber);
	}
	
	public WebElement Tocategortpage()
	{
		return driver.findElement(Tocategortpage);
	}
	
	public WebElement amountnumber()
	{
		return driver.findElement(amountnumber);
	}
}
