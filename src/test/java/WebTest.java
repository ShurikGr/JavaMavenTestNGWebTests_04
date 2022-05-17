import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.Test;

public class WebTest extends BaseTest{
    public static final String URL = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testMenuStartTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        WebElement menuBrowsLanguges = driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']"));
        menuBrowsLanguges.click();
        WebElement menuStart = driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/']"));
        menuStart.click();
        WebElement h2 = driver.findElement(
                By.xpath("//div[@id='main']/h2"));


        String expectedResult = "Welcome to 99 Bottles of Beer";
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testHeader() {
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement h1 = driver.findElement(
                By.xpath("//div[@id='header']/h1"));

        String expectedResult = "99 Bottles of Beer";
        String actualResult = h1.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testLastPointInMenu() {
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement liLast = driver.findElement(
                By.xpath("//ul[@id='menu']/li[last()]"));

        String expectedResult = "SUBMIT NEW LANGUAGE";
        String actualResult = liLast.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}