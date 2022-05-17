import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    protected void beforeMethod() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/admin/IdeaProjects/chromedriver";
        System.setProperty(chromeDriver, driverPath);
    }
}