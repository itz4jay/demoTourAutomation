package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.RepositoryParser;

public class MercuryReservation {
	
	private static RepositoryParser orParser;
	WebDriver driver;
	WebElement element;
	
	public MercuryReservation(WebDriver driver) throws IOException
	{
		this.driver = driver;
		orParser = new RepositoryParser("C:\\Users\\jay\\eclipse-workspace\\MercuryTours\\ObjectRepository\\MercuryOR.properties");
		System.out.println("OR Parser Loaded");
	}
	
	public void selectTripType(String tripType) 
	{
		List <WebElement> elements=driver.findElements(orParser.getObjectLocator("radioTripType"));
		System.out.println("element List created");
		if(tripType.equalsIgnoreCase("roundtrip"))
		{
			elements.get(0).click();
		}else if(tripType.equalsIgnoreCase("oneway"))
		{
			System.out.println("oneway clicked");
			elements.get(1).click();
			
		}
	}
	
	
	

}
