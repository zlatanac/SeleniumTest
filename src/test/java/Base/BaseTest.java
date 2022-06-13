package Base;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;

    //ubacujemo excel reader za iscitavanje username i password
    public ExcelReader excelReader;



    @BeforeClass

    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wdwait);
        excelReader = new ExcelReader("C:\\Users\\Zlatana\\Desktop\\TestData.xlsx");
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);


    }
        public void visibilityWait(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
        }


    @AfterClass

    public void tearDown(){
        //driver.close();
        //driver.quit();
    }



}
