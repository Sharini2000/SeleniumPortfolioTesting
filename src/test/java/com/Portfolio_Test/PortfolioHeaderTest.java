package com.Portfolio_Test;




import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class PortfolioHeaderTest {
    public static String[] ScreenshotNames = new String[100];
    public static int array_increment = 0;
    public static WebDriver driver;
    public ScreenshotsWordSetup setup = new ScreenshotsWordSetup();
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setUpExtentReports() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\shari\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sharini2000.github.io/My_Portfolio/");
    }

    @Test(priority = 1)
    public void portfolio() throws InterruptedException, IOException, InvalidFormatException, XmlException {
        test = extent.createTest("Portfolio Test");

        WebElement portfolioElement = driver.findElement(By.xpath("//a[@class='logo']"));
        String portfolioText = portfolioElement.getText();

        if ("Portfolio".equals(portfolioText)) {
            System.out.println("Portfolio: expected matches actual");
            test.log(Status.PASS, "Portfolio text is spelled correctly as Portfolio");
        } else {
            System.out.println("Portfolio : expected does not match the actual");
            test.log(Status.FAIL, "Portfolio text is not spelled correctly as Portfolio");
        }
    }

    @Test(priority = 2)
    public void home() throws InterruptedException, IOException, InvalidFormatException, XmlException {
        test = extent.createTest("Home Test");

        WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        Thread.sleep(4000);
        String expectedHome = home.getText();

        if ("Home".equals(expectedHome)) {
            System.out.println("Home: expected matches actual");
            test.log(Status.PASS, "Home text is spelled correctly as Home");
        } else {
            System.out.println("Home : expected does not match the actual");
            test.log(Status.FAIL, "Home text is not spelled correctly as Home");
        }
    }

    @Test(priority = 3)
    public void about() throws InterruptedException, IOException, InvalidFormatException, XmlException {
        test = extent.createTest("About Test");

        WebElement about = driver.findElement(By.xpath("//a[normalize-space()='About']"));
        Thread.sleep(4000);
        String expectedAbout = about.getText();

        if ("About".equals(expectedAbout)) {
            System.out.println("About: expected matches actual");
            test.log(Status.PASS, "About text is spelled correctly as About");
        } else {
            System.out.println("About : expected does not match the actual");
            test.log(Status.FAIL, "About text is not spelled correctly as About");
        }
    }

    // Add more @Test methods for other functionalities

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
    }
}
