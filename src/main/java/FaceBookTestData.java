import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookTestData {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()=\"Create New Account\"]")).click();
		
		FileInputStream file = new FileInputStream("C://Users//Admin//Desktop//seleniumEcel//Facebook.xlsx"); 
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet1");
		String Fname = sh.getRow(1).getCell(0).getStringCellValue();
		String Lname = sh.getRow(1).getCell(1).getStringCellValue();
		String gmail = sh.getRow(1).getCell(2).getStringCellValue();
		long pwd = (long) sh.getRow(1).getCell(3).getNumericCellValue();
		int day = (int) sh.getRow(1).getCell(4).getNumericCellValue();
		String month = sh.getRow(1).getCell(5).getStringCellValue();
		int year = (int) sh.getRow(1).getCell(6).getNumericCellValue();
		
		
		driver.findElement(By.xpath("//input[@placeholder=\"First name\"]")).sendKeys(Fname);
		driver.findElement(By.xpath("//input[@aria-label=\"Surname\"]")).sendKeys(Lname);
		driver.findElement(By.xpath("//input[@aria-label=\"Mobile number or email address\"]")).sendKeys(gmail);
		driver.findElement(By.xpath("//input[@aria-label=\"New password\"]")).sendKeys(Long.toString(pwd));
		
//		Select d= new Select( driver.findElement(By.xpath("//select[@name=\"birthday_day\"]")));
//		d.selectByVisibleText(Integer.toString(day));
//		
//		Select m =new Select(driver.findElement(By.xpath("//select[@name=\"birthday_month\"]")));
//		m.selectByVisibleText(month);
//		
//		Select y= new Select( driver.findElement(By.xpath("//select[@name=\"birthday_year\"]")));
//		y.selectByVisibleText(Integer.toString(year));
		
		driver.findElement(By.xpath("//select[@name=\"birthday_day\"]")).sendKeys(Integer.toString(day));
		driver.findElement(By.xpath("//select[@name=\"birthday_month\"]")).sendKeys(month);
		driver.findElement(By.xpath("//select[@name=\"birthday_year\"]")).sendKeys(Integer.toString(year));
	}

}
