package PageObjecs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObj {

	
	public WebDriver driver;
	
	By username =By.id("j_username");
	By password =By.id("j_password");
	By submit	=By.xpath("//*[@id=\"loginForm\"]/div[3]/button");
	By deletecart = By.linkText("מחיקת סל");
	By cartTotalItems =By.id("cartTotalItems");				
	By loginname =By.xpath("//*[@id=\"cartContainer\"]/div/section/div/div[1]/div[1]/div/a/span");


	public LoginObj(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement insertusername()
	{
		return driver.findElement(username);
	}
	
	public WebElement insertpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement Deletecart()
	{
		return driver.findElement(deletecart);
	}
	
	public WebElement cartTotalItems()
	{
		return driver.findElement(cartTotalItems);
	}
	
	public WebElement LoginName()
	{
		return driver.findElement(loginname);
	}
	
}
