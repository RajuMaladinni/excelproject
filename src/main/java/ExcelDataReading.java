import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataReading {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
	
		
		
		driver.get("https://www.facebook.com/");
		
		
		
		driver.findElement(By.xpath("//a[text()=\"Create New Account\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		FileInputStream file = new FileInputStream("C://Users//Admin//Desktop//seleniumEcel//Facebook.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheetAt(0);
		String Fname = sh.getRow(1).getCell(0).getStringCellValue();
		String Lname = sh.getRow(1).getCell(1).getStringCellValue();
		String Mnumber =   sh.getRow(1).getCell(2).getStringCellValue();
		long Password =  (long) sh.getRow(1).getCell(3).getNumericCellValue();
		
		
		int day = (int) sh.getRow(1).getCell(4).getNumericCellValue();
		String month = sh.getRow(1).getCell(5).getStringCellValue();
		int year = (int) sh.getRow(1).getCell(6).getNumericCellValue();
		String gender = sh.getRow(1).getCell(7).getStringCellValue();
		
		
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(Fname);
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(Lname);
		driver.findElement(By.xpath("//input[@aria-label=\"Mobile number or email address\"]")).sendKeys((Mnumber));
		driver.findElement(By.xpath("//input[@aria-label=\"New password\"]")).sendKeys(Long.toString(Password));
		
		WebElement da = driver.findElement(By.id("day"));
		WebElement mo = driver.findElement(By.xpath("//select[@name=\"birthday_month\"]"));
		WebElement yr = driver.findElement(By.id("year"));
		
		Select d= new Select(da);
		d.selectByVisibleText(Integer.toString(day));
		
		Select m= new Select(mo);
		m.selectByVisibleText(month);
		
		Select y= new Select(yr);
		y.selectByVisibleText(Integer.toString(year));
		
	
		
		driver.findElement(By.xpath("//label[text()=\""+gender+"\"]/parent::span/input")).click();
				
		
	
		
	}

}
