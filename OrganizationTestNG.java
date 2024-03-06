package VtigerCRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class OrganizationTestNG extends BaseClass {
	
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();

	@Test
	public void OrganizationTest() throws IOException, InterruptedException {
		
		// To read data from excel file
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);

		

		
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

		
	}
}
