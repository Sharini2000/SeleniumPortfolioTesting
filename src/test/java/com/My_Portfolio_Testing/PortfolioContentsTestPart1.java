package com.My_Portfolio_Testing;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
@Listeners({ TestListener.class })

public class PortfolioContentsTestPart1 {
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
    public void Home() throws IOException, InterruptedException, XmlException {
    	
    	WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
    	home.click();
    	WebElement name = driver.findElement(By.cssSelector("div[class='home-content'] h1"));
    	String actual_name = name.getText();
    	if ("Sharini Rithigaa Baranisrinivasan Sumalatha".contains(actual_name)) {
    		System.out.println("Navigated to home section when home element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to home section when home element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to home section when home element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Doesn't navigate to home section when home element is clicked", driver);
            throw new AssertionError("Doesn't navigate to home section when home element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part1",ScreenshotNames);
    	array_increment++;
    }
    @Test(priority = 2)
    public void About() throws IOException, InterruptedException, XmlException {
    	WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
    	about.click();
    	 Thread.sleep(2000); 
    	WebElement abouttxt = driver.findElement(By.cssSelector("section[id='about'] h2:nth-child(1)"));
    	String actual_text = abouttxt.getText();
    	if ("AboutMe".contains(actual_text)) {
    		System.out.println("Navigated to about section when about element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to about section when about element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to about section when about element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "About_Section", driver);
            throw new AssertionError("Doesn't navigate to about section when about element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part1",ScreenshotNames);
    	array_increment++;
    	WebElement imageElement = driver.findElement(By.xpath("//img[@alt=\"It's Me\"]"));
    	// Check if the image element exists
        if (imageElement != null) {
            System.out.println("Image is present on the webpage.");

            // Verify if the image has loaded
            Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                    imageElement);

            if (imageLoaded) {
                System.out.println("Image has loaded successfully.");
                setup.captureScreenshot(ScreenshotNames[array_increment] = "Image has loaded successfully", driver);
            } else {
                System.out.println("Image failed to load.");
                setup.captureScreenshot(ScreenshotNames[array_increment] = "About_Image", driver);
            }
        } else {
            System.out.println("Image is not present on the webpage.");
        }
        setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part1",ScreenshotNames);
        array_increment++;
    }
    @Test(priority = 3)
    public void Skills() throws IOException, InterruptedException, XmlException {
    	WebElement skills = driver.findElement(By.xpath("//a[normalize-space()='Skills']"));
    	skills.click();
    	WebElement skilltitle = driver.findElement(By.cssSelector("h1[class='sub-title'] span"));
    	String actual_txt = skilltitle.getText();
    	if ("MySkills".contains(actual_txt)) {
    		System.out.println("Navigated to skills section when skills element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Navigated to skills section when skills element is clicked", driver);
        } else {
        	System.out.println("Doesn't navigate to skill section when skill element is clicked");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Doesn't navigate to skill section when skill element is clicked", driver);
            throw new AssertionError("Doesn't navigate to home section when home element is clicked");
        } 
    	setup.saveScreenshotsToWordDocument("Contents_Test_Result_Part1",ScreenshotNames);
    	array_increment++;
    }
    @AfterMethod
    public void tearDown() throws InvalidFormatException, IOException {
    	
        driver.quit();
        
    }

}
