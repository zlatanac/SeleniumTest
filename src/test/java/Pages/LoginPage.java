package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement loginButton;


    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }


    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("#login > button > i"));
    }

   //-------------------------------------------------------------


    public void insertUsername(String username){
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }

    public void insertPassword(String password){
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }

    public void clickOnLoginButton(){
        this.getLoginButton().click();
    }




}
