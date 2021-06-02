package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PDPObjecs {
	
	
public WebDriver driver;
	
	
	By openpdp1	=By.xpath("//*[@id=\"mainProductGrid\"]/li[1]/div[1]/a/img");
	By openpdp2	=By.xpath("//*[@id=\"mainProductGrid\"]/li[2]/div[1]/a/img");
	By plus	=By.cssSelector("div[id='productModal'] div:nth-child(1) span:nth-child(1) button:nth-child(1)");
	By minus =By.cssSelector("div[id='productModal'] div:nth-child(1) span:nth-child(2) button:nth-child(1)");
	By addtocartfrompdp =By.xpath("//button[@class='btn js-add-to-cart js-enable-btn miglog-btn-add']//span[@class='ipadFix']");
	By closePDP  =By.xpath("//*[@id=\"productModal\"]/div/button");
	
	
	public PDPObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement OpenPDP1()
	{
		return driver.findElement(openpdp1);
	}

	public WebElement OpenPDP2()
	{
		return driver.findElement(openpdp2);
	}

	
	public WebElement Plus()
	{
		return driver.findElement(plus);
	}
	
	public WebElement AddToCartFromPDP()
	{
		return driver.findElement(addtocartfrompdp);
	}
	
	public WebElement Minus()
	{
		return driver.findElement(minus);
	}
	
	public WebElement closePDP()
	{
		return driver.findElement(closePDP);
	}
	
}
