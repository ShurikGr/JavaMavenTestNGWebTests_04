
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WebTest {

    public static final String URL = "http://www.99-bottles-of-beer.net/";

    @BeforeMethod
    protected void beforeMethod() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/admin/IdeaProjects/chromedriver";
        System.setProperty(chromeDriver, driverPath);
    }

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
    public void test_TC_11_01() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement h1 = driver.findElement(
                By.xpath("//div[@id='header']/h1"));

        Assert.assertEquals(h1.getText(), "99 Bottles of Beer");

        driver.quit();
    }

    @Test
    public void test_TC_11_02() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement liLast = driver.findElement(
                By.xpath("//ul[@id='menu']/li[last()]"));

        Assert.assertEquals(liLast.getText(), "SUBMIT NEW LANGUAGE");

        driver.quit();
    }

    @Test
    public void test_TC_11_03() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']/li[last()]")).click();
        WebElement subtitle = driver.findElement(By.id("submenu"));

        Assert.assertEquals(subtitle.getText(), "Submit New Language");

        driver.quit();
    }

    @Test
    public void test_TC_11_04() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/abc.html");
        WebElement first = driver.findElement(
                By.xpath("//ul[@id='submenu']/li[1]"));

        Assert.assertEquals(first.getText(), "0-9");

        driver.quit();
    }

    @Test
    public void test_TC_11_06() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//div[@id='main']//a[@href='./team.html']")).click();
        WebElement firstAuthor = driver.findElement(
                By.xpath("//div[@id='main']/h3[1]"));
        WebElement secondAuthor = driver.findElement(
                By.xpath("//div[@id='main']/h3[2]"));
        WebElement thirdAuthor = driver.findElement(
                By.xpath("//div[@id='main']/h3[3]"));

        Assert.assertEquals(firstAuthor.getText(), "Oliver Schade");
        Assert.assertEquals(secondAuthor.getText(), "Gregor Scheithauer");
        Assert.assertEquals(thirdAuthor.getText(), "Stefan Scheler");

        driver.quit();
    }

    @Test
    public void test_TC_11_07() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']//a[@href='/search.html']")).click();
        WebElement search = driver.findElement(
                By.xpath("//div[@id='main']//input[@name='search']"));
        search.sendKeys("java" + Keys.ENTER);
        driver.findElement(
                By.xpath("//table[@id='category']//a[@href='/language-java-4.html']")).click();
        driver.findElement(
                By.xpath("//div[@id='main']/p/a[@href='#addcomment']")).click();
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Shurik");
        WebElement captcha = driver.findElement(
                By.xpath("//input[@name='captcha']"));
        captcha.sendKeys("25687");
        WebElement textArea = driver.findElement(By.xpath("//textarea"));
        textArea.sendKeys("Спасибо!");
        driver.quit();
    }

    @Test
    public void test_TC_11_11() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']" +
                        "//a[@href='/submitnewlanguage.html']")).click();
        WebElement submit = driver.findElement(
                By.xpath("//input[@type='submit']"));
        submit.click();
        WebElement errorText = driver.findElement(
                By.xpath("//div[@id='main']/p"));

        Assert.assertEquals(errorText.getText(),
                "Error: Precondition failed - Incomplete Input.");

        driver.quit();
    }

    @Test
    public void test_TC_11_12() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']" +
                        "//a[@href='/submitnewlanguage.html']")).click();
        WebElement submit = driver.findElement(
                By.xpath("//input[@type='submit']"));
        submit.click();
        WebElement errorText = driver.findElement(
                By.xpath("//div[@id='main']/p"));
        String str = errorText.getText();

        String[] arr = str.split(" ");

        driver.quit();
        //TODO
    }

    @Test
    public void test_TC_11_13() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html");
        WebElement text = driver.findElement(
                By.xpath("//div[@id=\"main\"]/ul/li[1]"));
        String expectedResult = "IMPORTANT: Take your time! The more " +
                "carefully you fill out this form (especially the language " +
                "name and description), the easier it will be for us and " +
                "the faster your language will show up on this page. " +
                "We don't have the time to mess around with fixing your " +
                "descriptions etc. Thanks for your understanding.";

        Assert.assertEquals(text.getText(), expectedResult);

        driver.quit();
    }

    @Test
    public void test_TC_11_14() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")).click();
        WebElement nameOne = driver.findElement(By.xpath("//table//th[1]"));
        WebElement nameTwo = driver.findElement(By.xpath("//table//th[2]"));

        Assert.assertEquals(nameOne.getText(), "Language");
        Assert.assertEquals(nameTwo.getText(), "Author");

        driver.quit();
    }

    @Test
    public void test_TC_11_15() {
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(
                By.xpath("//ul[@id='menu']/li" +
                        "/a[@href='/toplist.html']")).click();
        driver.findElement(
                By.xpath("//ul[@id='submenu']/li[last()]/a")).click();
        WebElement text = driver.findElement(By.xpath("//div[@id='main']/p"));

        Assert.assertEquals(text.getText(), "");
        driver.quit();
    }

    @Test
    public void test_TC_11_21() {
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.99-bottles-of-beer.net/submitnewlanguage.html ");
        WebElement text = driver.findElement(By.xpath("//div[@id='main']//span"));

        Assert.assertEquals(text.getAttribute("style"),
                "background-color: red; color: white;");

        driver.quit();
        //TODO
    }
}