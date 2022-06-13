import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Test1 {

    //Prvo sam uradila na ovaj nacin, jer sam sigurnija, tj. to sam vise vezbala,
    //pa sam posle prebacila u pom

    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
       }

    @Test
    public void succesfulLogin(){
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("#login > button > i"));
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.cssSelector("#content > div > a > i"));
        WebElement secureAreaText = driver.findElement(By.cssSelector("#content > div > h2"));

        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertEquals(secureAreaText.getText(), "Secure Area");


    }

    @Test
    public void unsuccesfulLoginInvalidUsername(){
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("blabla");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.cssSelector("#login > button > i"));
        loginButton.click();

        WebElement invalidUsernameNotification = driver.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(invalidUsernameNotification.isDisplayed());

    }

    @AfterMethod
    public void removeCookies(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
       // driver.quit();
    }

}
