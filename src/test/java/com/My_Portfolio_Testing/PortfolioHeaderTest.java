package com.My_Portfolio_Testing;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners({ TestListener.class })
public class PortfolioHeaderTest {
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
    public void portfolio() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement portfolioElement = driver.findElement(By.xpath("//a[@class='logo']"));
        String portfolioText = portfolioElement.getText();
        
        if ("Portfolio".equals(portfolioText)) {
            System.out.println("Portfolio: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Portfolio: expected matches actual", driver);           
        } else {
            System.out.println("Portfolio : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Portfolio text is not spelled correctly as Portfolio", driver);
            throw new AssertionError("Portfolio text is not spelled correctly as Portfolio");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void home() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        Thread.sleep(4000);
        String expectedHome = home.getText();
        

        if ("Home".equals(expectedHome)) {
            System.out.println("Home: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Home: expected matches actual", driver);
            
           
        } else {
            System.out.println("Home : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Home : expected does not match the actual", driver);
            throw new AssertionError("Home text is not spelled correctly as Home");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }

    @Test(priority = 3)
    public void homeColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
    	String homeColorBefore = home.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(home).perform();
	     String homecolorAfter = home.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!homeColorBefore.equals(homecolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Home color change on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Home  text color did not change when hovered over", driver);
	            
	           
	            throw new AssertionError("Home  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    @Test(priority = 4)
    public void About() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
        Thread.sleep(4000);
        String expectedAbout = about.getText();
        

        if ("About".equals(expectedAbout)) {
            System.out.println("About: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "About: expected matches actual", driver);
            
           
        } else {
            System.out.println("About : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "About text is not spelled correctly as About", driver);
            throw new AssertionError("About text is not spelled correctly as About");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }
    @Test(priority = 5)
    public void aboutColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
    	String aboutColorBefore = about.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(about).perform();
	     String aboutcolorAfter = about.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!aboutColorBefore.equals(aboutcolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "About color changed on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "About_colorchange", driver);
	            
	           
	            throw new AssertionError("About  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    @Test(priority = 6)
    public void Skills() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement skills = driver.findElement(By.xpath("//a[normalize-space()='Skills']"));
        Thread.sleep(4000);
        String actualSkill = skills.getText();
        

        if ("Skills".equals(actualSkill)) {
            System.out.println("Skill: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Skill header Text Test", driver);
            
           
        } else {
            System.out.println("Skill : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Skill header Text Test", driver);
            throw new AssertionError("Skill text is not spelled correctly as skill");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }
    @Test(priority = 7)
    public void skillColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement skills = driver.findElement(By.xpath("//a[normalize-space()='Skills']"));
    	String skillColorBefore = skills.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(skills).perform();
	     String skillcolorAfter = skills.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!skillColorBefore.equals(skillcolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Skill color changed on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Skill color change on hover", driver);
	            
	           
	            throw new AssertionError("Skill  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    @Test(priority = 8)
    public void Certifications() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement cert = driver.findElement(By.xpath("//a[normalize-space()='Certifications']"));
        Thread.sleep(4000);
        String actualCert = cert.getText();
        

        if ("Certifications".equals(actualCert)) {
            System.out.println("Certifications: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Certifications header Text Test", driver);
            
           
        } else {
            System.out.println("Certifications : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Certifications header Text Test", driver);
            throw new AssertionError("Certifications text is not spelled correctly as skill");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }
    @Test(priority = 9)
    public void certColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement cert = driver.findElement(By.xpath("//a[normalize-space()='Certifications']"));
    	String certColorBefore = cert.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(cert).perform();
	     String certcolorAfter = cert.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!certColorBefore.equals(certcolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Certifications color changed on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Certifications color change on hover", driver);
	            
	           
	            throw new AssertionError("Certifications  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    @Test(priority = 10)
    public void Projects() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement proj = driver.findElement(By.xpath("//a[normalize-space()='Projects']"));
        Thread.sleep(4000);
        String actualProj = proj.getText();
        

        if ("Projects".equals(actualProj)) {
            System.out.println("Projects: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Projects header Text Test", driver);
            
           
        } else {
            System.out.println("Projects : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Projects header Text Test", driver);
            throw new AssertionError("Projects text is not spelled correctly as skill");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }
    @Test(priority = 11)
    public void ProjectColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement proj = driver.findElement(By.xpath("//a[normalize-space()='Projects']"));
    	String projColorBefore = proj.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(proj).perform();
	     String projcolorAfter = proj.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!projColorBefore.equals(projcolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Projects color changed on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Projects  text color did not change when hovered over", driver);
	            
	           
	            throw new AssertionError("Projects  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    @Test(priority = 12)
    public void Contact() throws InterruptedException, IOException, InvalidFormatException, XmlException {

        WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
        Thread.sleep(4000);
        String actualcontact = contact.getText();
        

        if ("Contact".equals(actualcontact)) {
            System.out.println("Contact: expected matches actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Contact header Text Test", driver);
            
           
        } else {
            System.out.println("Contact : expected does not match the actual");
            setup.captureScreenshot(ScreenshotNames[array_increment] = "Contact header Text Test", driver);
            throw new AssertionError("Contact text is not spelled correctly as skill");
        }
        setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
        array_increment++;
        
    }
    @Test(priority = 13)
    public void ContactColorTest() throws InterruptedException, InvalidFormatException, IOException, XmlException {
    	WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Projects']"));
    	String contactColorBefore = contact.getCssValue("color");
    	Thread.sleep(2000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(contact).perform();
	     String contactcolorAfter = contact.getCssValue("color");
	     Thread.sleep(3000);

	        // Compare the colors
	     if (!contactColorBefore.equals(contactcolorAfter)) {
	            System.out.println("The color changed upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Contact color changed on hover", driver);	           
	          } 
	     else {
	            System.out.println("The color did not change upon hover.");
	            setup.captureScreenshot(ScreenshotNames[array_increment] = "Contact  text color did not change when hovered over", driver);
	            
	           
	            throw new AssertionError("Contact  text color did not change when hovered over");
	        }
	     	setup.saveScreenshotsToWordDocument("Portfolio_Header_Test Report",ScreenshotNames);
	        array_increment++;
	       
    }
    
    @AfterMethod
    public void tearDown() throws InvalidFormatException, IOException {
    	
        driver.quit();
        
    }    
     
}
