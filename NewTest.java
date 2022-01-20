package Day_012_TestNG_Paraneters;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class NewTest {
	
	 static WebDriver driver;
	 
@Parameters({"Browser","UserName","Password","jobtitle","jobdecsr","jobnote"})
 @Test
 public void login_Test(String Browser, String Username,String Password,String jobtitle,String jobdecsr,String jobnote) throws Exception {
	  
	  
	  if(Browser.equalsIgnoreCase("Chrome"))
		{
			
		    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 	driver =new ChromeDriver();
	 	 	driver.manage().window().maximize() ;	
	    }

		if(Browser.equalsIgnoreCase("FireFox"))
		{
				driver = TestBrowser.OpenFirefoxBrowser();
				Thread.sleep(5000);
		}
			
		NewTest.OpenOrangeHRM();
		NewTest.Login(Username,Password);
		NewTest.Add_jobs(jobtitle,jobdecsr,jobnote);
		driver.quit();
      }
		public static void OpenOrangeHRM () throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		}
		
		public static void Login (String UserName,String Password) throws Exception {
		findElement(By.id("txtUsername")).sendKeys(UserName);
		findElement(By.id("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
		}
		
		public static void Add_jobs(String jobtitle,String jobdecsr,String jobnote) throws Exception {
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(jobtitle);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(jobdecsr);
		findElement(By.id("jobTitle_note")).sendKeys(jobnote);
		findElement(By.id("btnSave")).click();
		}
		
		public static  WebElement findElement(By by) throws Exception 
		{
					
			 WebElement elem = driver.findElement(by);    	    
			
			 
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			
			return elem;
		}

}

