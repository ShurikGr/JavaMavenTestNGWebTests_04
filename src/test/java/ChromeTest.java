import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {
    @Test
    public void testMenuStartTitle() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/admin/IdeaProjects/chromedriver";
        String url = "https://www.google.ru/";


        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);




//        WebElement consent =
//                driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
//        consent.click();

    }
}
