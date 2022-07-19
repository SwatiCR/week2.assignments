package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignUp {

	public static void main(String[] args) {
		FaceBook:
			================================
			// Step 1: Download and set the path 
			// Step 2: Launch the chromebrowser
			// Step 3: Load the URL https://en-gb.facebook.com/
			// Step 4: Maximise the window
			// Step 5: Add implicit wait
			// Step 6: Click on Create New Account button
			// Step 7: Enter the first name
			// Step 8: Enter the last name
			// Step 9: Enter the mobile number
			// Step 10: Enterthe password
			// Step 11: Handle all the three drop downs
			// Step 12: Select the radio button "Female" 
			// ( A normal click will do for this step) 
			
		// We have to call WDM for the browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://en-gb.facebook.com/");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		//create new account
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();		

		//first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("swati");		

		//Surname name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("CR");

		//Mobile no or email id
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("swaticr@gmail.com");

		//reenter email
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("swaticr@gmail.com");

		//password
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("IshaBaby");

		//Check for Drop Down Date
		WebElement dropdown1 = driver.findElement(By.id("day"));

		//Convert to Select
		Select date = new Select(dropdown1);

		//Select selectByVisibleText
		date.selectByVisibleText("20");
		
		//Check for drop down month
		WebElement dropdown2 = driver.findElement(By.id("month"));
		
		//convert to select
		Select month = new Select(dropdown2);
		
		//Select selectByVisibleText
		month.selectByVisibleText("Dec");
		
		//Check for drop down year
		WebElement dropdown3 = driver.findElement(By.id("year"));
		
		//convert to select class
		Select year = new Select(dropdown3);
		
		//Select selectByVisibleText
		year.selectByVisibleText("2020");
		
		//To select female gender
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
