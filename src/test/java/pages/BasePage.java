package pages;

import Util.ConfigReader;
import Util.LogUtil;
import Util.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import scenarios.BaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sadiq on 15/10/16.
 */
public class BasePage {

    public static WebDriver driver;
    public static Logger _log = LoggerFactory.getLogger(BasePage.class);

    private static final String BROWSER = "browser";
    private static final String INTERNET_EXPLORER = "ie";
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    protected static BasePage selenium;



    protected BasePage() {
        String browser = ConfigReader.get(BROWSER, FIREFOX);
        if (CHROME.equalsIgnoreCase(browser)) {
            String chromePath = ConfigReader.get("chromedriver.path");
            System.setProperty("webdriver.chrome.driver", chromePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

        } else if (INTERNET_EXPLORER.equalsIgnoreCase(browser)) {
            driver = new InternetExplorerDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().window().setPosition(new Point(0, 0));
        Dimension d = new Dimension(1300, 900);
        driver.manage().window().setSize(d);

    }

    public static BasePage getInstance() {
        if (selenium == null) {
            selenium = new BasePage();
        }
        return selenium;
    }




    protected void sendKeysByWebElement(WebElement element, String value) {
        try {
            WaitUtil.sleep(500);
            element.isDisplayed();
            element.clear();
            element.click();
            element.sendKeys(value);
            WaitUtil.sleep(500);
        } catch (NullPointerException e){
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        } catch (InvalidSelectorException e){
            LogUtil.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private String getText(WebElement element) {
        return element.getText();
    }

    public void hitURL(String url) {
        driver.get(url);}

    public void quit() {
        driver.quit();
        selenium = null;
    }
}
