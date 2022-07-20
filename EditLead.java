package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
*/
		// We have to call WDM for the browser driver
		WebDriverManager.chromedriver().setup();
		
		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();
		
		//load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//2.Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		
		//3.Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4.click login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		//7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8 Enter first name
		driver.findElement(By.xpath("//div[@class='x-form-item x-tab-item']/div/input[@name='firstName']")).sendKeys("SIVA");
		
		//9	Click Find leads button
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//10 Click on first resulting lead
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//11 Verify title of the page
		String title = driver.getTitle();
		
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println("Title of page verified");
		}
		
		//12 Click Edit
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']/following-sibling::a[text()='Edit']")).click();
		
		//13 Change the company name
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("TestLeaf");
		
		//14 Click Update
		driver.findElement(By.xpath("(//td[@class='label']/following-sibling::td/input[@name='submitButton'])[1]")).click();
		
		//15 Confirm the changed name appears
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text);
		
		if(text.contains("TestLeaf")) {
			System.out.println("Changed name appears");
		}
	}

}
