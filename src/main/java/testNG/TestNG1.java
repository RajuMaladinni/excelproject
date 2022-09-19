package testNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;




public class TestNG1 {
	@BeforeMethod
	public void BeforeMethod() {
		
	}

	@BeforeSuite
	public void BeforeSuiteMethod() {

	}
	@BeforeClass
	public void beforeClassMethod() {
		
	}
	@BeforeTest
	 public void AfterTest() {
		 
	 }
	
	@BeforeMethod
	public void AfterMethod() {
		
	}

	@BeforeSuite
	public void AfterSuiteMethod() {
		
	}
	@BeforeClass
	public void AfterClassMethod() {
		
	}
	@BeforeTest
	 public void BeforeTest() {
		 
	 }

	

}
