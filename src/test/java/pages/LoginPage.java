package pages;

import Util.BaseUtil;
import Util.ConfigReader;
import Util.LogUtil;
import Util.WaitUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sadiq on 15/10/16.
 */
public class LoginPage extends BasePage {

    /** Login Page
     * UI Elements
     */


    @FindBy(linkText = "Log In")
    public WebElement loginLink;

    @FindBy(xpath = "//span[contains(text(),'Get access')]")
    public WebElement loginOverlay;

    @FindBy(xpath = "//button[contains(text(),'✕')]")
    public WebElement closeLoginOverlay;

    @FindBy(xpath = "//input[@class='_2zrpKA']")
    public WebElement username;


    @FindBy(xpath = "//input[@class='_2zrpKA _3v41xv']")
    public WebElement password;


    @FindBy(xpath = "//button//span[contains(text(),'Login')]")
    public WebElement loginButton;


    @FindBy(xpath = ".//a[contains(text(),'Hi')]")
    public WebElement validLogin;


    /*
    private static final String DEFAULT_USERNAME = ConfigReader.get("default_userName");
    private static final String DEFAULT_PASSWORD = ConfigReader.get("default_password");
    */
    public void init(){
        PageFactory.initElements(driver, this);
    }


    public void openWebApp(){
        hitURL(ConfigReader.get("homeURL"));
    }


    public void loginOverlayIsDisplayed(){
        loginLink.click();
        WaitUtil.sleep(300);
        loginOverlay.isDisplayed();
        WaitUtil.sleep(500);
    }


    public void closeLoginOverlay(){
        closeLoginOverlay.click();
        WaitUtil.sleep(200);
    }

    /*
    public void login(){
        login(DEFAULT_USERNAME, DEFAULT_PASSWORD);

    }*/

    public void login(String userName, String password){

        try {
            sendKeysByWebElement(this.username, userName);
            WaitUtil.sleep(100);
            sendKeysByWebElement(this.password, password);
            WaitUtil.sleep(100);
            loginButton.click();
            WaitUtil.sleep(400);
        } catch (NullPointerException e){
            LogUtil.error(e.getMessage());
        } catch (ElementNotVisibleException e){
            LogUtil.error(e.getMessage());
        }
    }



}
