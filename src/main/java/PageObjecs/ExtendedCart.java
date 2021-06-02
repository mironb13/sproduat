package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtendedCart {
	
public WebDriver driver;
	
	By password =By.cssSelector("#j_password");
	By tocheckout	=By.xpath("//*[@id=\"cartContainer\"]/div/div/footer/div[3]/button");
	By Verify	=By.xpath("//*[@id=\"cartContainer\"]/div/section/h1");
	By confirmpassword =By.xpath("//*[@id=\"checkoutPwd\"]/div[1]/button");
	By back =By.xpath("//*[@id=\"main\"]/section/div[1]/div[1]/a/i");

	public ExtendedCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement ToCheckOut()
	{
		return driver.findElement(tocheckout);
	}
	
	public WebElement ConfirmPassword()
	{
		return driver.findElement(confirmpassword);
	}
	
	public WebElement Verify()
	{
		return driver.findElement(Verify);
	}
	
	public WebElement back()
	{
		return driver.findElement(back);
	}

}
