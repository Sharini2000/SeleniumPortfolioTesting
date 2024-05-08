****Portfolio Testing Project**

This project consists of tests designed to evaluate a self-created portfolio website. The tests use Selenium WebDriver, TestNG, and Apache POI in Java.

**Project Structure**

- **com.My_Portfolio_Testing** package contains test classes and utilities.
- **ScreenshotsWordSetup.java**: Captures and embeds screenshots into a Word document.
- **TestListener.java**: Implements TestNG listeners for test monitoring.
- **PortfolioContentsTestPart1.java, PortfolioContentsTestPart2.java, PortfolioContentsTestPart3.java**: Test classes for different portfolio sections.
- **ReportManager.java, ReportTestManager.java**: Manages ExtentReports for test reporting.

**Dependencies**

- Java 8 or higher
- Selenium WebDriver
- TestNG
- Apache POI
- AventStack ExtentReports

**Running Tests**

1. Open project in IDE.
2. Run test classes or suite with TestNG.
3. View console logs and ExtentReports for results.

**Test Execution**

- **PortfolioContentsTestPart1**: Tests Home, About Me, and Skills sections.
- **PortfolioContentsTestPart2**: Tests Certifications and Projects.
- **PortfolioContentsTestPart3**: Tests Contact section, email, phone, and links.
- **TestListener**: Logs test status during execution.
- **ScreenshotsWordSetup**: Manages screenshots in Word format.
