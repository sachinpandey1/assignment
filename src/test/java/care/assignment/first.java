package care.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class first {
	
public static void main(String args[]) throws InterruptedException{
		
	    System.setProperty( "webdriver.chrome.driver", ".\\lib\\chromedriver.exe" );
	//	System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Sachin\\workspace\\assignment\\lib\\chromedriver.exe" );

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
		Thread.sleep(2000);
		
//  Adding new note - 1
		driver.findElement(By.xpath("//a/img[@title='Add new note in my personal notebook']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='note_title']")).sendKeys("Notes_1");
		
		//  Click Create note Button
		driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
		Thread.sleep(3000);
		String check1 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Notes_1')] ")).getText();
		
		if ( check1.equals("Notes_1") ){
			System.out.println(" Notes_1 is Added");
		}else{ System.out.println(" Notes is NOT there : " + check1); }
		Thread.sleep(1000);
			
	// Editing Note - 1
		driver.findElement(By.xpath("//h3 [contains(text(), 'Notes_1' )]//descendant::a")).click();
	                //  Adding Value new note - 1
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='form-control'] ")).clear() ;
			driver.findElement(By.xpath(" //input[@class='form-control']  ")).sendKeys("Hello World, this is Edited Note");
			Thread.sleep(1500);
			//  Click Create note Button
			driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
			Thread.sleep(3000);
			String check2 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Hello World, this is Edited Note')] ")).getText();
			
			if ( check2.equals("Hello World, this is Edited Note") ){
				System.out.println(" 'Hello World, this is Edited Note ' is now Added");
			}else{ System.out.println(" Notes is NOT there : " + check2); }
			Thread.sleep(1000);
		
//  Adding new note - 2
			driver.findElement(By.xpath("//a/img[@title='Add new note in my personal notebook']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='note_title']")).sendKeys("Selenium Jar file in Java");
			
			//  Click Create note Button
			driver.findElement(By.xpath(" //button[@name='SubmitNote'] ")).click();
			
			Thread.sleep(3000);
			
			String check3 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Selenium Jar file in Java')] ")).getText();
			if ( check3.equals("Selenium Jar file in Java") ){
				System.out.println(" 'Selenium Jar file in Java' is Added");
			}else{ System.out.println(" Notes is NOT there : "+check3); }
			
			Thread.sleep(1000);
			
			
		//  Deleting Note - 1
			driver.findElement(By.xpath("//h3 [contains(text(), 'Hello World, this is Edited Note' )]//descendant::a//following::a")).click();
			Alert alertobject1 = driver.switchTo().alert();
			Thread.sleep(1500);
			alertobject1.accept();
			try{
				String check4 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Hello World, this is Edited Note')] ")).getText();
				if ( check4.equals("Hello World, this is Edited Note") ){
					System.out.println(" 'Hello World, this is Edited Note' is Not Deleted");
				}
			}
			catch(Exception e){
				System.out.println(" 'Hello World, this is Edited Note' is now DELETED : ");
			}


			
			Thread.sleep(2500);
			
		//  Deleting Note - 2
			driver.findElement(By.xpath("//h3 [contains(text(), 'Selenium Jar file in Java' )]//descendant::a//following::a")).click();
			Alert alertobject2 = driver.switchTo().alert();
			Thread.sleep(1500);
			alertobject2.accept();
			try{
				String check5 = driver.findElement(By.xpath(" //h3 [contains(text(), 'Selenium Jar file in Java')] ")).getText();
				if ( check5.equals("Selenium Jar file in Java") ){
					System.out.println(" 'Selenium Jar file in Java' is Not Deleted");
				}
			}
			catch(Exception e){
				System.out.println(" 'Selenium Jar file in Java' is now DELETED : ");
			}
			
			Thread.sleep(2500);
			
		// Logout		
			driver.findElement(By.xpath(" //a/img[@class = 'img-circle' and @alt = 'sachin jeera'] ")).click();
			Thread.sleep(2500);
			driver.findElement(By.xpath(" //a[@id = 'logout_button' ] ")).click();
			Thread.sleep(2500);
			
		
		// close the current browser and also close any all pop up 
		driver.quit();
		
		
	}

}
