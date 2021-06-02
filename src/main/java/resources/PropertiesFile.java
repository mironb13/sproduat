package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropertiesFile {
	
	static Properties properties;
	protected static WebDriver driver;
	
	public static void loadData() throws IOException
	{
		properties = new Properties();
		File f = new File("C:\\Users\\meironb\\eclipse-workspace1\\sprod-main2\\data.properties");
		FileReader obj = new FileReader(f);	
		properties.load(obj);
		
	}

	public static String getObject(String Data) throws IOException
	
	{
		loadData();
		String data = properties.getProperty(Data);	
		return data;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

	
	
}
