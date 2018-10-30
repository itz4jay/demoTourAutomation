package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.RepositoryParser;

public class WelcomePage {
	
	private static RepositoryParser orParser;
	WebDriver driver;
	WebElement ele;
	
	public WelcomePage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		orParser = new RepositoryParser("C:\\Users\\jay\\eclipse-workspace\\MercuryTours\\ObjectRepository\\MercuryOR.properties");
		
	}
	
	
	public void typeUserName(String uName)
	{
		ele = driver.findElement(orParser.getObjectLocator("txtBoxUN"));
		ele.sendKeys(uName);
	}
	
	public void typePassword(String pWord)
	{
		ele = driver.findElement(orParser.getObjectLocator("txtBoxPW"));
		ele.sendKeys(pWord);
	}
	
	public void clickSignIn()
	{
		ele = driver.findElement(orParser.getObjectLocator("btnSignIn"));
		ele.click();
	}
	
	public void clickOnRegisterLink()
	{
		ele = driver.findElement(orParser.getObjectLocator("linkRegister"));
		ele.click();
	}
	
}
