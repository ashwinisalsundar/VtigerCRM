package VtigerCRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplimentation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class Orgnization {

	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();

	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		// WebDriver object creation
		WebDriver driver = new ChromeDriver();
		// To maximize the window
		wutil.maximize(driver);
		// To apply wait for findElement()
		wutil.implicitwait(driver);

		// To read the data from property file(i.e. LoginCredencials.properties)
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");

		// To read data from excel file
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);

		// To launch the application
		driver.get(URL);

		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Click on Orgnizations
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

		// Click on create orgnization '+' icon
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		// Enter orgnization name using excel sheet
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME + jutil.getRandomNumber());

		// Click on assignedto click on group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		

		// In the droupdown select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(dropdown, GROUP);

		// Click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

		Thread.sleep(2000);
		// Mouse hover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);

		// Click on signout button
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
