package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {



    @BeforeMethod

    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void succesfullogin() throws InterruptedException {

    String validUsername = excelReader.getStringData("Login", 1, 0);
    String validPassword = excelReader.getStringData("Login", 1, 1);

    loginPage.insertUsername(validUsername);
    loginPage.insertPassword(validPassword);
    Thread.sleep(2000);
    loginPage.clickOnLoginButton();

     WebElement logoutButton = driver.findElement(By.cssSelector("#content > div > a > i"));
     WebElement secureAreaText = driver.findElement(By.cssSelector("#content > div > h2"));

     Assert.assertTrue(logoutButton.isDisplayed());
     Assert.assertEquals(secureAreaText.getText(), "Secure Area");

    }

//Nisam stigla da uradim u pomu invalid login :(


}
