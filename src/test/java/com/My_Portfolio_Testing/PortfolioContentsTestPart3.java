package com.My_Portfolio_Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners({ TestListener.class })
public class PortfolioContentsTestPart3 {
	public static String[] ScreenshotNames = new String[100];
    public static int array_increment = 0;
    public static WebDriver driver;
    public ScreenshotsWordSetup setup = new ScreenshotsWordSetup();
    
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws InterruptedException {
    	if(browser.equalsIgnoreCase("chrome"))
    	{
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shari\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    	}
    	else if(browser.equalsIgnoreCase("edge"))
    	{
    		System.setProperty("webdriver.edge.driver",
                    "C:\\Users\\shari\\Downloads\\edgedriver_win64\\msedgedriver.exe");
    		 driver = new EdgeDriver();
    	}
        driver.manage().window().maximize();
        driver.get("https://sharini2000.github.io/My_Portfolio/");    
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    public void Contacts() throws IOException, InterruptedException, XmlException 
    {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(2000); 
    	WebElement contacttitle = driver.findElement(By.xpath("//section[@id='contact']//h2[1]"));
    	String actual_txt = contacttitle.getText();
    	if ("ContactMe".contains(actual_txt)) 
    	{
    		System.out.println("Navigated to contact section when contact element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to contact section when contact element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to contact section when contact element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Doesn't navigate to contact section when contact element is clicked", driver);
            throw new AssertionError("Doesn't navigate to contact section when contact element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	driver.quit();
    }
    @Test(priority = 2)
    public void Email_and_number() throws IOException, InterruptedException, XmlException 
    {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(2000);
    	WebElement email = driver.findElement(By.xpath("//li[normalize-space()='sharinibs@gmail.com']"));
    	String actual_txt = email.getText();
    	if ("sharinibs@gmail.com".contains(actual_txt)) 
    	{
    		System.out.println("Email ID is present");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "There is an email ID found in contact section", driver);
        } else {
        	System.out.println("There is no email ID found in contact section");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "There is no email ID found in contact section", driver);
            throw new AssertionError("There is no email ID found in contact section");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	WebElement phone = driver.findElement(By.xpath("//li[normalize-space()='+1 3437779798']"));
    	String actual_text = phone.getText();
    	if ("+1 3437779798".contains(actual_text)) 
    	{
    		System.out.println("Phone number is present");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "There is a phone number found in contact section", driver);
        } else {
        	System.out.println("There is no email ID found in contact section");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "There is no phone number found in contact section", driver);
            throw new AssertionError("There is no phone number found in contact section");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    	driver.quit();
    }
    @Test(priority = 3)
    public void LinkedIN() throws InterruptedException, IOException, XmlException
    {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(2000);
    	WebElement link1 = driver.findElement(By.xpath("//a[normalize-space()='LinkedIn']"));
    	Actions ac = new Actions(driver);
    	ac.keyDown(Keys.SHIFT).click(link1).keyUp(Keys.SHIFT).build().perform();
    	Thread.sleep(6000);
    	String expectedTitle1 = "Sign Up | LinkedIn";
    	String parentwindow = driver.getWindowHandle();
    	Set<String> windows = driver.getWindowHandles();
    	for (String window : windows) 
    	{ 
    		String ActualTitle = driver.getTitle();
    		if(ActualTitle.equals(expectedTitle1))
    		{
    			driver.switchTo().window(window);
    			Thread.sleep(3000);
    			System.out.println("LinkedIN URL Opened");
                
                
    		}
    	}
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "LinkedIN is opened when linkedin link is clicked", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    	
    }
    @Test(priority = 4)
    public void GitHub() throws InterruptedException, IOException, XmlException{
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(3000);
    	WebElement link2 = driver.findElement(By.xpath("//a[normalize-space()='GitHub']"));
    	Actions ac = new Actions(driver);
    	ac.keyDown(Keys.SHIFT).click(link2).keyUp(Keys.SHIFT).build().perform();
    	Set<String> windows1 = driver.getWindowHandles();
    	String expectedgithub = "Sharini2000 (SHARINI RITHIGAA BARANISRINIVASAN SUMALATHA) · GitHub";
    	for (String win : windows1) 
    	{ 
    		
    		String ActualTitle1 = driver.getTitle();
    		if(ActualTitle1.equals(expectedgithub))
    		{
    			driver.switchTo().window(win);
    			Thread.sleep(3000);
    			System.out.println("GitHub URL Opened");
                
               
    		}
    	}
    	
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "GitHub is opened when GitHub link is clicked", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    }
    @Test(priority =5 , dataProvider="getData")
    public void FeedbackForm(String name,String email , String subject, String message, String scenario) throws InterruptedException, IOException, XmlException {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
    	contact.click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@placeholder='Please enter your name']")).sendKeys(name);
    	driver.findElement(By.xpath("//input[@placeholder='Please enter your email address']")).sendKeys(email);
    	driver.findElement(By.xpath("//input[@placeholder='Enter subject here']")).sendKeys(subject);
    	driver.findElement(By.xpath("//textarea[@placeholder='Enter your message here']")).sendKeys(message);
    	driver.findElement(By.xpath("//input[@value='Submit']")).click();
    	Thread.sleep(3000);
    	if (scenario.equalsIgnoreCase("Positive")) 
    	{
    	    String pageTitle = driver.getTitle();
    	    if (pageTitle.equals("Formspree")) 
    	    {
    	        System.out.println("Feedback form submitted successfully");
    	        setup.captureScreenshot(ScreenshotNames[array_increment] = "Feedback form submitted successfully with valid details", driver);
    	    } else 
    	    {
    	        System.out.println("Feedback form does not submit even with valid details");
    	        setup.captureScreenshot(ScreenshotNames[array_increment] = "Feedback form does not submit even with valid details", driver);
    	        throw new AssertionError("Feedback form does not submit even with valid details");
    	    }
    	} 
    	else if(scenario.equalsIgnoreCase("Negative"))
    	{
    		String pageTitle = driver.getTitle();
    	    if (pageTitle.equals("Sharini's Portfolio")) 
    	    {
    	        System.out.println("Feedback form didn't submit due to invalid email");
    	        setup.captureScreenshot(ScreenshotNames[array_increment] = "Feedback form didn't submit due to invalid email", driver);
    	    } else 
    	    {
    	        System.out.println("Feedback form submitted even with invalid details");
    	        setup.captureScreenshot(ScreenshotNames[array_increment] = "Feedback form submitted even with invalid details", driver);
    	        throw new AssertionError("Feedback form submitted even with invalid details");
    	    }	
    	}
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part3",ScreenshotNames);
    	array_increment++;
    }

    	
    
    @DataProvider
	public Object[][] getData() throws IOException {
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/Testdata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
    @AfterMethod
    public void tearDown() throws InvalidFormatException, IOException {
    	
        driver.quit();
        
    }

}
