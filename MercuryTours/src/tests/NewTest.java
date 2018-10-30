package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pages.MercuryReservation;
import pages.WelcomePage;
import utils.ExcelUtils;

public class NewTest {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("Browser")
	public void setup(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\jay\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\jay\\Documents\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		  driver.get("http://newtours.demoaut.com/");
		  driver.manage().window().maximize();
		
	}
	
	
  @Test
  public void TC01() throws Exception {
	  
	  WelcomePage login = new WelcomePage(driver);
	  MercuryReservation flightReservation = new MercuryReservation(driver);
	  String excelPath, sheetName;
	  
	  excelPath="C:\\Users\\jay\\eclipse-workspace\\MercuryTours\\TestData\\mercuryToursData.xlsx";
	  sheetName="Users";
	  
	  ExcelUtils.setExcelFile(excelPath, sheetName);
	  
	  login.typeUserName(ExcelUtils.getCellValue(1,0));
	  login.typePassword(ExcelUtils.getCellValue(1,1));
	  login.clickSignIn();
	  Thread.sleep(3000);
	  flightReservation.selectTripType("oneway");
	 // login.clickOnRegisterLink();
	  Thread.sleep(2000);
	  
	  
	  
  }
 
  @AfterTest
  public void tearDown()
  {
	  driver.close();
  }
}
