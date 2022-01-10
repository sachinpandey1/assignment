package care.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        
    	System.setProperty( "webdriver.chrome.driver", ".\\lib\\chromedriver.exe" );

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // Maximize the browser
		
		driver.navigate().to("http://elearningm1.upskills.in/index.php");
		
	// Login page
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("sachin.jeera.training");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sachin.jeera.training@gmail.com");
		Thread.sleep(2000);
		//  login button click
		WebElement obj1 = driver.findElement(By.name("submitAuth"));
		obj1.click();	
		
	//  Moving to home page
		WebElement obj2 = driver.findElement(By.linkText("Homepage"));
		obj2.click();
		Thread.sleep(2000);
		
	     //WebElement obj3 = driver.findElement(By.xpath("//a/img[@title='Compose message']"));
		//obj3.click();
		
		//   Clicking  JAVA  course
    	WebElement obj3 = driver.findElement(By.xpath("//a/img[@class = 'img-responsive' and @alt = 'Java']"));
	    obj3.click();
	    
	    // Subscribe
	  //h5/a[contains(text(),'web design')]/parent::h5/parent::div/parent::div/div/div/div/a
		
		Thread.sleep(2000);
		
		//  Clicking to  Course Home
		//WebElement obj4 = driver.findElement(By.xpath("//div[@class='session-subscribe']]"));
		//obj4.click();
		driver.findElement(By.linkText("Course home")).click();  
		Thread.sleep(1000);
		driver.findElement(By.linkText("Notebook"));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Notebook")).click();
		
		
//  Adding new note - 1
		driver.findElement(By.xpath("//a/img[@title='Add new note in my personal notebook']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='note_title']")).sendKeys("Notes_1");
		
		//  Click Create note Button
		driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
		Thread.sleep(3000);
		String check = driver.findElement(By.xpath(" //h3 [contains(text(), 'Notes_1')] ")).getText();
		
		if ( check.equals("Notes_1") ){
			System.out.println(" Notes_1 is there");
		}else{ System.out.println(" Notes is NOT there : " + check); }
		Thread.sleep(2000);
		
		
  // Editing Note - 1
		driver.findElement(By.xpath("//h3 [contains(text(), 'Notes_1' )]//descendant::a")).click();
	            //  Adding Value new note - 1
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Notes_1']")).clear() ;
			driver.findElement(By.xpath("//input[@name='note_title']")).sendKeys("Hello World");
			Thread.sleep(1500);
			//  Click Create note Button
			driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
			Thread.sleep(3000);
			String check2 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Hello World')] ")).getText();
			
			if ( check2.equals("Hello World") ){
				System.out.println(" 'Hello World' is now Added");
			}else{ System.out.println(" Notes is NOT there : " + check); }
			Thread.sleep(2000);
		
		
 //  Adding new note - 2
			driver.findElement(By.xpath("//a/img[@title='Add new note in my personal notebook']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='note_title']")).sendKeys("Selenium Jar file in Java");
			
			//  Click Create note Button
			driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
			
			Thread.sleep(3000);
			
			String check1 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Selenium Jar file in Java')] ")).getText();
			if ( check1.equals("Selenium Jar file in Java") ){
				System.out.println(" 'Selenium Jar file in Java' is there");
			}else{ System.out.println(" Notes is NOT there : "+check1); }
			
			Thread.sleep(2000);
			
			
	//  Deleting Note - 1
			driver.findElement(By.xpath("//h3 [contains(text(), 'Hello World' )]//descendant::a//following::a")).click();
			Alert alertobject = driver.switchTo().alert();
			alertobject.accept();	
			Thread.sleep(2000);
			
	//  Deleting Note - 2
			driver.findElement(By.xpath("//h3 [contains(text(), 'Selenium Jar file in Java' )]//descendant::a//following::a")).click();
			Alert alertobject2 = driver.switchTo().alert();
			alertobject2.accept();
			Thread.sleep(2000);
			
			
	//  Log OUT
			driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='logout_button']")).click();
			System.out.println(" Logout successfull ");
			Thread.sleep(2000);
		
			
		
		// close the current browser and also close any all pop up 
		driver.quit();
		
    	  	    	
    }
}
