package com.My_Portfolio_Testing;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners({ TestListener.class })
public class PortfolioContentsTestPart2 {
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
    public void Certifications() throws IOException, InterruptedException, XmlException 
    {
    	WebElement cert = driver.findElement(By.xpath("//a[normalize-space()='Certifications']"));
    	cert.click();
    	Thread.sleep(2000); 
    	WebElement certtitle = driver.findElement(By.xpath("//span[normalize-space()='Certifications']"));
    	String actual_txt = certtitle.getText();
    	if ("MyCertifications".contains(actual_txt)) 
    	{
    		System.out.println("Navigated to certifications section when certification element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to certifications section when certification element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to certification section when certification element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Doesn't navigate to certification section when certification element is clicked", driver);
            throw new AssertionError("Doesn't navigate to certification section when certification element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	Actions ac = new Actions(driver);
    	WebElement button1= driver.findElement(By. xpath("//button[normalize-space()='Microsoft Certified Azure Data Fundamentals']"));
    	ac.moveToElement(button1).build().perform();//Hovers over the button
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Options in list glows when hovered on it", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	button1.click();
    	Thread.sleep(2000);
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Image pops up", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[@class='close']")).click();
    	Thread.sleep(2000);
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Image pop up closed", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	
    	
    }
    @Test(priority = 2)
    public void Projects() throws IOException, InterruptedException, XmlException 
    {
    	WebElement proj = driver.findElement(By.xpath("//a[normalize-space()='Projects']"));
    	proj.click();
    	Thread.sleep(2000); 
    	WebElement projtitle = driver.findElement(By.xpath("//span[normalize-space()='Projects']"));
    	String actual_txt = projtitle.getText();
    	if ("MyProjects".contains(actual_txt)) 
    	{
    		System.out.println("Navigated to project section when project element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to project section when project element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to project section when project element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Doesn't navigate to project section when project element is clicked", driver);
            throw new AssertionError("Doesn't navigate to project section when project element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	Actions ac = new Actions(driver);
    	WebElement button2= driver.findElement(By. xpath("//button[contains(text(),'A study on Software Defined Network enhanced edge-')]"));
    	ac.moveToElement(button2).build().perform();//Hovers over the button
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Options in list glows when hovered on it", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	button2.click();
    	Thread.sleep(2000);
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Image pops up when clicked", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//span[@class='close']")).click();
    	Thread.sleep(2000);
    	setup.captureScreenshot(ScreenshotNames[array_increment] = "Image closed", driver);
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part2",ScreenshotNames);
    	array_increment++;
    	
    	
    }
    @AfterMethod
    public void tearDown() throws InvalidFormatException, IOException {
    	
        driver.quit();
        
    }
}
