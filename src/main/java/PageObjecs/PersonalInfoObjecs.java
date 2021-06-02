package PageObjecs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoObjecs {
	
public WebDriver driver;
	
    By label	=By.xpath("//*[@id=\"mainContentSection\"]/div/div[1]/div/h1");
	By personalInfo	=By.xpath("//*[@id=\"gridMyAccount\"]/section[1]/div/nav/ul/li[3]/button");
	By personaldeatils	=By.xpath("//*[@id=\"personalInfoTab\"]/li[1]/button/span");
	By personalname	=By.xpath("//*[@id=\"mainContentSection\"]/form/div[2]/div/div[1]/div[1]");
	By personalphone	=By.name("phoneExtra");
	By personalsave	=By.xpath("//*[@id=\"mainContentSection\"]/form/div[3]/button");
	By personalAddress	=By.xpath("//*[@id=\"personalInfoTab\"]/li[2]/button/span");
	By male =By.xpath("//*[@id=\"mainContentSection\"]/form/div[2]/div/div[8]/div/label[2]/span[1]");
	By female =By.xpath("//*[@id=\"mainContentSection\"]/form/div[2]/div/div[8]/div/label[1]/span[1]");
	By AddAddress	=By.linkText("הוספת כתובת");
	By firstname =By.name("firstName");
	By lastName =By.name("lastName");
	By addressName =By.name("addressName");
	By cityselect =By.xpath("//*[@id=\"mainContentSection\"]/div/div[2]/div/div[2]/div/div[10]/div/div/form/fieldset/div/div[4]/div/div/div[2]");
	By city =By.xpath("//div[@class='form-group']/div[@class='dropdown v-select single searchable rtl']");
	By cityenter =By.cssSelector("#mainContentSection > div > div.bgAccountWrapper > div > div.panelContainer.borderRadius > div > div.edited-address > div > div > form > fieldset > div > div:nth-child(4) > div > div > div.vs__selected-options > span");
	By street =By.xpath("//input[starts-with(@id, 'streetCode')]");////div[@data-vv-as='רחוב']//div//div//input[@role='searchbox']
	By typepass =By.xpath("//*[@id=\"forgottenPwdModal\"]/div/div/div[1]/h3");                  
	By houseNumber =By.name("houseNumber");
	By phone =By.name("phone");
	By housetype =By.xpath("//span[contains(text(),'בית פרטי')]");
	By save =By.xpath("//*[@id=\"address_undefined\"]/button");
	By paymentType =By.xpath("//*[@id=\"personalInfoTab\"]/li[3]/button/span");
	By Deletepayment =By.xpath("//*[@id=\"selection3\"]/div/div[1]/div[2]/a[2]");
	By cardnumber =By.xpath("//*[@id=\"selection3\"]/div/div[1]/div[1]/div/span[2]");
	By addressname =By.xpath("//*[@id=\"mainContentSection\"]/div/div[2]/div/div[2]/div/div[3]/div/div[1]");
	By Deleteaddress =By.xpath("//*[@id=\"mainContentSection\"]/div/div[2]/div/div[2]/div/div[4]/div/div[3]/a");
	By ConfirmDeleteaddress =By.xpath("//*[@id=\"gridMyAccount\"]/div[1]/div/div/div/button[1]");
	
	
	
	public PersonalInfoObjecs(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}


	public WebElement label()
	{
		return driver.findElement(label);
	}
	
	public WebElement PersonalInfo()
	{
		return driver.findElement(personalInfo);
	}
	
	public WebElement Personaldeatils()
	{
		return driver.findElement(personaldeatils);
	}
	
	public WebElement personalname()
	{
		return driver.findElement(personalname);
	}
	
	public WebElement personalphone()
	{
		return driver.findElement(personalphone);
	}
	
	public WebElement personalsave()
	{
		return driver.findElement(personalsave);
	}
	
	public WebElement personalAddress()
	{
		return driver.findElement(personalAddress);
	}

	public WebElement male()
	{
		return driver.findElement(male);
	}
	
	public WebElement female()
	{
		return driver.findElement(female);
	}

	public WebElement AddAddress()
	{
		return driver.findElement(AddAddress);
	}
	
	public WebElement firstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement lastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement addressName()
	{
		return driver.findElement(addressName);
	}
	
	public WebElement cityselect()
	{
		return driver.findElement(cityselect);
	}
	
	public WebElement city()
	{
		return driver.findElement(city);
	}
	
	public WebElement street()
	{
		return driver.findElement(street);
	}
	
	public WebElement houseNumber()
	{
		return driver.findElement(houseNumber);
	}
	
	public WebElement phone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement housetype()
	{
		return driver.findElement(housetype);
	}
	
	public WebElement save()
	{
		return driver.findElement(save);
	}
	
	public WebElement typepass()
	{
		return driver.findElement(typepass);
	}
	
	public WebElement paymentType()
	{
		return driver.findElement(paymentType);
	}
	
	public WebElement Deletepayment()
	{
		return driver.findElement(Deletepayment);
	}
	
	public WebElement cardnumber()
	{
		return driver.findElement(cardnumber);
	}
	
	public WebElement addressname()
	{
		return driver.findElement(addressname);
	}
	
	public WebElement Deleteaddress()
	{
		return driver.findElement(Deleteaddress);
	}
	
	public WebElement ConfirmDeleteaddress()
	{
		return driver.findElement(ConfirmDeleteaddress);
	}
	
	
}
